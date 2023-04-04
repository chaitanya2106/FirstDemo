package com.cashrich.service;

import com.cashrich.entity.UserLogin;

public interface UserLoginService {
	public UserLogin saveUser(UserLogin userLogin);
	public UserLogin signUp(String userName ,String password); 

}
