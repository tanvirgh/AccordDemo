package com.accord.test.controller;


import com.accord.controller.UserController;
import com.accord.model.Role;
import com.accord.model.User;
import com.accord.service.ExternalApiService;
import com.accord.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private  MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private ExternalApiService externalApiService;

    @Autowired
    private  ObjectMapper objectMapper;

    private User user;

    private Role role ;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        List<Role> roles = Collections.singletonList(Role.builder().name("USER").build());
        Set<Role> userRoles= new HashSet<>(roles);
        user = new User("tanvir", "ahmed", "tanvir@gmail.com", userRoles );
    }

    // Test case for Create User
    @Test
    public void testCreateUser() throws Exception {
        when(userService.createUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/api/v1/users/createUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("tanvir"))
                .andExpect(jsonPath("$.lastName").value("ahmed"))
                .andExpect(jsonPath("$.email").value("tanvir@gmail.com"));
    }

    // Test case for Update User
    @Test
    public void testUpdateUser() throws Exception {
        List<Role> roles = Collections.singletonList(Role.builder().name("USER").build());
        Set<Role> userRoles= new HashSet<>(roles);
        User updatedUser = new User("Rajib", "ahmed", "tanvir@gmail.com", userRoles);
        when(userService.updateUser(eq(1L), any(User.class))).thenReturn(updatedUser);



        mockMvc.perform(put("/api/v1/users/updateUser/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.firstName").value("Rajib"))
                .andExpect(jsonPath("$.lastName").value("ahmed"));
    }

    // Test case for Get User by ID
    @Test
    public void testGetUserById() throws Exception {
        when(userService.getUserById(1L)).thenReturn(user);

        mockMvc.perform(get("/api/v1/users/getUser/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("tanvir"))
                .andExpect(jsonPath("$.lastName").value("ahmed"));
    }



    // Test case for Delete User
    @Test
    public void testDeleteUser() throws Exception {
        doNothing().when(userService).deleteUser(1L);

        mockMvc.perform(delete("/api/v1/users/deleteUser/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
