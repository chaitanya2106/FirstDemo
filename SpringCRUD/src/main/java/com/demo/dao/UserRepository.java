package com.demo.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Serializable> {
	public User findById(int id);

	@Query(value = "select * from user where city=?", nativeQuery = true)
	public User getUserByCity(String city);
}
