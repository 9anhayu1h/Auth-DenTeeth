package com.example.springboot.User;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepo UserRepo;

	@Autowired
	public UserService(UserRepo UserRepo) {
		this.UserRepo = UserRepo;
	}
    public List<User> getUser() {
		return UserRepo.findAll();
	}

	public void addUser(User user) {
		// Check if the email is valid
		if (!isValidEmail(user.getEmail())) {
			throw new IllegalArgumentException("Invalid email format. Must be in the form 'username@gmail.com'.");
		}

		// Check if the email already exists
		Optional<User> userByEmail = UserRepo.findUserByEmail(user.getEmail());
		if (userByEmail.isPresent()) {
			throw new IllegalStateException("Email already exists");
		}

		// Save the user
		UserRepo.save(user);
	}

	private boolean isValidEmail(String email) {
		// Regular expression to validate email format
		return email.matches(".*@.*\\.com");
	}

	public void deleteUser(Long userId) {
		boolean userExist = UserRepo.existsById(userId);
		if (!userExist) {
			throw new IllegalStateException("user with id " + userId + " does not exist");
		}
		UserRepo.deleteById(userId);
	}

	@Transactional
	public void updateUser(Long userId, String name, String password) {
		User user = UserRepo.findById(userId).orElseThrow(() -> new IllegalStateException(
				"user with id " + userId + " does not exist"));

		if (name != null && !name.isEmpty() && !Objects.equals(user.getName(), name)) {
			Optional<User> UserOptional = UserRepo.findUserByName(name);
			if (UserOptional.isPresent()) {
				throw new IllegalStateException("name taken");
			}
			user.setName(name);
		}

		if (password != null && !password.isEmpty() && !Objects.equals(user.getPassword(), password)) {
			user.setPassword(password);
		}
	}
}
