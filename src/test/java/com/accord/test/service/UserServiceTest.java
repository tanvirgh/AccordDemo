package com.accord.test.service;


import com.accord.model.Role;
import com.accord.model.User;
import com.accord.repository.UserRepository;
import com.accord.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setFirstName("Selim");
        user.setLastName("Reza");
        user.setEmail("selim@gmail.com");

        List<Role> roles = Collections.singletonList(Role.builder().name("USER").build());
        Set<Role> userRoles= new HashSet<>(roles);
        user.setRoles(userRoles);

        when(userRepository.save(any(User.class))).thenReturn(user);
        assert (user.getFirstName().equals("Selim"));
    }
}
