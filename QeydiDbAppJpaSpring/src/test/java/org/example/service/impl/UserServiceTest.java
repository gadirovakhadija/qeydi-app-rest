package org.example.service.impl;

import org.example.entity.User;
import org.example.repo.UserRepository;
import org.example.repo.UserRepositoryCustom;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    public UserRepository userRepository;

    @Mock
    UserRepositoryCustom userRepositoryCustom;

    @InjectMocks
    public UserServiceImpl userService;

    @Before
    public void beforeClass() throws Exception {
        MockitoAnnotations.initMocks(this);
        int id = 1;
        String name = "test";
        String surname = "test";
        String email = "test@example.com";

        User u = new User(name,surname,email);
        User user = new User(email);
        User us = new User(id);
        List<User> userList = new LinkedList<>();
        userList.add(u);

        when(userRepository.findByEmail(email)).thenReturn(user);
        when(userRepository.findById(1)).thenReturn(us);
        when(userRepositoryCustom.getAll(null,null,null)).thenReturn(userList);
    }

    @Test
    public void  whenGivenNullReturnAllUsers(){

        List<User> list = userService.getAll(null,null,null);

        assertEquals("Not true return",1,list.size());


    }
    @Test
    public void testFindById() {

        User result = userService.findById(1);

        assertEquals("Result is false",1, result.getId());
    }

    @Test
    public void testFindByEmail() {

        User result = userService.findByEmail("test@example.com");

        assertEquals("Email doesn't correct","test@example.com", result.getEmail());
    }


}