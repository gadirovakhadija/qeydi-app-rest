package org.example.service.impl;

import org.example.entity.User;
import org.example.repo.UserRepository;
import org.example.repo.UserRepositoryCustom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MyServiceTest {

    @Mock
    private UserRepository myRepository;

    @InjectMocks
    private UserServiceImpl myService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindById() {
        // Define the mock behavior
        when(myRepository.findById(1)).thenReturn(new User(1));

        // Call the service method
        User result = myService.findById(1);

        // Verify the result
        assertEquals("Result is false",null, result.getName());
    }
}

