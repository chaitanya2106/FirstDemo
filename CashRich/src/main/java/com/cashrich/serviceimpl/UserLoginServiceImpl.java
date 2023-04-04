package com.cashrich.serviceimpl;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashrich.dao.UserRepository;
import com.cashrich.entity.UserLogin;
import com.cashrich.exception.IncorrectPasswordException;
import com.cashrich.exception.UserNotFoundException;
import com.cashrich.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserLogin saveUser(UserLogin userLogin) {
		// TODO Auto-generated method stub
		return userRepository.save(userLogin);
	}

	@Override
	public UserLogin signUp(String userName, String password) {
		// TODO Auto-generated method stub

		UserLogin u = userRepository.findByUserName(userName);
		if (u == null) {
			throw new UserNotFoundException("Username not found");
		} else if (u.getPassword().equals(password)) {
			return u;

		}
		throw new IncorrectPasswordException("you entered incorrect password");
	}

}