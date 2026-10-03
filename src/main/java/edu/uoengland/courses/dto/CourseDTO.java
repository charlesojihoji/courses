package edu.uoengland.courses.dto;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import edu.uoengland.courses.entity.CourseChapters;

public class CourseDTO {

	private UUID courseId;
	private String courseName;
	private UUID facultyId;
	private String courseFacultyMember;
	private String courseDescription;
	private Set<CourseChapterDTO> courseChapters;
	private Double coursePrice;
	private LocalDate courseCreatedAt;
	private LocalDate courseUpdatedAt;
	private Double courseDuration;
	private String courseImage;
	private String courseVideo;
	
	public CourseDTO() {
		super();
	}
	
	public CourseDTO(UUID courseId, String courseName, UUID facultyId, String courseFacultyMember,
			String courseDescription, Set<CourseChapterDTO> courseChapters, Double coursePrice,
			LocalDate courseCreatedAt, LocalDate courseUpdatedAt, Double courseDuration, String courseImage,
			String courseVideo) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.facultyId = facultyId;
		this.courseFacultyMember = courseFacultyMember;
		this.courseDescription = courseDescription;
		this.courseChapters = courseChapters;
		this.coursePrice = coursePrice;
		this.courseCreatedAt = courseCreatedAt;
		this.courseUpdatedAt = courseUpdatedAt;
		this.courseDuration = courseDuration;
		this.courseImage = courseImage;
		this.courseVideo = courseVideo;
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

	public Set<CourseChapterDTO> getCourseChapters() {
		return courseChapters;
	}

	public void setCourseChapters(Set<CourseChapterDTO> courseChapters) {
		this.courseChapters = courseChapters;
	}

	public Double getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(Double coursePrice) {
		this.coursePrice = coursePrice;
	}

	public LocalDate getCourseCreatedAt() {
		return courseCreatedAt;
	}

	public void setCourseCreatedAt(LocalDate courseCreatedAt) {
		this.courseCreatedAt = courseCreatedAt;
	}

	public LocalDate getCourseUpdatedAt() {
		return courseUpdatedAt;
	}

	public void setCourseUpdatedAt(LocalDate courseUpdatedAt) {
		this.courseUpdatedAt = courseUpdatedAt;
	}

	public Double getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(Double courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String getCourseImage() {
		return courseImage;
	}

	public void setCourseImage(String courseImage) {
		this.courseImage = courseImage;
	}

	public String getCourseVideo() {
		return courseVideo;
	}

	public void setCourseVideo(String courseVideo) {
		this.courseVideo = courseVideo;
	}

}
