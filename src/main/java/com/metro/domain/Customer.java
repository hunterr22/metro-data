package com.metro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@Column(name = "CUSTOMER_NAME")
	String name;

	@Column(name = "PASSWORD")
	String password;

	@Column(name = "EMAIL")
	String email;

	public Customer() {
		// Default constructor
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toJSON() {
		return "{\"id:\"" + id + ", \"name:\"" + name + ", \"password:\"" + password + ", \"email:\"" + email + " }";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}