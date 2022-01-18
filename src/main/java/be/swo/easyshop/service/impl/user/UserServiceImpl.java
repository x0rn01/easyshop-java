package be.swo.easyshop.service.impl.user;

import be.swo.easyshop.entity.user.User;
import be.swo.easyshop.repository.user.UserRepository;
import be.swo.easyshop.service.user.UserService;
import be.swo.easyshop.utils.exceptions.UserNotFoundException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String id, User newUser) {
        return userRepository.findById(Long.valueOf(id))
            .map(user -> {
                user.setFirstname(newUser.getFirstname());
                user.setLastname(newUser.getLastname());
                return userRepository.save(user);
            })
            .orElseGet(() -> {
                newUser.setId(Long.valueOf(id));
                return userRepository.save(newUser);
            });
    }

    @Override
    public User getUser(@NonNull String id) throws UserNotFoundException {
        return userRepository.findById(Long.valueOf(id))
            .orElseThrow(() -> new UserNotFoundException(Long.valueOf(id)));
    }

    @Override
    public void removeUser(String id) {
        userRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public List<User> findByFirstname(String firstname) {
        return userRepository.findByFirstname(firstname);
    }


}
