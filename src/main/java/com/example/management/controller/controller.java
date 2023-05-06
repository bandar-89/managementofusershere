package com.example.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.management.entity.user;
import com.example.management.service.userservices;

@Controller
public class controller {
	
@Autowired
userservices service;
	

@GetMapping("/users")

public String tableofdata(Model model) {
	
service.getall();
	
model.addAttribute("name", service.getall());
	
return "recordnew";
	
}
	

@GetMapping("/")

public String createuser(Model model) {
	
	user userforform= new user();
	
	model.addAttribute("userempty",userforform);
	
	return "Newcreate";
}


@PostMapping("/usercreated")

public String usercreated(@ModelAttribute("userempty") user u1) {
	
	service.saveuser(u1);
	
	return "redirect:/users";
	
}

@GetMapping("/user/update/{id}")
public  String update  (@PathVariable("id") String id1,Model model ) {
	
	
	 user u1=service.getbyid(id1);
	 model.addAttribute("username",u1);
	 
	 return "Newupdate";
}



 @PostMapping("/updateuser/{id}")
 public String updateddatabase(@PathVariable String id,@ModelAttribute("username")user u1) {
	user  update =service.getbyid(id);
	
	update.setId(id);
	
	update.setName(u1.getName());
	
	update.setCity(u1.getCity());
	
	update.setEmail(u1.getEmail());
	
	service.saveuser(update);
	
	return "redirect:/users";}
	
	
	@GetMapping("/user/delete/{id}")
	public String deletefromdatabase(@PathVariable String id) {
		service.deletebyid(id);
		return"redirect:/users";
	}
}
	 
	 
	 
	 
	 
	 