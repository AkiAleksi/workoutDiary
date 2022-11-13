package com.example.WorkOut.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
//@Where(condition = training.email=)
public class Training implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String program;
	@NotEmpty
	private String workoutLength;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private String time;
	private String email;

	// parametriton konstruktori
	public Training() {

	}

	// parametrillinen konstruktori
	public Training(long id, String name, String program, String workoutLength, Date date, String time, String email) {
		super();
		this.id = id;
		this.name = name;
		this.program = program;
		this.workoutLength = workoutLength;
		this.date = date;
		this.time = time;
		this.email = email;

		// this.user = user;
	}

	// getterit ja setterit
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

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getWorkoutLength() {
		return workoutLength;
	}

	public void setWorkoutLength(String workoutLength) {
		this.workoutLength = workoutLength;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
