package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDalImp implements UserDal {

    @Autowired
    EntityManager entitymanager;

    @Override
    public User saveuser(User user) {
        // TODO Auto-generated method stub
        Session session = entitymanager.unwrap(Session.class);
        session.save(user);
        return getById(user.getId());

    }

    @Override
    public User getById(int id) {
        Session session = entitymanager.unwrap(Session.class);
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        Session session = entitymanager.unwrap(Session.class);
        List<User> allUsers = session.createQuery("SELECT p FROM User p", User.class).getResultList();
        return allUsers;
    }

    @Override
    public Boolean checkUserExist(User user) {
        Session session = entitymanager.unwrap(Session.class);
        boolean exists = session.get(user.getClass(), user.getId()) != null;
        return exists;
    }

    @Override
    public User finduser(User newUser) {
        Session session = entitymanager.unwrap(Session.class);
        User user = session.get(newUser.getClass(), newUser.getId());
        if (user != null) {
            return user;  // Returns the user if found with 200 OK status
        } else {
            return null;  // Returns 404 if user not found
        }

    }

    @Override
    public List<User> getUsersByIncomeDateFilter(String day, String month, String year) {

        List<User> users = getAllUsers();
        List<User> filteredUsers = new ArrayList<>();

        for (User user : users) {
            List<Income> incomes = user.getIncomes();
            for (Income income : incomes) {
                LocalDate date = income.getDate();
                if (day != null && date.getDayOfMonth() == Integer.parseInt(day)) {
                    filteredUsers.add(user);
                }
                if (month != null && date.getMonth().equals(Integer.parseInt(month))) {
                    filteredUsers.add(user);
                }
                if (year != null && date.getYear() == (Integer.parseInt(year))) {
                    filteredUsers.add(user);
                }
            }
        }
        return filteredUsers;
    }

    @Override
    public List<User> getUsersFilerByIncometype(String incomeType, String expenseType) {

        List<User> users = getAllUsers();
        if (incomeType == null && expenseType == null) {
            return users;
        }
        List<User> filteredUsers = new ArrayList<>();

        for (User user : users) {
            List<Income> incomes = user.getIncomes();
            for (Income income : incomes) {
                List<IncomeType> incomeTypeList = income.getIncomeTypes();
                if (incomeTypeList.contains(incomeType)) {
                    filteredUsers.add(user);
                } else {
                    List<Expense> expenses = user.getExpense();
                    for (Expense expense : expenses) {
                        List<ExpenseType> expenseTypeList = expense.getExpenseTypes();
                        if (expenseTypeList.contains(expenseType)) {
                            filteredUsers.add(user);
                        }
                    }
                }
            }
        }

        return filteredUsers;
    }

}
