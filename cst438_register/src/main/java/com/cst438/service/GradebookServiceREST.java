package com.cst438.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.cst438.domain.EnrollmentDTO;

// This class sends a new student enrollment to the GradeBook service.
public class GradebookServiceREST extends GradebookService {

	private RestTemplate restTemplate = new RestTemplate();

	@Value("${gradebook.url}")
	String gradebook_url;
	
	public GradebookServiceREST() {
		System.out.println("REST grade book service");
	}

	@Override
	public void enrollStudent(String student_email, String student_name, int course_id) {
		
<<<<<<< HEAD
=======
		//TODO  complete this method in homework 4
		// this class will send a new student enrollment to the GradeBook service using HTTP POST and an EnrollmentDTO object.
		
>>>>>>> refs/remotes/origin/Dev
		EnrollmentDTO enrollmentDTO = new EnrollmentDTO(student_email, student_name, course_id);

	    ResponseEntity<EnrollmentDTO> response = restTemplate.postForEntity("http://localhost:8081/enrollment", enrollmentDTO, null);
	    
		HttpStatus rc = response.getStatusCode();
		System.out.println("HttpStatus: "+rc);
		EnrollmentDTO returnObject = response.getBody();
		System.out.println(returnObject);
	}

}