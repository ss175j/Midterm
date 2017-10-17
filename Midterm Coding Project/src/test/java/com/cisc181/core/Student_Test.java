package com.cisc181.core;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	static ArrayList<Student> students;
	static ArrayList<Section> sections;
	static ArrayList<Course> courses;

	@BeforeClass
	public static void setup() {
		students = new ArrayList<Student>();
		courses = new ArrayList<Course>();
		courses.add(new Course("Chemistry 104",12));
		courses.add(new Course("CISC 106",8));
		courses.add(new Course("Nursing 101", 10));

		ArrayList<Semester> semesters = new ArrayList<Semester>();
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		startDate.set(2017, 9, 1);
		endDate.set(2017, 12, 1);
		semesters.add(new Semester(startDate.getTime(), endDate.getTime()));
		startDate.set(2017, 2, 1);
		endDate.set(2017, 6, 1);
		semesters.add(new Semester(startDate.getTime(), endDate.getTime()));

		sections = new ArrayList<Section>();
		for (int i = 0; i < courses.size(); i++) {
			for (int j = 0; j < semesters.size(); j++) {
				Section section = new Section();
				section.setSemesterID(semesters.get(j).getSemesterID());
				section.setCourseID(courses.get(i).getCourseID());
				section.setRoomID(10);

				sections.add(section);
			}
		}
		Calendar calendar = Calendar.getInstance();
		calendar.set(1996, 11, 11);
		for (int i = 0; i < 10; i++) {
			try {
				Student student = new Student("Student" + i, "xxx", "xxx",
						calendar.getTime(), eMajor.COMPSI, "address" + i,
						"(000)-000-0000", "email@email.com");
				students.add(student);
			} catch (PersonException e) {
				e.printStackTrace();
			}
		}

	}

	@Test
	public void testGPA() {
		ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
		for (int i = 0; i < students.size(); i++) {
			Enrollment enrollment = new Enrollment();
			enrollment.SetGrade((i + 1));
			enrollments.add(enrollment);
		}

		assertEquals(1, enrollments.get(0).getGrade(), 0);
		assertEquals(2, enrollments.get(1).getGrade(), 0);
		assertEquals(3, enrollments.get(2).getGrade(), 0);
		assertEquals(4, enrollments.get(3).getGrade(), 0);
		assertEquals(5, enrollments.get(4).getGrade(), 0);
		assertEquals(6, enrollments.get(5).getGrade(), 0);
		assertEquals(7, enrollments.get(6).getGrade(), 0);
		assertEquals(8, enrollments.get(7).getGrade(), 0);
		assertEquals(9, enrollments.get(8).getGrade(), 0);
		assertEquals(10, enrollments.get(9).getGrade(), 0);
	}

	@Test
	public void testAverage() {
		ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
		for (int i = 0; i < students.size(); i++) {
			Enrollment enrollment = new Enrollment();
			enrollment.SetGrade((i + 1));
			enrollments.add(enrollment);
		}

		double sumCourse1 = 0;
		int numCourse1 = 0;
		double sumCourse2 = 0;
		int numCourse2 = 0;
		double sumCourse3 = 0;
		int numCourse3 = 0;
		for (int i = 0; i < enrollments.size(); i++) {
			Enrollment enrollment = enrollments.get(i);
			UUID cUuid = null;
			for (int j = 0; j < sections.size(); j++) {
				if (sections.get(j).getSectionID()
						.equals(enrollment.getSectionID())) {
					cUuid = sections.get(j).getCourseID();
				}
			}

			if (courses.get(0).getCourseID().equals(cUuid)) {
				sumCourse1 += enrollments.get(i).getGrade();
				numCourse1++;
			} else if (courses.get(1).getCourseID().equals(cUuid)) {
				sumCourse2 += enrollments.get(i).getGrade();
				numCourse2++;
			} else if (courses.get(2).getCourseID().equals(cUuid)) {
				sumCourse3 += enrollments.get(i).getGrade();
				numCourse3++;
			}

		}

		assertEquals(4.5, sumCourse1 / numCourse1, 0);
		assertEquals(6.5, sumCourse2 / numCourse2, 0);
		assertEquals(5.5, sumCourse3 / numCourse3, 0);
	}

	
}