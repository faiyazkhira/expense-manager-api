package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.User;

import java.util.List;

public interface UserDal {

	User saveuser(User user);

	User getById(int id);

	List<User> getAllUsers();

	Boolean checkUserExist(User user);

	User finduser(User newUser);

	List<User> getUsersByIncomeDateFilter(String day, String month, String year);

	List<User> getUsersFilerByIncometype(String incomeType, String expenseType);

}
