package com.example.cnExpense.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="income")
public class Income {
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
	
	@ManyToMany(mappedBy="incomes", cascade = CascadeType.ALL)
	private List<User> user;
	
	@OneToOne
	@JsonManagedReference
	private Expense expense;

	@OneToMany(mappedBy="income", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<IncomeType> incomeType;


	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	public List<IncomeType> getIncomeTypes() {
		return incomeType;
	}

	public void setIncomeTypes(List<IncomeType> incomeType) {
		this.incomeType = incomeType;
	}

	public Income() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Income(int id, double amount, LocalDate date, String description) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.description = description;
	}


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


	public int getId() {
		return id;
	}
	
	
	
	
	

}
