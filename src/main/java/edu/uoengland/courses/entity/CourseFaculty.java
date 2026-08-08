package edu.uoengland.courses.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	
	@Column(name="course_description")
	private String courseDescription;
	
	@Lob
	@Column(name="course_image")
	private byte[] courseImage;
	
	@Column(name="course_duration")
	private Long courseDuration;
	
	@Column(name="course_price")
	private Long coursePrice;
	
	@Lob
	@Column(name="course_video")
	private byte[] courseVideo;
	
	@Column(name="course_created_at")
	private LocalDateTime courseCreatedAt;
	
	@Column(name="course_updated_at")
	private LocalDateTime courseUpdatedAt;
	
	@Column(name="initial_numb_of_students_enrolled")
	private int initialNumOfStudentsEnrolled;

	@ManyToMany
	@JoinTable(name="course_student", joinColumns = @JoinColumn(name="course_id"), inverseJoinColumns = @JoinColumn(name="id", referencedColumnName = "id"))
	private Set<Student> students;
	
	@OneToMany(mappedBy="courseFaculty", cascade=jakarta.persistence.CascadeType.ALL)
	private List<CourseChapters> courseChapters = new ArrayList<>();
	
	public CourseFaculty() {
		super();
	}

	public CourseFaculty(UUID courseId, String courseName, String courseFacultyMember, String courseDescription,
			byte[] courseImage, Long courseDuration, Long coursePrice, byte[] courseVideo,
			LocalDateTime courseCreatedAt, LocalDateTime courseUpdatedAt, int initialNumOfStudentsEnrolled,
			Set<Student> students, List<CourseChapters> courseChapters) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseFacultyMember = courseFacultyMember;
		this.courseDescription = courseDescription;
		this.courseImage = courseImage;
		this.courseDuration = courseDuration;
		this.coursePrice = coursePrice;
		this.courseVideo = courseVideo;
		this.courseCreatedAt = courseCreatedAt;
		this.courseUpdatedAt = courseUpdatedAt;
		this.initialNumOfStudentsEnrolled = initialNumOfStudentsEnrolled;
		this.students = students;
		this.courseChapters = courseChapters;
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

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public byte[] getCourseImage() {
		return courseImage;
	}

	public void setCourseImage(byte[] courseImage) {
		this.courseImage = courseImage;
	}

	public Long getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(Long courseDuration) {
		this.courseDuration = courseDuration;
	}

	public Long getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(Long coursePrice) {
		this.coursePrice = coursePrice;
	}

	public byte[] getCourseVideo() {
		return courseVideo;
	}

	public void setCourseVideo(byte[] courseVideo) {
		this.courseVideo = courseVideo;
	}

	public LocalDateTime getCourseCreatedAt() {
		return courseCreatedAt;
	}

	public void setCourseCreatedAt(LocalDateTime courseCreatedAt) {
		this.courseCreatedAt = courseCreatedAt;
	}

	public LocalDateTime getCourseUpdatedAt() {
		return courseUpdatedAt;
	}

	public void setCourseUpdatedAt(LocalDateTime courseUpdatedAt) {
		this.courseUpdatedAt = courseUpdatedAt;
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

	public List<CourseChapters> getCourseChapters() {
		return courseChapters;
	}

	public void setCourseChapters(List<CourseChapters> courseChapters) {
		this.courseChapters = courseChapters;
	}

}
