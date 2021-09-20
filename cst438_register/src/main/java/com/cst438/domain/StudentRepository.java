package com.cst438.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository <Student, Integer> {
	
	public Student findByEmail(@Param("email") String email);
	
	@Query("select s.student_id from Student s where s.email=:email")
	public int findId(@Param("email") String email);
	
	@SuppressWarnings("unchecked")
	public Student save(Student s);
}
