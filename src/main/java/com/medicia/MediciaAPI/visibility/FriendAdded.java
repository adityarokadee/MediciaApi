package com.medicia.MediciaAPI.visibility;

import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FriendAdded {
	@Id
	private long Userid;
	private HashSet<Long> doctorsAllowed;
	public FriendAdded(long userid, HashSet<Long> doctorsAllowed) {
		super();
		Userid = userid;
		this.doctorsAllowed = doctorsAllowed;
	}
	public FriendAdded() {
		super();
	}
	public long getUserid() {
		return Userid;
	}
	public void setUserid(long userid) {
		Userid = userid;
	}
	public HashSet<Long> getDoctorsAllowed() {
		return doctorsAllowed;
	}
	public void setDoctorsAllowed(HashSet<Long> doctorsAllowed) {
		this.doctorsAllowed = doctorsAllowed;
	}
}
