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
import com.medicia.MediciaAPI.services.DoctorService;

@RestController
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	
	//get all users
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctor()
	{
		return this.doctorService.getAllDoctors();
	}
	
	@GetMapping("/doctors/{doctorId}")
	public Doctor getUserById(@PathVariable String doctorId)
	{
		return this.doctorService.getDoctorById(Long.parseLong(doctorId));
	}
	
	@PostMapping("/doctors")
	public ResponseEntity<HttpStatus> addUser(@RequestBody Doctor doctor)
	{
		try {
			this.doctorService.addDoctor(doctor);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/doctors")
	public ResponseEntity<HttpStatus> updateUser(@RequestBody Doctor doctor)
	{
		try {
			this.doctorService.updateDoctor(doctor);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/doctors/{doctorId}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable String doctorId)
	{
		try {
			this.doctorService.deleteDoctor(Long.parseLong(doctorId));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
