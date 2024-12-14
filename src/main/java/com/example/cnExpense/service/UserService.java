package com.example.cnExpense.service;

import com.example.cnExpense.DAL.UserDal;
import com.example.cnExpense.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

	
	@Autowired
	UserDal UserDalImp;
	
	@Transactional
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return UserDalImp.saveuser(user);
		
	}
    
	@Transactional
	public User getById(int id) {
		// TODO Auto-generated method stub
		return UserDalImp.getById(id);
	}
    
	@Transactional
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return UserDalImp.getAllUsers();
	}
    
	@Transactional
	public boolean checkUserExist(User user) {
		// TODO Auto-generated method stub
		return UserDalImp.checkUserExist(user);
	}

	@Transactional
	public User findUser(User newUser) {
		// TODO Auto-generated method stub
		return UserDalImp.finduser(newUser);
	}

	@Transactional
	public List<User> getUsersByIncomeDateFilter(String day, String month, String year) {
		// TODO Auto-generated method stub
		return UserDalImp.getUsersByIncomeDateFilter(day,month,year);
	}

	@Transactional
	public List<User> getUsersByInocomeTypeFilter(String incomeType, String expenseType) {
		// TODO Auto-generated method stub
		return UserDalImp.getUsersFilerByIncometype(incomeType, expenseType);
	}

}
