package com.medicia.MediciaAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicia.MediciaAPI.entities.Doctor;
import com.medicia.MediciaAPI.entities.User;
import com.medicia.MediciaAPI.services.UserService;
import com.medicia.MediciaAPI.visibility.services.AddedRequestService;
import com.medicia.MediciaAPI.visibility.services.PendingRequestService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private PendingRequestService prs;
	
	@Autowired
	private AddedRequestService ars;
	
	//get the initial requests
	@GetMapping("/")
	public String home() {
		return "Welcome to medicia";
	}
	
	//get all users
	@GetMapping("/users")
	public List<User> getAllUser()
	{
		return this.userservice.getAllUsers();
	}
	
	@GetMapping("/users/{userId}")
	public User getUserById(@PathVariable String userId)
	{
		return this.userservice.getUserById(Long.parseLong(userId));
	}
	
	@PostMapping("/users")
	public ResponseEntity<HttpStatus> addUser(@RequestBody User user)
	{
		try {
			this.userservice.addUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/users")
	public ResponseEntity<HttpStatus> updateUser(@RequestBody User user)
	{
		try {
			this.userservice.updateUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId)
	{
		try {
			this.userservice.deleteUser(Long.parseLong(userId));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/users/countOfPendingRequest/{UserId}")
	public int countPendingRequest(@PathVariable Long UserId) {
		return prs.countPendingRequest(UserId);
	}
	
	@GetMapping("/users/getPendingDoctorsRequest/{UserId}")
	public List<Doctor> getPendingDoctorsRequest(@PathVariable long UserId) {
		return prs.getPendingDoctorsRequest(UserId);
	}
	
	@GetMapping("/users/countOfDoctorsApproved/{UserId}")
	public int countDoctorsApproved(@PathVariable Long UserId) {
		return ars.countDoctorsApproved(UserId);
	}
	
	@GetMapping("/users/getDoctorsAllowedToViewProfile/{UserId}")
	public List<Doctor> getDoctorsAllowedToViewProfile(Long UserId)
	{
		return ars.getDoctorsAllowedToViewProfile(UserId);
	}
	
	@PostMapping("/users/addDoctorToApprove/userId/{userId}/doctorId/{docId}")
	public void addDoctorToApprove(@PathVariable("userId") Long userId, @PathVariable("docId") Long docId)
	{
		prs.addDoctorToApprove(userId, docId);
	}
	
	@PostMapping("/users/rejectDoctorToViewProfile/userId/{UserId}/doctorId/{DoctorId}")
	public void rejectDoctorToViewProfile(@PathVariable("UserId") Long UserId, @PathVariable("DoctorId") Long DoctorId) 
	{
		prs.rejectDoctorToViewProfile(UserId, DoctorId);
	}
}
