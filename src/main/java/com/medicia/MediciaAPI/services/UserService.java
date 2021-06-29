package com.medicia.MediciaAPI.services;

import java.util.List;

import com.medicia.MediciaAPI.entities.User;

public interface UserService {
	
	public List<User> getAllUsers();
	
	public User getUserById(long userId);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(long userId);
}
