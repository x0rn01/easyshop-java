package be.swo.easyshop.webservice.rest;

import be.swo.easyshop.entity.user.User;
import be.swo.easyshop.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
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
    public ResponseEntity<User> getUser(@PathVariable final String id) {
        try {
            return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/all", produces = APPLICATION_JSON)
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/firstname/{firstname}", produces = APPLICATION_JSON)
    @Transactional(readOnly = true)
    public List<User> findByFirstname(@PathVariable final String firstname) {
        return userService.findByFirstname(firstname);
    }

    @PostMapping (path = "/", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    @Transactional
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping (path = "/{id}", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    @Transactional
    public ResponseEntity<?> updateUser(@PathVariable final String id, @RequestBody User user) {
        try {
            userService.updateUser(id, user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping (path = "/{id}", produces = APPLICATION_JSON)
    @Transactional
    public ResponseEntity<User> removeUser(@PathVariable final String id) {
        try {
            userService.removeUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
