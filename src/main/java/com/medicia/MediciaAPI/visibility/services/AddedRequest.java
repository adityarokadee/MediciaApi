package com.medicia.MediciaAPI.visibility.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicia.MediciaAPI.dao.RequestAddedDAO;
import com.medicia.MediciaAPI.entities.Doctor;
import com.medicia.MediciaAPI.services.DoctorService;
import com.medicia.MediciaAPI.visibility.FriendAdded;

@Service
public class AddedRequest implements AddedRequestService {
	@Autowired
	private RequestAddedDAO dao;
	
	@Autowired
	private DoctorService doc;

	@Override
	public void addDoctorToViewProfile(Long UserId, Long DoctorId) {
		
		if(dao.existsById(UserId)) {
			FriendAdded fa = dao.getById(UserId);
			HashSet<Long> set = fa.getDoctorsAllowed();
			set.add(DoctorId);
			fa.setDoctorsAllowed(set);
			dao.save(fa);
		}
		else {
			HashSet<Long> set = new HashSet<Long>();
			set.add(DoctorId);
			FriendAdded fa = new FriendAdded(UserId, set);
			dao.save(fa);
		}
	}

	@Override
	public List<Doctor> getDoctorsAllowedToViewProfile(Long userId) {
		if(dao.existsById(userId)) {
			FriendAdded fa = dao.getById(userId);
			HashSet<Long> set = fa.getDoctorsAllowed();
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
	public int countDoctorsApproved(Long userId) {
		if(dao.existsById(userId)) {
			FriendAdded fa = dao.getById(userId);
			HashSet<Long> set = fa.getDoctorsAllowed();
			return set.size();
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean isAllowed(long userId, long docId) {
		if(dao.existsById(userId)) {
			FriendAdded fa = dao.getById(userId);
			HashSet<Long> set = fa.getDoctorsAllowed();
			return set.contains(docId);
		}
		else {
			return false;
		}
	}

	@Override
	public void removeDoctorToViewProfile(Long UserId, Long DoctorId) {
		// TODO Auto-generated method stub
		
	}	
}
