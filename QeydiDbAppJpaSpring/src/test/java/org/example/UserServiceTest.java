package org.example;

import org.example.entity.User;
import org.example.repo.UserRepositoryCustom;
import org.example.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

//@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepositoryCustom userRepoCust;

    @InjectMocks
    private UserServiceImpl userService;

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
        List<User> list = new ArrayList<>();
        User u = new User();
        u.setName("Khadija");
        u.setSurname("GAdirova");
        u.setEmail("khady@gmail.com");
        list.add(u);
        Mockito.when(userRepoCust.getAll(null,null,null)).thenReturn(list);
    }

    @Test
    public void testGivenNullThenGetAll() {
        System.out.println("Testin icerisi");
        List<User> list = userService.getAll(null, null,null);
//        assertEquals(1, list.size(),"user size must be 1");
        Assert.assertEquals("user size must be 1",1, list.size());
    }
}
