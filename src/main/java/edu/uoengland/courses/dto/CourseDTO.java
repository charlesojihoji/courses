package edu.uoengland.courses.dto;

import java.util.Set;
import java.util.UUID;

import edu.uoengland.courses.entity.CourseChapters;

public class CourseDTO {

	private UUID courseId;
	//Was recently added
	private Set<UUID> studentId;
	private String courseName;
	private String courseFacultyMember;
	private int initialNumOfStudentsEnrolled;
	private Set<CourseChapterDTO> courseChapters;
	
	public CourseDTO() {
		super();
	}
	
	public CourseDTO(UUID courseId, Set<UUID> studentId, String courseName, String courseFacultyMember,
			int initialNumOfStudentsEnrolled, Set<CourseChapterDTO> courseChapters) {
		super();
		this.courseId = courseId;
		this.studentId = studentId;
		this.courseName = courseName;
		this.courseFacultyMember = courseFacultyMember;
		this.initialNumOfStudentsEnrolled = initialNumOfStudentsEnrolled;
		this.courseChapters = courseChapters;
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

	public Set<CourseChapterDTO> getCourseChapters() {
		return courseChapters;
	}

	public void setCourseChapters(Set<CourseChapterDTO> courseChapters) {
		this.courseChapters = courseChapters;
	}
}
