package com.medicia.MediciaAPI.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {
	@Id
	private long docId;
	private String docName;
	private String docEmail;
	private String docPassword;
	private String docAddress;
	private String organizationName;
	private String organizationType;
	private int rating;
	private Date dateOfRegister;
	public long getDocId() {
		return docId;
	}
	public void setDocId(long docId) {
		this.docId = docId;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocEmail() {
		return docEmail;
	}
	public void setDocEmail(String docEmail) {
		this.docEmail = docEmail;
	}
	public String getDocPassword() {
		return docPassword;
	}
	public void setDocPassword(String docPassword) {
		this.docPassword = docPassword;
	}
	public String getDocAddress() {
		return docAddress;
	}
	public void setDocAddress(String docAddress) {
		this.docAddress = docAddress;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrganizationType() {
		return organizationType;
	}
	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Date getDateOfRegister() {
		return dateOfRegister;
	}
	public void setDateOfRegister(Date dateOfRegister) {
		this.dateOfRegister = dateOfRegister;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(long docId, String docName, String docEmail, String docPassword, String docAddress,
			String organizationName, String organizationType, int rating, Date dateOfRegister) {
		super();
		this.docId = docId;
		this.docName = docName;
		this.docEmail = docEmail;
		this.docPassword = docPassword;
		this.docAddress = docAddress;
		this.organizationName = organizationName;
		this.organizationType = organizationType;
		this.rating = rating;
		this.dateOfRegister = dateOfRegister;
	}
}
