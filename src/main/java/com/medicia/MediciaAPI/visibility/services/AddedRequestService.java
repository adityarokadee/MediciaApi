package com.medicia.MediciaAPI.visibility.services;

import java.util.List;

import com.medicia.MediciaAPI.entities.Doctor;

public interface AddedRequestService {

	// If the user accepts the request of the doctor to view their profile
	public void addDoctorToViewProfile(Long UserId, Long DoctorId);
	
	//After accepting If user wants to remove the doctor from the List
	public void removeDoctorToViewProfile(Long UserId, Long DoctorId);

	// Get the List of the doctors who are pending for the Action
	public List<Doctor> getDoctorsAllowedToViewProfile(Long UserId);
	
	//Count the doctors you have allowed to view your profile
	public int countDoctorsApproved(Long userId);
	
	//check whether the doctor is available in the set to see the user profile
	public boolean isAllowed(long userId, long docId);
}
