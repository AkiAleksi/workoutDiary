package com.example.WorkOut.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Training {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String program;
	private String workoutLength;

	public Training() {

	}

	public Training(long id, String name, String program, String workoutLength) {
		super();
		this.id = id;
		this.name = name;
		this.program = program;
		this.workoutLength = workoutLength;
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

}
