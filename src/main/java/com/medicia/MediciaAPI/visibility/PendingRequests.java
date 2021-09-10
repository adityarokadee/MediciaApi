package com.medicia.MediciaAPI.visibility;

import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PendingRequests {
	@Id
	private long Userid;
	private HashSet<Long> doctorsPending;
	
	public PendingRequests(long userid, HashSet<Long> doctorsAllowed) {
		super();
		Userid = userid;
		this.doctorsPending = doctorsAllowed;
	}
	public PendingRequests() {
		super();
	}
	public long getUserid() {
		return Userid;
	}
	public void setUserid(long userid) {
		Userid = userid;
	}
	public HashSet<Long> getDoctorsPending() {
		return doctorsPending;
	}
	public void setDoctorsPending(HashSet<Long> doctorsPending) {
		this.doctorsPending = doctorsPending;
	}
	
}
