package com.adv.soft.services;

import java.util.Collection;
import java.util.List;

/* import com.adv.soft.interfaces.UserService;
 */import com.adv.soft.models.User;

import org.springframework.data.domain.Page;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements /* UserService, */ UserDetails {

    private User user;

    public UserServiceImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

   /*  @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveUser(User user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public User getUserById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Page<User> findPage(int pageNo, int pageSize, String SortField, String sortDirection) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    } */

    public String getFullName() {
        return user.getFirstName() + " " + user.getLastName();
    }

}
