package com.cst438.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository <Student, Integer> {
	
	@Query("select s from Student s where s.email=:email")
	public Student findByEmail(String email);
	
	@Query("select s.student_id from Student s where s.email=:email")
	public int findStudentId(String email);
	
	@SuppressWarnings("unchecked")
	public Student save(Student e);
}
