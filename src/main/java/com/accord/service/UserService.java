package com.accord.service;

import com.accord.exception.ResourceNotFoundException;
import com.accord.model.Role;
import com.accord.model.User;
import com.accord.repository.RoleRepository;
import com.accord.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * User : Tanvir Ahmed
 * Date: 10/7/2024.
 */

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public Page<User> getUsers(int page, int size,String query) {
        Pageable pageable= PageRequest.of(page, size);
        if(Objects.isNull(query) || query.isBlank()) {
            return userRepository.findAll(pageable);
        }else{
            return userRepository.findByFirstNameContainingIgnoreCase(query,pageable);

        }
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public User createUser(User user) {
        Role role= roleRepository.findByName("USER");
        if(Objects.isNull(role)) {
            role = roleRepository.save(Role
                    .builder().name("USER").display("User")
                    .build());
            List<Role> roles = Collections.singletonList(role);
            Set<Role> userRoles= new HashSet<>(roles);
            user.setRoles(userRoles);
        }

        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {

        User user = getUserById(id);
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }




    public List<User> findAll() {
        return userRepository.findAll();
    }
}
