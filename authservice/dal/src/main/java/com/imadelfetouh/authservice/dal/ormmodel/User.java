package com.imadelfetouh.authservice.dal.ormmodel;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    public User() {

    }

    public User(String userId, String username, String password, Role role){
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }
}
