package com.example.cnExpense.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="expense_type")
public class ExpenseType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name="expense_id")
	@JsonBackReference
	private Expense expense;
	public ExpenseType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExpenseType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}
}
