package com.medicia.MediciaAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicia.MediciaAPI.dao.DoctorDao;
import com.medicia.MediciaAPI.entities.Doctor;
import com.medicia.MediciaAPI.entities.MedicalHistory;
import com.medicia.MediciaAPI.entities.User;
import com.medicia.MediciaAPI.exception.UserNotFoundException;

@Service
public class DoctorServiceClass implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;

	@Autowired
	private UserService userService;

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return doctorDao.findAll();
	}

	@Override
	public Doctor getDoctorById(long doctorId) {
		// TODO Auto-generated method stub
		if (doctorDao.existsById(doctorId))
			return this.doctorDao.findById(doctorId).get();
		else {
			throw new UserNotFoundException("User Not Found");
		}
	}

	@Override
	public void addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.doctorDao.save(doctor);
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.doctorDao.save(doctor);
	}

	@Override
	public void deleteDoctor(long doctorId) {
		// TODO Auto-generated method stub
		if (doctorDao.existsById(doctorId))
			this.doctorDao.deleteById(doctorId);
		else {
			throw new UserNotFoundException("User Not Found");
		}
	}

	@Override
	public Doctor findDoctorByEmail(String email) {
		// TODO Auto-generated method stub
		List<Doctor> doctors = getAllDoctors();

		for (Doctor doctor : doctors) {
			if (doctor.getDocEmail().equals(email))
				return doctor;
		}
		return null;
	}

	@Override
	public void addMedicalHistoryByDoctorForUser(MedicalHistory medicalHistory, long doctorId, long userID) {
		// TODO Auto-generated method stub
		User user = userService.getUserById(userID);
		Doctor doctor = getDoctorById(doctorId);

		medicalHistory.setDoctor(doctor);
		medicalHistory.setUser(user);

		user.getUserMedicalHistories().add(medicalHistory);
		userService.updateUser(user);

		doctor.getMedicalHistoriesDoctorChecked().add(medicalHistory);
		updateDoctor(doctor);
	}

	@Override
	public List<MedicalHistory> getAlltheMedicalHistoriesByDoctorId(long doctorId) {
		// TODO Auto-generated method stub
		Doctor doctor = getDoctorById(doctorId);
		return doctor.getMedicalHistoriesDoctorChecked();
	}

	@Override
	public Doctor getDoctorByUserIdAndHisID(long userId, long hisId) {
		// TODO Auto-generated method stub
		User user = userService.getUserById(userId);
		MedicalHistory medicalHis = null;
		for (MedicalHistory medicalHistory : user.getUserMedicalHistories()) {
			if (medicalHistory.getHisId() == hisId)
				medicalHis = medicalHistory;
		}
		return medicalHis.getDoctor();
	}
}
