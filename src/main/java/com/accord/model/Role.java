package com.accord.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

/**
 * User : Tanvir Ahmed
 * Date: 11/7/2024.
 */


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(builderClassName = "Builder", toBuilder = true)
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {


    private static final long serialVersionUID = 2391146565028637403L;

    @Column(name = "name",nullable = false,unique = true)
    private String name;

    @Column(name = "display")
    private String display;
}
