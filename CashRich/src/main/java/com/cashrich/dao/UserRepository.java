package com.cashrich.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cashrich.entity.UserLogin;

@Repository
public interface UserRepository extends CrudRepository<UserLogin, Serializable> {
	public UserLogin findByUserName(String userName);
}
