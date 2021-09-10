package com.medicia.MediciaAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicia.MediciaAPI.visibility.FriendAdded;

public interface RequestAddedDAO extends JpaRepository<FriendAdded, Long>{

}
