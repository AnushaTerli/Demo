
package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public User insertData(User user)
	{
		return userRepo.save(user);
	}
	public List<User> getData()
	{
		return userRepo.findAll();
	}
//	public User getById(int id) {
//		return userRepo.getById(id);
//		}
	@CacheEvict(value = "User", allEntries = true)
	public String deleteById(int id)
	{
		userRepo.deleteById(id);
		return "dELETED";
			}
	public Optional<User> findById(int id)
	{
		return userRepo.findById(id);
	}
}
