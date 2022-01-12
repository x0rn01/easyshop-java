package be.swo.easyshop.service.user;

import be.swo.easyshop.entity.user.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User createUser(User user);

    User updateUser(String id, User user);

    User getUser(String id);

    void removeUser(String id);
}