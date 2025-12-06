package edu.uoengland.courses.dto;

import java.util.UUID;

public class CourseDTO {

	private UUID courseId;
	private String courseName;
	private String courseFacultyMember;
	private int initialNumOfStudentsEnrolled;
	
	public CourseDTO() {
		super();
	}

	public CourseDTO(UUID courseId, String courseName, String courseFacultyMember, int initialNumOfStudentsEnrolled) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseFacultyMember = courseFacultyMember;
		this.initialNumOfStudentsEnrolled = initialNumOfStudentsEnrolled;
	}

	public UUID getCourseId() {
		return courseId;
	}

	public void setCourseId(UUID courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseFacultyMember() {
		return courseFacultyMember;
	}

	public void setCourseFacultyMember(String courseFacultyMember) {
		this.courseFacultyMember = courseFacultyMember;
	}

	public int getInitialNumOfStudentsEnrolled() {
		return initialNumOfStudentsEnrolled;
	}

	public void setInitialNumOfStudentsEnrolled(int initialNumOfStudentsEnrolled) {
		this.initialNumOfStudentsEnrolled = initialNumOfStudentsEnrolled;
	}
	
}
