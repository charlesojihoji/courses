package edu.uoengland.courses.dto;

import java.util.Set;
import java.util.UUID;

public class CourseDTO {

	private UUID courseId;
	//Was recently added
	private Set<UUID> studentId;
	private String courseName;
	private String courseFacultyMember;
	private int initialNumOfStudentsEnrolled;
	
	public CourseDTO() {
		super();
	}

	public CourseDTO(UUID courseId, Set<UUID> studentId, String courseName, String courseFacultyMember,
			int initialNumOfStudentsEnrolled) {
		super();
		this.courseId = courseId;
		this.studentId = studentId;
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

	public Set<UUID> getStudentId() {
		return studentId;
	}

	public void setStudentId(Set<UUID> studentId) {
		this.studentId = studentId;
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
