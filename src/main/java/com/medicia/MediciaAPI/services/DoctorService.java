package com.medicia.MediciaAPI.services;

import java.util.List;

import com.medicia.MediciaAPI.entities.Doctor;
import com.medicia.MediciaAPI.entities.MedicalHistory;

public interface DoctorService {
	
	public List<Doctor> getAllDoctors();
	
	public Doctor getDoctorById(long doctorId);
	
	public void addDoctor(Doctor doctor);
	
	public void updateDoctor(Doctor doctor);
	
	public void deleteDoctor(long doctorId);
	
	public Doctor findDoctorByEmail(String email);
	
	public void addMedicalHistoryByDoctorForUser(MedicalHistory medicalHistory, long doctorId, long userID);
	
	public List<MedicalHistory> getAlltheMedicalHistoriesByDoctorId(long doctorId);
	
	public Doctor getDoctorByUserIdAndHisID(long userId, long hisId);
}
