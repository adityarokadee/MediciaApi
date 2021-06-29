package com.medicia.MediciaAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicia.MediciaAPI.dao.DoctorDao;
import com.medicia.MediciaAPI.entities.Doctor;

@Service
public class DoctorServiceClass implements DoctorService{
	
	@Autowired
	private DoctorDao doctorDao;

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return doctorDao.findAll();
	}

	@Override
	public Doctor getDoctorById(long doctorId) {
		// TODO Auto-generated method stub
		return this.doctorDao.findById(doctorId).get();
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
		this.doctorDao.deleteById(doctorId);
	}

}
