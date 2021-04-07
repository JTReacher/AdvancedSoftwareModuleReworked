package com.adv.soft.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.adv.soft.models.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUserTest() {
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setPassword("password");
        user.setFirstName("firstName");
        user.setLastName("lastName");

        User testUser = userRepository.save(user);
        User confirmExistUser = entityManager.find(User.class, testUser.getId());

        assertEquals(user.getEmail(), confirmExistUser.getEmail());


    }
    
}
