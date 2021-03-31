package com.mindtree.ClassroomManagement.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.ClassroomManagement.entity.Classroom;
import com.mindtree.ClassroomManagement.entity.Student;
import com.mindtree.ClassroomManagement.exception.ClassroomServiceException;
import com.mindtree.ClassroomManagement.repository.ClassroomRepo;
import com.mindtree.ClassroomManagement.repository.StudentRepo;


@Service
public class ClassroomService {
	
	@Autowired
	private ClassroomRepo classroomrepo;
	@Autowired
	private StudentRepo studentrepo;
	
	public Classroom addClassroom(Classroom classroom) throws ClassroomServiceException {
		int Id = classroom.getClassroomId();
		Classroom classroomPresent = null;
		classroomPresent = classroomrepo.findById(Id).orElse(null);
		if(classroomPresent == null) {
			return classroomrepo.save(classroom);
		}
		else {
			throw new ClassroomServiceException("ClassroomId is already added in the database");
		}
	}

	public Student addStudent(Student student, int classroomId) throws ClassroomServiceException {
		int Id = student.getStudentId();
		Student studentPresent = null;
		studentPresent = studentrepo.findById(Id).orElse(null);
		if(studentPresent == null) {
			Classroom classroom = classroomrepo.findById(classroomId).get();
			student.setClassroom(classroom);
			return studentrepo.save(student);
		}
		else {
			throw new ClassroomServiceException("StudentId is already added in the database");
		}
		
	}

	public Student getDetails(int studentId) throws ClassroomServiceException {
		Student studentById = studentrepo.findById(studentId).orElse(null);
		if(studentById != null) {
			return studentById;
		}
		else {
			throw new ClassroomServiceException("Student Id Not Found");
		}
	}

	public Student updateAge(int studentId,int age) throws ClassroomServiceException {
		Student student = studentrepo.findById(studentId).orElse(null);
		if(student != null) {
			student.setAge(age);
			return studentrepo.save(student);
		}
		else {
			throw new ClassroomServiceException("Student Id Not Found");
		}
	}

}
