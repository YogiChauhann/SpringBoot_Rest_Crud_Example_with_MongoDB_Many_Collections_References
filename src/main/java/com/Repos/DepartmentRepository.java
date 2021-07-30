package com.Repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.entities.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {


	List<Department> findByDepartmentname(String depName);

}
