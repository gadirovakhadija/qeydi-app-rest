package org.example;

import org.example.entity.User;
import org.example.repo.UserRepositoryCustomImpl;
import org.example.service.impl.UserServiceImpl;
import org.example.service.inter.UserServiceInter;
import org.junit.Assert;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

public class UserServiceTest {

    @Mock
    private UserServiceInter userDao;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenNullThenGetAll() {
        System.out.println("Testin icerisi");
        List<User> list = userService.getAll(null, null,null);
        assertEquals(51, list.size(),"user size must be 2");
    }
    @Test
    public void testGetAll() {

        List<User> userList = userService.getAll("John", "Doe", null);

        Assert.assertEquals("User list must contain 1 user", 1, userList.size());
        Assert.assertEquals("User name must be John", "John", userList.get(0).getName());
        Assert.assertEquals("User surname must be Doe", "Doe", userList.get(0).getSurname());
    }
}
