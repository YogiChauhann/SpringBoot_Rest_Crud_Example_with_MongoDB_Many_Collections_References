package com.Repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.entities.Student;


@Repository
public interface StudentRepos extends MongoRepository<Student, String> {

	List<Student> findByName(String name);

	Student findByEmailAndName(String string, String string2);

	List<Student> findByNameAndEmail(String string, String string2);

	List<Student> findByNameOrEmail(String string, String string2);

	List<Student> findByDepartmentDepartmentname(String string);

	List<Student> findBySubjectsSubjectName(String string);

	List<Student> findByEmailIsLike(String string);

	List<Student> findByNameStartsWith(String string);

}
