package com.example.management.service;

import java.util.List;

import com.example.management.entity.user;

public interface userservices {
	
	
	public List<user>getall();
	
	public void saveuser(user u );
	
	public user getbyid(String id);
	
	public void deletebyid(String id);
	

}
