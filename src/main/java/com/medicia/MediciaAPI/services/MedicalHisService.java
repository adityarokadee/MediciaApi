package com.medicia.MediciaAPI.services;

import java.util.List;

import com.medicia.MediciaAPI.entities.MedicalHistory;

public interface MedicalHisService {
	
	public List<MedicalHistory> getAllHistory();
	
	public MedicalHistory getHistoryById(long hisId);
	
	public void addHistory(MedicalHistory medicalHistory);
	
	public void updateHistory(MedicalHistory medicalHistory);
	
	public void deleteHistory(long hisId);
}
