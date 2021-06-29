package com.medicia.MediciaAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.medicia.MediciaAPI.entities.MedicalHistory;
import com.medicia.MediciaAPI.services.MedicalHisService;

@RestController
public class MedicalController {

	@Autowired
	public MedicalHisService medicalService;

	@GetMapping("/medicalhistory")
	public List<MedicalHistory> getAllHistory() {
		return this.medicalService.getAllHistory();
	}
	
	@GetMapping("/medicalhistory/{hisId}")
	public MedicalHistory getHistoryById(@PathVariable String hisId)
	{
		return this.medicalService.getHistoryById(Long.parseLong(hisId));
	}
	
	@PostMapping("/medicalhistory")
	public ResponseEntity<HttpStatus> addHistory(@RequestBody MedicalHistory medicalHistory)
	{
		try {
			this.medicalService.addHistory(medicalHistory);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/medicalhistory")
	public ResponseEntity<HttpStatus> updateHistory(@RequestBody MedicalHistory medicalHistory)
	{
		try {
			this.medicalService.updateHistory(medicalHistory);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/medicalhistory/{hisId}")
	public ResponseEntity<HttpStatus> deleteHistory(@PathVariable String hisId)
	{
		try {
			this.medicalService.deleteHistory(Long.parseLong(hisId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
