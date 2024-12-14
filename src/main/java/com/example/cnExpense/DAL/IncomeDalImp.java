package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.Income;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class IncomeDalImp implements IncomeDal {
	
	@Autowired
	EntityManager entitymanager;

	@Override
	public Income saveincomeById(Income income) {
		// TODO Auto-generated method stub
		Session session = entitymanager.unwrap(Session.class);
		session.save(income);
		return getIncomeById(income.getId());
		
	}

	@Override
	public Income getIncomeById(int incomeid) {
		// TODO Auto-generated method stub
		Session session = entitymanager.unwrap(Session.class);
		Income income= session.get(Income.class, incomeid);
		return income;
	}

}
