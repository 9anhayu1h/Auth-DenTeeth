package com.example.springboot.User;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user") // Specify the table name explicitly
public class User {

    // Getters and setters (follow camelCase naming convention)
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(name="id")
    private long id; // Use a larger data type (long) for the primary key

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password; // Use String for password (assuming it's stored securely)

    public User() {
        // Default constructor required by JPA
    }

    public User(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' + // Ensure password is included in quotes
                '}';
    }
}