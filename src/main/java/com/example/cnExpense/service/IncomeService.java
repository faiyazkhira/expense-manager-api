package com.example.cnExpense.service;

import com.example.cnExpense.DAL.IncomeDal;
import com.example.cnExpense.entities.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IncomeService {
	
	@Autowired
	IncomeDal IncomeDalImp;
	
	@Transactional
	public Income getIncomeById(int incomeid) {
		return IncomeDalImp.getIncomeById(incomeid);
	}

	
	@Transactional
	public Income saveincomeById(Income income) {
		// TODO Auto-generated method stub
		return IncomeDalImp.saveincomeById(income);
	}

}
