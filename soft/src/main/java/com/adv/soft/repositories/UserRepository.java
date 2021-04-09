package com.adv.soft.repositories;

import com.adv.soft.models.User;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    //TODO: convert this to a SQL native query, not JPA.
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);


    //TODO: This is correct SQL, but not JQL.
    //I have two options. 1. Rewrite for JQL or create native query
  /*   @Query("SELECT * FROM users WHERE userType = 'student'")
    public List<User> findAllStudents(); */

    //This SQL is still incorrect
    //TODO: This seems to be working, or at least it's running
    @Query(value = "SELECT * FROM users WHERE uType = 'student'", nativeQuery = true)
    public List<User> findAllStudents();

}
