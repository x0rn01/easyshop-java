package be.swo.easyshop.dao.user;

import be.swo.easyshop.entity.user.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User createUser(User user);

    User updateUser(String id, User user);

    User getUser(String id);

    void removeUser(String id);
}
