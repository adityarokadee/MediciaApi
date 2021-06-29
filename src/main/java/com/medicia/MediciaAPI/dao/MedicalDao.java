package com.medicia.MediciaAPI.dao;

import com.medicia.MediciaAPI.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalDao extends JpaRepository<MedicalHistory, Long>{

}
