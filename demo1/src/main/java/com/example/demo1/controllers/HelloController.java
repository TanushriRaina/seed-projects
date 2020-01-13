package com.example.demo1.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		
		return "hello";
	}
	
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name,Model model) {
		
		model.addAttribute("var",name);
		return "hello";
	}
	
	@GetMapping("/addition/{n1}/{n2}")
	public String addition(@PathVariable int n1,@PathVariable int n2,Model model) {
		
		model.addAttribute("var1",n1);
		model.addAttribute("var2",n2);
		return "addition";
	}
	
/*	@GetMapping("/userslist")
	public String listofuser(Model model) {
		
		User u1=new User(1,"Tanu","tanu@gmail.com","123 janipur j&k");
		User u2=new User(2,"Sahil","sahil@gmail.com","456 patoli j&k");
		
		ArrayList<User> listusers=new ArrayList<User>();
		listusers.add(u1);
		listusers.add(u2);
		model.addAttribute("listusers", listusers);
		model.addAttribute("u", new User());
		return "listusers";
	}*/
	
	ArrayList<User> listusers=new ArrayList<User>();
	static int id=1;
	
	
	@GetMapping("/listusers")
	public String userslist(Model model) {
		
		//User u1=new User(1,"Tanu","tanu@gmail.com","123 janipur j&k");
		//User u2=new User(2,"Sahil","sahil@gmail.com","456 patoli j&k");
		//listusers.add(u1);
		//listusers.add(u2);
		model.addAttribute("listusers", listusers);
		model.addAttribute("u", new User());
		model.addAttribute("sid", id);
		id++;
		return "listusers";
	}
	
	@PostMapping("/listusers")
	public String addUser(User u) {
		listusers.add(u);
		return "redirect:/listusers";
	}
	
	
}
