package be.swo.easyshop.service.impl.user;

import be.swo.easyshop.dao.user.UserDao;
import be.swo.easyshop.entity.user.User;
import be.swo.easyshop.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public User updateUser(String id, User user) {
        return userDao.updateUser(id, user);
    }

    @Override
    public User getUser(String id) {
        return userDao.getUser(id);
    }

    @Override
    public void removeUser(String id) {
        userDao.removeUser(id);
    }


}
