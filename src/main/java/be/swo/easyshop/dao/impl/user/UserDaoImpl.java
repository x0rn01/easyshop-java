package be.swo.easyshop.dao.impl.user;

import be.swo.easyshop.dao.user.UserDao;
import be.swo.easyshop.entity.user.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public User getUser(String id) {
        return new User(1L, "Sébastien", "Wouters");
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Sébastien", "Wouters"));
        users.add(new User(2L, "Caroline", "Elaerts"));
        return users;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(String id, User user) {
        return null;
    }

    @Override
    public void removeUser(String id) {
        // TODO: implement remove user feature
    }

}
