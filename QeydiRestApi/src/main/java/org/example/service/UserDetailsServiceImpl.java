package org.example.service;

import org.example.dao.UserRepository;
import org.example.entity.User;
import org.example.security.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(Integer id) throws Exception{
        User user = userRepo.findById(id);
        return JwtUserDetails.create(user);
    }
}
