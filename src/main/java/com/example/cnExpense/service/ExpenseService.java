package com.example.cnExpense.service;

import com.example.cnExpense.DAL.ExpenseDal;
import com.example.cnExpense.DAL.IncomeDal;
import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ExpenseService {

    @Autowired
    ExpenseDal ExpenseDalImp;

    @Transactional
    public Income saveExpense(Integer incomeId, Expense expense) {
        // TODO Auto-generated method stub
        return ExpenseDalImp.saveExpense(incomeId, expense);

    }

}
