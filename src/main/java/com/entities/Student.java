package com.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "student")
public class Student {
	
	@Id
	private String id;
	private String name;
	@Field(name = "mail")
	private String email;
	
	@DBRef
	private Department department;
	
	@DBRef(lazy = true)
	private List<Subject> subjects;
	
	@Transient
	private double percentage;
	
	
	
	public double getPercentage() {
		if(subjects != null && subjects.size() > 0) {
			int total = 0;
			for(Subject subject : subjects) {
				total += subject.getMarksObtained();
				
			}
			return total/subjects.size();
		}
		
		return 0.00;
	}


	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Student(String id, String name, String email, Department department, List<Subject> subjects) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.subjects = subjects;
	}
	
	



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department
				+ ", subjects=" + subjects + "]";
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	

}
