package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.Repos.DepartmentRepository;
import com.Repos.StudentRepos;
import com.Repos.SubjectRepository;
import com.entities.Department;
import com.entities.Student;
import com.entities.Subject;

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

	public Student getStudentbyId(String id) {
		// TODO Auto-generated method stub
		return studentRepos.findById(id).get();
	}

	public Student updateStudent(Student student) {
		return studentRepos.save(student);
	}

	public String deleteStudent(String id) {
		// TODO Auto-generated method stub
		studentRepos.deleteById(id);
		return "Student has been deleted.";
	}

	public List<Student> findByName(String name) {
		// TODO Auto-generated method stub
		return studentRepos.findByName(name);
	}

	public Student studentsByNameAndMail(String name, String email) {
		// TODO Auto-generated method stub
		return studentRepos.findByEmailAndName(email, name);
	}

	public List<Student> studentsByNameOrMail(String name, String email) {
		// TODO Auto-generated method stub
		return studentRepos.findByNameOrEmail(name, email);
	}

	public List<Student> getAllWithPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return studentRepos.findAll(pageable).getContent();
	}

	public List<Student> getAllStudentWithSorting() {
		Sort sort = Sort.by(Sort.Direction.DESC, "name", "email");
		return studentRepos.findAll(sort);
	}

	public List<Department> findByDepartmentDepartmentname(String depName) {
		
		return departmentRepository.findByDepartmentname(depName);
	}

	public List<Subject> findBySubjectName(String subName) {
		// TODO Auto-generated method stub
		return subjectRepository.findBySubjectName(subName);
	}

	public List<Student> nameStarsWith(String name) {
		// TODO Auto-generated method stub
		return studentRepos.findByNameStartsWith(name);
	}
	
	public List<Student> byDepartmentId (String deptId) {
		return studentRepos.findByDepartmentId(deptId);
	}


	public List<Student> findByNameNQ(String name) {
		// TODO Auto-generated method stub
		return studentRepos.getFromNameNQ(name);
	}

	
	

	

}
