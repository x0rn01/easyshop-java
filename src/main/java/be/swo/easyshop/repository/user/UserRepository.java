package be.swo.easyshop.repository.user;

import be.swo.easyshop.entity.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    // Query creation from method names
    List<User> findByFirstname(String lastname);

}
