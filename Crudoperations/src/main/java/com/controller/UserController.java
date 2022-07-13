package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;
@RestController
public class UserController {
  
	@Autowired
	UserService userService;
	
	@PostMapping("/insert")
	public User insertData(@RequestBody User user)
	{
		return userService.insertData(user);
	}
	@GetMapping("/all")
	public List<User> getDetails()
	{
		return userService.getData();
	}
//	@GetMapping("/get/{age}")
//	public User getById(@PathVariable int id)
//	{
//		return userService.getById(id);
//   }
	@GetMapping("/all/{id}")
	public Optional<User> findById(@PathVariable int id)
	{
		return userService.findById(id);
	}
	@DeleteMapping("/delete")
	public String deleteById(@PathVariable int id)
	{
		 return userService.deleteById(id);
	}
}
