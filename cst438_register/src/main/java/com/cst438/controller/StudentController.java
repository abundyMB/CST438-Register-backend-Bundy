package com.cst438.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cst438.domain.CourseRepository;
import com.cst438.domain.EnrollmentRepository;
import com.cst438.domain.Student;
import com.cst438.domain.StudentRepository;
import com.cst438.domain.StudentDTO;
import com.cst438.service.GradebookService;

@RestController
public class StudentController {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Autowired
	GradebookService gradebookService;

	/*
	 * Add student to database.
	 */ 
	@PostMapping("/addStudent")
	@Transactional
	public StudentDTO addStudent( @RequestBody StudentDTO studentDTO  ) { 
		Student student = studentRepository.findByEmail(studentDTO.email);
		
		if (student == null) {
			student = new Student();
			student.setEmail(studentDTO.email);
			student.setName(studentDTO.name);
			student.setStatusCode(studentDTO.statusCode);
			student.setStatus(studentDTO.status);
			Student savedStudent = studentRepository.save(student);
			StudentDTO result = createStudentDTO(savedStudent);
			return result;
		} else {
			throw  new ResponseStatusException( HttpStatus.BAD_REQUEST, "Student already added to database:  " + studentDTO.email);
		}
	}

	@PostMapping("/registration")
	@Transactional
	public StudentDTO updateRegistration ( @RequestBody StudentDTO studentDTO ) {
		
		Student student = studentRepository.findByEmail(studentDTO.email);
		
		if (student == null)
		{
			throw  new ResponseStatusException( HttpStatus.BAD_REQUEST, "Student email not found: " + studentDTO.email);
		}
		else
		{
			student.setStatus(studentDTO.status);
			student.setStatusCode(studentDTO.statusCode);
			
			student = studentRepository.save(student);
			
			return studentDTO;
		}
	}
	
	/*
	 * Helper method to transform student entities into an instance of 
	 * StudentDTO to return to front end.
	 */ 
	private StudentDTO createStudentDTO(Student s) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.student_id =s.getStudent_id();
		studentDTO.name = s.getName();
		studentDTO.email = s.getEmail();
		studentDTO.status = s.getStatus();
		studentDTO.statusCode = s.getStatusCode();
		
		return studentDTO;
	}
}