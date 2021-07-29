package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repos.DepartmentRepository;
import com.Repos.StudentRepos;
import com.Repos.SubjectRepository;
import com.entities.Student;

@Service
public class StudentService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	StudentRepos studentRepos;
	
	public Student createStudent(Student student) {
		if (student.getDepartment() != null) {
			departmentRepository.save(student.getDepartment());
		}
		if (student.getSubjects() != null) {
			subjectRepository.saveAll(student.getSubjects());
		}
		return studentRepos.save(student);
	}
	
	public List<Student> getAllStudents() {
		return studentRepos.findAll();
	}

	

}
