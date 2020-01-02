package com.firstdemo.first_demo.Service;

import com.firstdemo.first_demo.Model.User;
import com.firstdemo.first_demo.Repository.PostRepository;
import com.firstdemo.first_demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=repo.findByName(s);
        if (user==null){
            throw new UsernameNotFoundException("user not found");
        }
        return  new UserPrincipal(user);
    }
}
