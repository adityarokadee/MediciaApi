package com.medicia.MediciaAPI.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MedicalHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long hisId;
	private String diasease;
	private String allergies;
	private String medicine;
	private String bloodGroup;
	private String bloodPressure;
	private String handicapped;
	private String haemoglobin;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private User user;
	
	public User getUser() {
		return user;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Doctor doctor;
	
	public void setUser(User user) {
		this.user = user;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public MedicalHistory(String diasease, String allergies, String medicine, String bloodGroup, String bloodPressure,
			String handicapped, String haemoglobin) {
		super();
		this.diasease = diasease;
		this.allergies = allergies;
		this.medicine = medicine;
		this.bloodGroup = bloodGroup;
		this.bloodPressure = bloodPressure;
		this.handicapped = handicapped;
		this.haemoglobin = haemoglobin;
	}

	public MedicalHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getHisId() {
		return hisId;
	}

	public void setHisId(long hisId) {
		this.hisId = hisId;
	}

	public String getDiasease() {
		return diasease;
	}

	public void setDiasease(String diasease) {
		this.diasease = diasease;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getHandicapped() {
		return handicapped;
	}

	public void setHandicapped(String handicapped) {
		this.handicapped = handicapped;
	}

	public String getHaemoglobin() {
		return haemoglobin;
	}

	public void setHaemoglobin(String haemoglobin) {
		this.haemoglobin = haemoglobin;
	}
}
