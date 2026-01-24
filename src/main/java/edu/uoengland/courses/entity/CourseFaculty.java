package edu.uoengland.courses.entity;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="courses_faculty")
public class CourseFaculty {

	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	@Column(name="course_id")
	private UUID courseId;
	
	@Column(name="course_name", unique=true)
	private String courseName;
	
	@Column(name="course_faculty_member")
	private String courseFacultyMember;
	
	@Column(name="initial_numb_of_students_enrolled")
	private int initialNumOfStudentsEnrolled;

	@ManyToMany
	@JoinTable(name="course_student", joinColumns = @JoinColumn(name="course_id"), inverseJoinColumns = @JoinColumn(name="id", referencedColumnName = "id"))
	private Set<Student> students;
	
	public CourseFaculty() {
		super();
	}

	public CourseFaculty(UUID courseId, String courseName, String courseFacultyMember, int initialNumOfStudentsEnrolled) {
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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
