package com.example.cnExpense.DAL;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.Expense;
public interface ExpenseDal {

    Income saveExpense(Integer incomeId, Expense expense);

}
