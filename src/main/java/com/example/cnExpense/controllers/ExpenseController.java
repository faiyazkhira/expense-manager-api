package com.example.cnExpense.controllers;

import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseservice;
	
	 @PostMapping("/save/{incomeId}")
	    public Income saveExpense(
	            @PathVariable Integer incomeId,
	            @RequestBody Expense expense) {

	        // Save the expense and associate it with the given incomeId
	         return expenseservice.saveExpense(incomeId, expense);

	    }

}
