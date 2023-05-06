package com.example.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.management.entity.user;

public interface dao extends JpaRepository<user,String> {

}

