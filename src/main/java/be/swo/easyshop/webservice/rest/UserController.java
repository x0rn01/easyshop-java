package be.swo.easyshop.webservice.rest;

import be.swo.easyshop.entity.user.User;
import be.swo.easyshop.service.user.UserService;
import be.swo.easyshop.utils.assembler.UserModelAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController // indicates that the data returned by each method will be written straight into the response body instead of rendering a template.
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final UserModelAssembler assembler;

    public UserController(UserService userService, UserModelAssembler assembler) {
        this.userService = userService;
        this.assembler = assembler;
    }

    @GetMapping(path = "/{id}")
    @Transactional(readOnly = true)
    // EntityModel<T> is a generic container from Spring HATEOAS that includes not only the data but a collection of links.
    public EntityModel<User> one(@PathVariable final String id) {
        User user = userService.getUser(id);
        return assembler.toModel(user);
    }

    @GetMapping(path = "/all")
    @Transactional(readOnly = true)
    public CollectionModel<EntityModel<User>> all() {
        List<EntityModel<User>> users = userService.getUsers().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel());

    }

    @GetMapping(path = "/firstname/{firstname}")
    @Transactional(readOnly = true)
    public List<User> findByFirstname(@PathVariable final String firstname) {
        return userService.findByFirstname(firstname);
    }

    @PostMapping (path = "/")
    @Transactional
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping (path = "/{id}")
    @Transactional
    public User updateUser(@PathVariable final String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping (path = "/{id}")
    public void removeUser(@PathVariable final String id) {
        userService.removeUser(id);
    }

}
