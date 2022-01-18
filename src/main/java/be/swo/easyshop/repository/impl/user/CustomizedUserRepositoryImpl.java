package be.swo.easyshop.repository.impl.user;

import be.swo.easyshop.entity.user.User;
import be.swo.easyshop.repository.user.CustomizedUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

public class CustomizedUserRepositoryImpl implements CustomizedUserRepository {

    @Override
    public void someCustomMethod(User user) {
        // Your custom implementation
    }
}
