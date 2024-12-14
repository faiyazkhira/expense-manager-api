package com.example.cnExpense.controllers;

import com.example.cnExpense.entities.Income;
import com.example.cnExpense.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/incomes")
public class IncomeController {
	
	@Autowired
	IncomeService incomeservice;
	
	@GetMapping("/{incomeid}")
	public Income getIncomeId(@PathVariable int incomeid) {
	  return incomeservice.getIncomeById(incomeid);
	}
	
	@PostMapping("/save/{userId}")
	public Income saveIncome(@PathVariable Integer userId, @RequestBody Income income) {
		return incomeservice.saveincomeById(income);
	}
	
}

	
	
	