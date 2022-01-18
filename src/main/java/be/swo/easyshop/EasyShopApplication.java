package be.swo.easyshop;

import be.swo.easyshop.repository.user.UserRepository;
import be.swo.easyshop.entity.user.User;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // component scanning, autoconfiguration, and property support
public class EasyShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyShopApplication.class, args);
    }

    // Spring Boot will run ALL CommandLineRunner beans once the application context is loaded.
    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userDao) {
        return args -> {

            Faker faker = new Faker();
            for (int i = 0; i < 10; i++) {
                User user = new User();
                user.setFirstname(faker.name().firstName());
                user.setLastname(faker.name().lastName());

                userDao.save(user);
            }
        };
    }

}
