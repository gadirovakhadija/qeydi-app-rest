package org.example.service.impl;

import org.example.entity.User;
import org.example.repo.UserRepositoryCustom;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

class UserServiceTest {

    @Mock
    public UserRepositoryCustom userRepoCust;

    @InjectMocks
    public UserServiceImpl userService;

    @BeforeClass
    public static void setUp(){
        System.out.println("setup called");
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Before
    public void before() {
        System.out.println("before isledi");
    }

    @Test
    public void testGivenNullThenGetAll() {
        List<User> list = new ArrayList<>();
        User u = new User();
        u.setName("Khadija");
        u.setSurname("GAdirova");
        u.setEmail("khady@gmail.com");
        list.add(u);
        Mockito.when(userRepoCust.getAll(null,null,null)).thenReturn(list);
        System.out.println("Testin icerisi");
        List<User> list2 = userService.getAll(null, null,null);
//        assertEquals(1, list.size(),"user size must be 1");
        Assert.assertEquals("user size must be 1",1, list2.size());
    }

}