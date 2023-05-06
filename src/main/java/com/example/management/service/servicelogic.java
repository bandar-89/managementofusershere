package com.example.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.entity.user;
import com.example.management.repository.dao;


@Service
public class servicelogic  implements userservices{
	
	@Autowired
dao dao;


	@Override
	public List<user> getall() {
		
		
		
		return dao.findAll();
	}

	@Override
	public void saveuser(user u) {
		dao.save(u);
		
	}

	@Override
	public user  getbyid(String id) {
		 user u1=dao.findById(id).get();
		return u1;
	}

	@Override
	public void deletebyid(String id) {
		dao.deleteById(id);
		
	}

	
	

}