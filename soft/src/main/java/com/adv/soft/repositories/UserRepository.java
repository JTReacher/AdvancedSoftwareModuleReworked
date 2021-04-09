package com.adv.soft.repositories;

import com.adv.soft.models.User;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

    @Query("SELECT * FROM users WHERE userType = 'student")
    public List<User> findAllStudents();

}
