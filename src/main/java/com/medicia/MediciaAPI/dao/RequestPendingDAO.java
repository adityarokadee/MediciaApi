package com.medicia.MediciaAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicia.MediciaAPI.visibility.PendingRequests;

public interface RequestPendingDAO extends JpaRepository<PendingRequests, Long> {

}
