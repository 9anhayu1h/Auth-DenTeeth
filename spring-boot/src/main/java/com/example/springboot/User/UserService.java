package com.example.springboot.User;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public List<User> getUser() {
		return List.of(new User(1, "yuth", "Panhayuth@gmail.com", "panhayuth"));
	}
}
