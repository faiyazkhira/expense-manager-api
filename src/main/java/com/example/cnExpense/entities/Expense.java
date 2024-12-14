package com.example.cnExpense.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="expense")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private double amount;
	@Column
	private LocalDate date;
	@Column
	private String description;

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	public List<ExpenseType> getExpenseTypes() {
		return expensetypes;
	}

	public void setExpenseTypes(List<ExpenseType> expensetypes) {
		this.expensetypes = expensetypes;
	}

	@ManyToOne()
	@JoinColumn(name="user_id")
	// in case of multiple back-references in a class
	// we need to define reference name in both @JsonBackReference and @JsonManagedReference
	// to avoid conflict for hibernate
	@JsonBackReference("user-expense")
	private User user;
	
	@OneToOne(mappedBy = "expense", cascade= CascadeType.ALL)
	@JsonBackReference
	private Income income;
	
	@OneToMany(mappedBy="expense", cascade= CascadeType.ALL)
	@JsonManagedReference
	private List<ExpenseType> expensetypes;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Expense(int id, double amount, LocalDate date, String description, User user) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.user = user;
	}
	
	
	

}
