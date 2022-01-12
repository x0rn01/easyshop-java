package be.swo.easyshop.webservice.rest;

import be.swo.easyshop.entity.user.User;
import be.swo.easyshop.service.user.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RestController
@RequestMapping("/api/user")
public class UserRESTController {

    private final UserService userService;

    public UserRESTController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON)
    @Transactional(readOnly = true)
    public User getUser(@PathVariable final String id) {
        return userService.getUser(id);
    }

    @GetMapping(path = "/all", produces = APPLICATION_JSON)
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping (path = "/", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    @Transactional
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping (path = "/{id}", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    @Transactional
    public User updateUser(@PathVariable final String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping (path = "/{id}", produces = APPLICATION_JSON)
    @Transactional
    public Response removeUser(@PathVariable final String id) {
        userService.removeUser(id);
        return Response.ok().build();
    }

}
