package be.swo.easyshop.service.impl.user;

import be.swo.easyshop.entity.user.User;
import be.swo.easyshop.repository.user.UserRepository;
import be.swo.easyshop.service.user.UserService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
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
    public void updateUser(String id, User user) throws EntityNotFoundException {
        userRepository.findById(Long.valueOf(id)).ifPresentOrElse(userToBeUpdated -> {
            userToBeUpdated.setFirstname(user.getFirstname());
            userToBeUpdated.setLastname(user.getLastname());

            userRepository.save(userToBeUpdated);
        },  () -> new EntityNotFoundException("User not found - " + id));
    }

    @Override
    public User getUser(@NonNull String id) throws EntityNotFoundException {
        Optional<User> user = userRepository.findById(Long.valueOf(id));
        return user.orElseThrow(() -> new EntityNotFoundException("User not found - " + id));
    }

    @Override
    public void removeUser(String id) throws EntityNotFoundException {
        userRepository.findById(Long.valueOf(id)).ifPresentOrElse(userRepository::delete, () ->
                new EntityNotFoundException("User not found - " + id));
    }

    @Override
    public List<User> findByFirstname(String firstname) {
        return userRepository.findByFirstname(firstname);
    }


}
