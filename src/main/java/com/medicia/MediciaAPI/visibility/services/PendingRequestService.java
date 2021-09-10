package com.medicia.MediciaAPI.visibility.services;

import java.util.List;

import com.medicia.MediciaAPI.entities.Doctor;

public interface PendingRequestService {
	// Sent request it goes to pending list
	public void sentRequestToUser(Long userId, Long doctorId);

	// Count of the pending list of the user
	public int countPendingRequest(Long userId);

	// Return the list of the Doctors pending for the user
	public List<Doctor> getPendingDoctorsRequest(long userID);

	// Remove the pending request and move it to your approvedDoctors list
	public void addDoctorToApprove(Long userId, Long docId);

	// If the user rejects the request of the doctor to view their profile
	public void rejectDoctorToViewProfile(Long UserId, Long DoctorId);

	// is doctor is allowed to view the patients profile
	//If 0 he is not if 1 he is allowed if is 2 he is on waiting
	public int statusOftheRequest(Long DoctorId, Long UserId);
}
