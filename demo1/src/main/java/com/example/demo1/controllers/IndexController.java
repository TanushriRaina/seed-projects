package com.example.demo1.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class IndexController {

	@GetMapping({"/","index"})
	public String index() {
		
		return "Hello Tanushri";
	}
	
	@GetMapping("/welcome/{uname}")
	public String Welcome(@PathVariable(name = "uname") String name) {
		
		return "Welcome"+name;
	}
	
	@GetMapping("/add/{n1}/{n2}")
	public String add(@PathVariable int n1, @PathVariable int n2) {
		
		return "Sum="+(n1+n2);
	}
	
	@GetMapping("/sub/{n1}/{n2}")
	public String sub(@PathVariable int n1, @PathVariable int n2) {
		
		return "Difference="+(n1-n2);
	}
	
	@GetMapping("/mul/{n1}/{n2}")
	public String mul(@PathVariable int n1, @PathVariable int n2) {
		
		return "Product="+(n1*n2);
	}
	
	@GetMapping("/div/{n1}/{n2}")
	public String div(@PathVariable float n1, @PathVariable float n2) {
		
		return "Division="+(n1/n2);
	}
	
	@GetMapping("/comp/{s1}/{s2}")
	public String comp(@PathVariable String s1, @PathVariable String s2) {
		
		if(s1.compareTo(s2)==0)
		return "Strings are equal";
		else if(s1.compareTo(s2)==1)
		return "String 1 is greater";
		else
		return "String 2 is greater";

	}
	
	@GetMapping("/list/{name1}/{name2}/{name3}")
	public List<String> list(@PathVariable String name1, @PathVariable String name2, @PathVariable String name3) {
		
		ArrayList<String> names=new ArrayList<String>();
		names.add(name1);
		names.add(name2);
		names.add(name3);

		return names;
	}
	
	@GetMapping("/users")
	public ArrayList<User> users() {
		
		User u1=new User(1,"Tanu","tanu@gmail.com","123 janipur j&k");
		User u2=new User(2,"Sahil","sahil@gmail.com","456 patoli j&k");
		
		ArrayList<User> users=new ArrayList<User>();
		users.add(u1);
		users.add(u2);
		return users;
	}
	
	
	
}
