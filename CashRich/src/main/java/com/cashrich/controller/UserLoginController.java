package com.cashrich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cashrich.entity.UserLogin;
import com.cashrich.service.UserLoginService;

@RestController
@RequestMapping("/user")
public class UserLoginController {
	@Autowired
	private UserLoginService userLoginService;

	@PostMapping("/login")
	public ResponseEntity<UserLogin> saveUser(@RequestBody UserLogin userLogin) {
		UserLogin u = userLoginService.saveUser(userLogin);
		return ResponseEntity.ok().body(u);
	}

	@PostMapping("/signup")
	public ResponseEntity<UserLogin> signUp( @RequestBody UserLogin login) {
		String usernme=login.getUserName();
		String pword=login.getPassword();
		UserLogin u=userLoginService.signUp(usernme, pword);
		return ResponseEntity.ok().body(u);
	}
}
