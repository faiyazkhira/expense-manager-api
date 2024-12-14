package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.Income;

public interface IncomeDal {

    Income saveincomeById(Income income);

    Income getIncomeById(int incomeid);

}
