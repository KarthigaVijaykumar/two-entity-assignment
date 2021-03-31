package com.mindtree.ClassroomManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.ClassroomManagement.entity.Classroom;
import com.mindtree.ClassroomManagement.entity.Student;
import com.mindtree.ClassroomManagement.exception.ClassroomServiceException;
import com.mindtree.ClassroomManagement.service.ClassroomService;


@RestController
public class ClassroomController {
	
	@Autowired
	private ClassroomService service;
	
	
	@PostMapping("/addClassroom")
	
	public ResponseEntity<?> addClassroomDetails(@RequestBody Classroom classroom) {
		String message;
		try {
			Classroom addedClassroom = service.addClassroom(classroom);
			return new ResponseEntity(addedClassroom,HttpStatus.CREATED);
		} catch (ClassroomServiceException e) {
			message = e.getMessage();
			return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addStudent/{classroomId}")
	public ResponseEntity<?> addStudentDetails(@RequestBody Student student,@PathVariable int classroomId) {
		String message;
		try {
			Student addedStudent = service.addStudent(student,classroomId);
			return new ResponseEntity(addedStudent,HttpStatus.CREATED);
		} catch (ClassroomServiceException e) {
			message = e.getMessage();
			return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAllDetails/{studentId}")
	public ResponseEntity<?> getAllDetails(@PathVariable int studentId){
		String message;
		try {
			Student student = service.getDetails(studentId);
			return new ResponseEntity(student,HttpStatus.OK);
		} catch (ClassroomServiceException e) {
			message = e.getMessage();
			return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/updateAge/{studentId}")
	public ResponseEntity<?> updateAgeById(@PathVariable int studentId, @RequestBody int age) {
		String message;
		try {
			Student student = service.updateAge(studentId,age);
			return new ResponseEntity(student,HttpStatus.OK);
		} catch (ClassroomServiceException e) {
			message = e.getMessage();
			return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
		}
		 
	}

}
