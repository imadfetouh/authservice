package com.imadelfetouh.authservice.dal.ormmodel;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    public User() {

    }

    public User(String username, String password, Role role){
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "photo")
    private String photo;

    public Integer getId() {
        return id;
    }
}
