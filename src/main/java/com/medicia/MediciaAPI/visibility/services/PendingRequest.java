package com.medicia.MediciaAPI.visibility.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicia.MediciaAPI.dao.RequestPendingDAO;
import com.medicia.MediciaAPI.entities.Doctor;
import com.medicia.MediciaAPI.exception.UserNotFoundException;
import com.medicia.MediciaAPI.services.DoctorService;
import com.medicia.MediciaAPI.visibility.PendingRequests;


@Service
public class PendingRequest implements PendingRequestService {
	
	@Autowired
	private RequestPendingDAO dao;
	
	@Autowired
	private DoctorService doc;
	
	@Autowired
	private AddedRequestService ars;
	
	// Sending the request to the Patient
	@Override
	public void sentRequestToUser(Long userId, Long doctorId) {
		if (dao.existsById(userId)) {
			PendingRequests pa = dao.getById(userId);
			HashSet<Long> set = pa.getDoctorsPending();
			set.add(doctorId);
			dao.save(pa);
		} else {
			HashSet<Long> set = new HashSet<Long>();
			set.add(doctorId);
			PendingRequests pa = new PendingRequests(userId, set);
			dao.save(pa);
		}
	}

	@Override
	public int countPendingRequest(Long userId) {
		
		if(dao.existsById(userId)) {
			PendingRequests pa = dao.getById(userId);
			HashSet<Long> set = pa.getDoctorsPending();
			return set.size();
		}
		else {
			return 0;
		}
	}

	@Override
	public List<Doctor> getPendingDoctorsRequest(long userId) {
		
		if(dao.existsById(userId)) {
			PendingRequests pa = dao.getById(userId);
			HashSet<Long> set = pa.getDoctorsPending();
			List<Doctor> list = new ArrayList<Doctor>();
			for(Long id : set) {
				Doctor doctor = doc.getDoctorById(id);
				list.add(doctor);
			}
			return list;
		}
		else {
			return null;
		}
	}

	@Override
	public void addDoctorToApprove(Long userId, Long docId) {
		
		if(dao.existsById(userId)) {
			PendingRequests pa = dao.getById(userId);
			HashSet<Long> set = pa.getDoctorsPending();
			set.remove(docId);
			
			// add the doctor to approved list
			ars.addDoctorToViewProfile(userId, docId);
		}
		else {
			throw new UserNotFoundException("User Not Found");
		}
	}

	@Override
	public void rejectDoctorToViewProfile(Long userId, Long docId) {
		// TODO Auto-generated method stub
		if(dao.existsById(userId)) {
			PendingRequests pa = dao.getById(userId);
			HashSet<Long> set = pa.getDoctorsPending();
			set.remove(docId);
		}
		else {
			throw new UserNotFoundException("User Not Found");
		}
	}

	@Override
	public int statusOftheRequest(Long DoctorId, Long UserId) {
		if(dao.existsById(UserId)) {
			PendingRequests pa = dao.getById(UserId);
			HashSet<Long> set = pa.getDoctorsPending();
			if(set.contains(DoctorId)) {
				return 2;
			}
			else {
				if(ars.isAllowed(UserId, DoctorId))
					return 1;
				else {
					return 0;
				}
			}
		}
		else {
			return 0;
		}
	}
}
