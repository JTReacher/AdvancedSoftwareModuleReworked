package com.adv.soft.services;

import java.util.List;

import com.adv.soft.models.User;
import com.adv.soft.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//TODO: This is just a DAO. It exists purely to supply user data to the rest of the framework
//In this case it just underpins user auth
//This abstracts user auth and gets it out of the way

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserServiceImpl(user);
    }

    //TODO: check this implementation works. Looks like this pulls all users but paginates it.
    //If it does, do away with the interface you were using.
    public Page<User> findPage(int pageNo, int pageSize) {
        Pageable page = PageRequest.of(pageNo - 1, pageSize);
        return this.userRepository.findAll(page);
    }
}
