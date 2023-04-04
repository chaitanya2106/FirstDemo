package com.demo.service;

import java.util.List;

import com.demo.entity.User;

public interface UserService {
	public User saveUSer(User user);

	public User getUserById(int id);

	public User getUserByCity(String city);

	public void deleteUserById(int id);

	public Iterable<User> getAllUsers();
}
