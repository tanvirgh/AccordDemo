package com.accord.repository;

import com.accord.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User : Tanvir Ahmed
 * Date: 10/7/2024.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findByFirstNameContainingIgnoreCase(String firstName, Pageable pageable);
}
