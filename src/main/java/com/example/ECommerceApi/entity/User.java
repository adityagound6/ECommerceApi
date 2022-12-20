package com.example.ECommerceApi.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id"
    )
    private Long id;
    @Column(
            name = "firstName"
    )
    private String firstName;
    @Column(
            name = "lastName"
    )
    private String lastName;
    @Column(
            name = "email"
            ,unique = true
    )
    private String email;
    @Column(
            name = "password"
    )
    private String password;
    @Column(
            name = "username"
    )
    private String username;

    public User(String firstname, String lastName, String email, String password, String username) {
        this.firstName = firstname;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
    }
    public User(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
