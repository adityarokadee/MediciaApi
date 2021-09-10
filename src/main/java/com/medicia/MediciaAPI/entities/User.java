package com.medicia.MediciaAPI.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long UserId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userAddress;
	private String userPhoneNumber;
	private String userGender;
	private Date dateOfBirth;
	private Date dateOfRegister;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "UserId")
	private List<MedicalHistory> userMedicalHistories = new ArrayList<MedicalHistory>();
	
	public List<MedicalHistory> getUserMedicalHistories() {
		return userMedicalHistories;
	}

	public void setUserMedicalHistories(MedicalHistory userMedicalHistory) {
		this.userMedicalHistories.add(userMedicalHistory);
	}

	public User(long userId, String userName, String userEmail, String userPassword, String userAddress,
			String userPhoneNumber, String userGender, Date dateOfBirth, Date dateOfRegister) {
		super();
		UserId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userPhoneNumber = userPhoneNumber;
		this.userGender = userGender;
		this.dateOfBirth = dateOfBirth;
		this.dateOfRegister = dateOfRegister;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getUserId() {
		return UserId;
	}

	public void setUserId(long userId) {
		UserId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfRegister() {
		return dateOfRegister;
	}

	public void setDateOfRegister(Date dateOfRegister) {
		this.dateOfRegister = dateOfRegister;
	}
	
	
}
