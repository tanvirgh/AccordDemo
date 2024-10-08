package com.accord.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * User : Tanvir Ahmed
 * Date: 10/7/2024.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    private static final long serialVersionUID = -6370322298846342045L;

    @NotBlank(message = "First Name cannot be empty or blank")
    @Column(name = "first_name",nullable = false)
    private String firstName;

    @NotBlank(message = "Last Name cannot be empty or blank")
    @Column(name = "last_name",nullable = false)
    private String lastName;

    @NotBlank(message = "Email cannot be empty or blank")
    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;



}
