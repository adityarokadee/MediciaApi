package com.medicia.MediciaAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicia.MediciaAPI.entities.User;

public interface UserDao extends JpaRepository<User, Long> {

}
