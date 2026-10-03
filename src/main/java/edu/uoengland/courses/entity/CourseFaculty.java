package edu.uoengland.courses.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name="faculty_id")
	private UUID facultyId;
	
	@Column(name="course_faculty_member")
	private String courseFacultyMember;
	
	@Column(name="course_description")
	private String courseDescription;
	
	@Lob
	@Column(name="course_image")
	private String courseImage;
	
	@Column(name="course_duration")
	private Double courseDuration;
	
	@Column(name="course_price")
	private Double coursePrice;
	
	@Lob
	@Column(name="course_video")
	private String courseVideo;
	
	@Column(name="course_created_at")
	private LocalDateTime courseCreatedAt;
	
	@Column(name="course_updated_at")
	private LocalDateTime courseUpdatedAt;
	
	@OneToMany(mappedBy="courseFaculty", cascade=jakarta.persistence.CascadeType.ALL)
	private List<CourseChapters> courseChapters = new ArrayList<>();
	
	public CourseFaculty() {
		super();
	}

	public CourseFaculty(UUID courseId, String courseName, UUID facultyId, String courseFacultyMember,
			String courseDescription, String courseImage, Double courseDuration, Double coursePrice, String courseVideo,
			LocalDateTime courseCreatedAt, LocalDateTime courseUpdatedAt, List<CourseChapters> courseChapters) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.facultyId = facultyId;
		this.courseFacultyMember = courseFacultyMember;
		this.courseDescription = courseDescription;
		this.courseImage = courseImage;
		this.courseDuration = courseDuration;
		this.coursePrice = coursePrice;
		this.courseVideo = courseVideo;
		this.courseCreatedAt = courseCreatedAt;
		this.courseUpdatedAt = courseUpdatedAt;
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

	public UUID getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(UUID facultyId) {
		this.facultyId = facultyId;
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

	public String getCourseImage() {
		return courseImage;
	}

	public void setCourseImage(String courseImage) {
		this.courseImage = courseImage;
	}

	public Double getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(Double courseDuration) {
		this.courseDuration = courseDuration;
	}

	public Double getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(Double coursePrice) {
		this.coursePrice = coursePrice;
	}

	public String getCourseVideo() {
		return courseVideo;
	}

	public void setCourseVideo(String courseVideo) {
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

	public List<CourseChapters> getCourseChapters() {
		return courseChapters;
	}

	public void setCourseChapters(List<CourseChapters> courseChapters) {
		this.courseChapters = courseChapters;
	}
}
