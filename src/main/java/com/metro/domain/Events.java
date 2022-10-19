package com.metro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVENTS")
public class Events {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@Column(name = "EVENT_CODE")
	String code;

	@Column(name = "TITLE")
	String title;

	@Column(name = "DESCRIPTION")
	String description;

	public Events() {
		// Default constructor
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}