package com.medicia.MediciaAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicia.MediciaAPI.dao.UserDao;
import com.medicia.MediciaAPI.entities.MedicalHistory;
import com.medicia.MediciaAPI.entities.User;

@Service
public class UserServiceClass implements UserService {

	@Autowired
	private UserDao userDao;
	
	//get all the users
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User getUserById(long userId) {
		// TODO Auto-generated method stub
		return userDao.findById(userId).get();
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public void deleteUser(long userId) {
		// TODO Auto-generated method stub
		userDao.deleteById(userId);
	}
	
	@Override
	public User findUserByEmail(String userEmail)
	{
		List<User> users = getAllUsers();
		for(User user : users)
		{
			if(user.getUserEmail().equals(userEmail))
				return user;
		}
		return null;
	}

	@Override
	public List<MedicalHistory> getAllTheMedicalHistoriesByUserId(long userID) {
		// TODO Auto-generated method stub
		User user = getUserById(userID);
		return user.getUserMedicalHistories();
	}

	
}
