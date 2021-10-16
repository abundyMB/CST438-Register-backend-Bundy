package com.cst438.domain;


import java.util.List;

import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EnrollmentRepository extends CrudRepository <Enrollment, Integer> {
	
	@Query("select e from Enrollment e where e.enrollment_id=:id")
	Enrollment findById(@Param("id") int id);
<<<<<<< HEAD
	 
=======
	
>>>>>>> refs/remotes/origin/Dev
	@Query("select e from Enrollment e where e.student.email=:email and e.year=:year and e.semester=:semester")
<<<<<<< HEAD
	public List<Enrollment> findStudentSchedule(@Param("email") String email, @Param("year") int year, @Param("semester") String semester);
=======
	public List<Enrollment> findStudentSchedule(@Param("email") String email,  @Param("year") int year, @Param("semester") String semester);
>>>>>>> refs/remotes/origin/Dev
	
	@Query("select e from Enrollment e where e.student.email=:email and e.course.course_id=:course_id")
	Enrollment findByEmailAndCourseId(@Param("email") String email, @Param("course_id") int course_id);
	
	@SuppressWarnings("unchecked")
	Enrollment save(Enrollment e);
}