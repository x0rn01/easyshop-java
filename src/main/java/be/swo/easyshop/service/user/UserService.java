package be.swo.easyshop.service.user;

import be.swo.easyshop.entity.user.User;
import be.swo.easyshop.utils.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User createUser(User user);

    User updateUser(String id, User user);

    User getUser(String id) throws UserNotFoundException;

    void removeUser(String id);

    List<User> findByFirstname(String firstname);
}
