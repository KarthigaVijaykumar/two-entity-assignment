package com.mindtree.ClassroomManagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Classroom {
	
	@Id
	private int classroomId;
	private char classroomName;
	private int noOfStudents;
	
	public Classroom() {
		super();
	}

	public Classroom(int classroomId, char classroomName, int noOfStudents) {
		super();
		this.classroomId = classroomId;
		this.classroomName = classroomName;
		this.noOfStudents = noOfStudents;
	}

	public int getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(int classroomId) {
		this.classroomId = classroomId;
	}

	public char getClassroomName() {
		return classroomName;
	}

	public void setClassroomName(char classroomName) {
		this.classroomName = classroomName;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

}
