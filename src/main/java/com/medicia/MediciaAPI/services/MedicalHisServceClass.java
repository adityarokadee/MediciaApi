package com.medicia.MediciaAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicia.MediciaAPI.dao.MedicalDao;
import com.medicia.MediciaAPI.entities.MedicalHistory;

@Service
public class MedicalHisServceClass implements MedicalHisService {

	@Autowired
	private MedicalDao medicalDao;
	
	@Override
	public List<MedicalHistory> getAllHistory() {
		// TODO Auto-generated method stub
		return this.medicalDao.findAll();
	}

	@Override
	public MedicalHistory getHistoryById(long hisId) {
		// TODO Auto-generated method stub
		return this.medicalDao.findById(hisId).get();
	}

	@Override
	public void addHistory(MedicalHistory medicalHistory) {
		// TODO Auto-generated method stub
		this.medicalDao.save(medicalHistory);
	}

	@Override
	public void updateHistory(MedicalHistory medicalHistory) {
		// TODO Auto-generated method stub
		this.medicalDao.save(medicalHistory);
	}

	@Override
	public void deleteHistory(long hisId) {
		// TODO Auto-generated method stub
		this.medicalDao.deleteById(hisId);
	}

}
