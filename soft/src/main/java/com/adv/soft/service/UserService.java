package com.adv.soft.service;

import java.util.List;
import com.adv.soft.model.User;
import org.springframework.data.domain.Page;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(Long id);
    void deleteUserById(Long id);
    Page<User>findPage(int pageNo, int pageSize, String SortField, String sortDirection); //Handles pages

    //Fetch only users who are students
    //I need three user roles 1. student. 2. admin. 3. Employer
    //Admin has crud access for everything and a management portal
    //Student has crud access on their account and their applications
    //Employer has crud access on their account, their business page and their job briefs

    //IMPLEMENT THIS AND EXTEND THE AUTH CLASSES

    
}
