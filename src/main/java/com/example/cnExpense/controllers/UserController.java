package com.example.cnExpense.controllers;

import com.example.cnExpense.entities.User;
import com.example.cnExpense.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userservice;
	
	@GetMapping("/allUsers")
	public  List<User> getAllUsers() {
		return userservice.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		return userservice.getById(id);
	}
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userservice.saveUser(user);
	}
	
	
	@PostMapping("/checkUserExist")
	public boolean checkUserExist(@RequestBody User user) {
	    return userservice.checkUserExist(user);
		
	   
	}
	
	
	@PostMapping("/find")
    public User findUser(@RequestBody User newUser) {
       return userservice.findUser(newUser);
       
    }
	
	
	 @GetMapping("/filteredUserListByCalendar")
	    public List<User> getFilteredUserList(
	            @RequestParam(value = "day", required = false) String day,
	            @RequestParam(value = "month", required = false) String month,
	            @RequestParam(value = "year", required = false) String year) {

	        return  userservice.getUsersByIncomeDateFilter(day, month, year);
	 }
	        
	      
	
	 @GetMapping("/filteredUserListByType")
	    public List<User> getUserListByType(
	            @RequestParam(value = "incomeType", required = false) String incomeType,
	            @RequestParam(value = "expenseType", required = false) String expenseType) {

	        return userservice.getUsersByInocomeTypeFilter(incomeType, expenseType);
	        
	         // Returns 200 OK with the list of users
	    }
	 
	 
	 
	
	

}
