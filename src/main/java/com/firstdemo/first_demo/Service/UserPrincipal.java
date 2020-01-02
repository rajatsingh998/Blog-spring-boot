package com.firstdemo.first_demo.Service;

import com.firstdemo.first_demo.Model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserPrincipal implements UserDetails {
   private String userName;
   private String password;
 private List<GrantedAuthority> authorities;

    public UserPrincipal(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        if(role.equals("user"))
        {
            authorities= Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        }
        else
        {
            authorities=Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  authorities;

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
}
