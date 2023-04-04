package com.demo.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.User;
import com.demo.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/saveuser")
	public ResponseEntity<User> saveUSer(User user) {
		User u = userService.saveUSer(user);
		return ResponseEntity.ok().body(u);
	}

	@GetMapping("/getuserbyid/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		User u = userService.getUserById(id);
		return ResponseEntity.ok().body(u);
	}

	@GetMapping("/getuserbycity/{city}")
	public ResponseEntity<User> getUserByCity(@PathVariable String city) {
		User u = userService.getUserByCity(city);
		return ResponseEntity.ok().body(u);
	}

	@DeleteMapping("/deleteuserbyid/{id}")
	public void deleteUserById(@PathVariable Integer id) {
		userService.deleteUserById(id);
	}

	@GetMapping("/getallusers")
	public ResponseEntity<Iterable<User>> getAllUsers() {
		Iterable<User> list = userService.getAllUsers();
		return ResponseEntity.ok().body(list);
	}

	@PutMapping("/updateuserbyid/{id}")
	public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable Integer id) {

		try {
			userService.getUserById(id);
			user.setId(id);
			userService.saveUSer(user);
			return ResponseEntity.ok().body(user);
		} catch (NoSuchElementException e) {
			// TODO: handle exception

		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
