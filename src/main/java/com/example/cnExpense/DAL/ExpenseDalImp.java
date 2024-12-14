package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.Expense;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


import com.example.cnExpense.entities.Income;

@Repository
public class ExpenseDalImp implements ExpenseDal {

    @Autowired
    EntityManager entityManager;

    @Override
    public Income saveExpense(Integer incomeId, Expense expense) {
		Session session = entityManager.unwrap(Session.class);
		session.save(expense);
		Income income = session.get(Income.class, incomeId);
		income.setExpense(expense);
		return income;
    }

}
