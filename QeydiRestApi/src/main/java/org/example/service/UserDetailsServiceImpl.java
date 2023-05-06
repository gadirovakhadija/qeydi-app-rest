package org.example.service;

import org.example.entity.User;
import org.example.security.JwtUserDetails;
import org.example.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserServiceInter userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmail(username);
        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(Integer id) throws Exception{
        User user = userService.findById(id);
        return JwtUserDetails.create(user);
    }
}
