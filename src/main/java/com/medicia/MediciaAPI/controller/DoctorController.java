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
import com.medicia.MediciaAPI.entities.MedicalHistory;
import com.medicia.MediciaAPI.services.DoctorService;
import com.medicia.MediciaAPI.visibility.services.PendingRequestService;

@RestController
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PendingRequestService prs;
	
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
	public ResponseEntity<HttpStatus> addDoctor(@RequestBody Doctor doctor)
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
	public ResponseEntity<HttpStatus> updateDoctor(@RequestBody Doctor doctor)
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
	public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable String doctorId)
	{
		try {
			this.doctorService.deleteDoctor(Long.parseLong(doctorId));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/doctors/addMedicalHistory/doctorId/{doctorId}/userId/{userId}")
	public ResponseEntity<HttpStatus> addMedicalHistoryByDocIdAndUserID(@PathVariable("doctorId") String doctorId, @PathVariable("userId") String userId, @RequestBody MedicalHistory medicalHistory)
	{
		try {
			this.doctorService.addMedicalHistoryByDoctorForUser(medicalHistory, Long.parseLong(doctorId), Long.parseLong(userId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	
	@GetMapping("/doctors/userId/{userId}/HisId/{HisId}")
	public Doctor getDoctorByUserIdAndHisId(@PathVariable("userId") Long userId, @PathVariable("HisId") Long HisId)
	{
		return this.doctorService.getDoctorByUserIdAndHisID(userId, HisId);
	}
	
	@GetMapping("/doctors/statusOftheRequest/userId/{UserId}/doctorId/{DoctorId}")
	public int statusOftheRequest(@PathVariable("DoctorId") Long DoctorId, @PathVariable("UserId") Long UserId) 
	{
		return prs.statusOftheRequest(DoctorId, UserId);
	}
	
	@PostMapping("/doctors/sentRequestToUser/userId/{userId}/doctorId/{doctorId}")
	public void sentRequestToUser(@PathVariable("userId") Long userId, @PathVariable("doctorId") Long doctorId) {
		prs.sentRequestToUser(userId, doctorId);
	}
}
