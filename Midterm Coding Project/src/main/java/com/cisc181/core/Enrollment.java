package com.cisc181.core;

import java.util.UUID;

public class Enrollment extends Section {
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;

	public void Enrollment(UUID sectionID, UUID studentID) {
		SectionID = sectionID;
		StudentID = studentID;
		EnrollmentID = UUID.randomUUID();
	}
	
	public void SetGrade(double grade){
		this.Grade = grade;
	}

	public UUID getSectionID() {
		return SectionID;
	}

	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}

	public UUID getStudentID() {
		return StudentID;
	}

	public void setStudentID(UUID studentID) {
		StudentID = studentID;
	}

	public UUID getEnrollmentID() {
		return EnrollmentID;
	}

	public void setEnrollmentID(UUID enrollmentID) {
		EnrollmentID = enrollmentID;
	}

	public double getGrade() {
		return Grade;
	}
}
