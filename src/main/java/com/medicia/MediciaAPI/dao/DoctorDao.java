package com.medicia.MediciaAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicia.MediciaAPI.entities.Doctor;

public interface DoctorDao extends JpaRepository<Doctor, Long> {

}
