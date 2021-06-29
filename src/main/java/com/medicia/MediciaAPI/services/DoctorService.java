package com.medicia.MediciaAPI.services;

import java.util.List;

import com.medicia.MediciaAPI.entities.Doctor;

public interface DoctorService {
	
	public List<Doctor> getAllDoctors();
	
	public Doctor getDoctorById(long doctorId);
	
	public void addDoctor(Doctor doctor);
	
	public void updateDoctor(Doctor doctor);
	
	public void deleteDoctor(long doctorId);
}
