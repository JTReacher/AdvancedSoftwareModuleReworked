package com.adv.soft.repositories;

import com.adv.soft.models.User;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//Repo. This should only be SQL queries. No manipulating the data.
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email  = ?1")
    public User findByEmail(String email);

    @Query("SELECT u from User u WHERE u.type = 'student'")
    public List<User> findAllStudents();

    @Query("SELECT u from User u WHERE u.type = 'employer'")
    public List<User> findAllEmployers();

}
