package com.example.springboot.User;

public class User {
    private long id;
    private String name;
    private String email;
    private int age;

    public User() {
    }

    public User(long id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public void SetId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void SetEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void SetAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
    
}
