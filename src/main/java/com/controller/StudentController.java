package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Repos.StudentRepos;
import com.entities.Department;
import com.entities.Student;
import com.entities.Subject;
import com.services.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@GetMapping("/all")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/getById/{id}")
	public Student getStudentbyId(@PathVariable String id) {
		return studentService.getStudentbyId(id);
	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("studentByName/{name}")
	public List<Student> studentByName(@PathVariable String name){
		return studentService.findByName(name);
	}
	
	@GetMapping("/studentsByNameAndMail")
	public Student studentsByNameAndMail(@RequestParam String name, @RequestParam String email) {
		return studentService.studentsByNameAndMail(name, email);
	}
	
	@GetMapping("/studentsByNameOrMail")
	public List<Student> studentsByNameOrMail(@RequestParam String name, @RequestParam String email) {
		return studentService.studentsByNameOrMail(name, email);
	}
	
	@GetMapping("/allWithPagination")
	public List<Student> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
		return studentService.getAllWithPagination(pageNo, pageSize);
	}
	
	@GetMapping("/allWithSorting")
	public List<Student> getAllStudentWithSorting(){
		return studentService.getAllStudentWithSorting();
	}
	
	@GetMapping("/byDepartmentName")
	public List<Department> getByDepartmentName(@RequestParam String depName){
		return studentService.findByDepartmentDepartmentname(depName);
	}
	
	@GetMapping("/bySubjectName/{subName}")
	public List<Subject> getBySubjectName(@PathVariable String subName){
		return studentService.findBySubjectName(subName);
	}
	
	@GetMapping("/nameStartsWith/{name}")
	public List<Student> getByStudentNameLike(@PathVariable String name){
		return studentService.nameStarsWith(name);
	}
	
	
	@GetMapping( "/byDepartmentId/{deptId}")
	public List<Student> byDepartmentId(@PathVariable String deptId) {
		return studentService.byDepartmentId(deptId);
	}
	
	@GetMapping("studentByNameNQ/{name}")
	public List<Student> getStudentByNameNQ(@PathVariable String name){
		return studentService.findByNameNQ(name);
	}

}
