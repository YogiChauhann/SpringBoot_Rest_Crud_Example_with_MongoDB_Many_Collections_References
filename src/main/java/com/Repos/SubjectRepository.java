package com.Repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.entities.Subject;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, String> {

	List<Subject> findBySubjectName(String subName);

}
