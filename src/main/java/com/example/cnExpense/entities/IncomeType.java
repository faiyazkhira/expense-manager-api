package com.example.cnExpense.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="income_type")
public class IncomeType {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name="income_id")
	@JsonBackReference
	private Income income;
	
	
	public IncomeType() {
		super();
		// TODO Auto-generated constructor stub
	}


	public IncomeType(int id, String name) {
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
	
	

	
}
