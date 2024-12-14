package com.example.cnExpense.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int id;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column
	private String username;
	@Column
	private String nickname;
	@Column
	private String email;

	@Column
	private String address;
	
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	@JsonManagedReference("user-expense")
	private List<Expense> expense;
	
	// mappedBy is only used in child entity, and the other side is parent entity
	@ManyToMany( cascade=CascadeType.ALL)
	@JoinTable(
			name = "user_incomes",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "income_id")
	)
	private List<Income> incomes;

	public List<Income> getIncomes() {
		return incomes;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int id, String username, String nickname, String email, List<Expense> expense) {
		super();
		this.id = id;
		this.username = username;
		this.nickname = nickname;
		this.email = email;
		this.expense = expense;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Expense> getExpense() {
		return expense;
	}


	public void setExpense(List<Expense> expense) {
		this.expense = expense;
	}

	
	public int getId() {
		return id;
	}
	
	
	
	
	

}
