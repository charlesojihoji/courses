package edu.uoengland.courses.dto;

import java.util.UUID;

import edu.uoengland.courses.entity.CourseFaculty;

public class CourseChapterDTO {

	private UUID courseChapterId;
	private String chapterTitle;
	private String chapterDescription;
	private CourseFaculty courseFaculty;
	
	public CourseChapterDTO() {
		super();
	}

	public CourseChapterDTO(UUID courseChapterId, String chapterTitle, String chapterDescription, CourseFaculty courseFaculty) {
		super();
		this.courseChapterId = courseChapterId;
		this.chapterTitle = chapterTitle;
		this.chapterDescription = chapterDescription;
		this.courseFaculty = courseFaculty;
	}

	public UUID getCourseChapterId() {
		return courseChapterId;
	}

	public void setCourseChapterId(UUID courseChapterId) {
		this.courseChapterId = courseChapterId;
	}

	public String getChapterTitle() {
		return chapterTitle;
	}

	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}

	public String getChapterDescription() {
		return chapterDescription;
	}

	public void setChapterDescription(String chapterDescription) {
		this.chapterDescription = chapterDescription;
	}

	public CourseFaculty getCourseFaculty() {
		return courseFaculty;
	}

	public void setCourseFaculty(CourseFaculty courseFaculty) {
		this.courseFaculty = courseFaculty;
	}
}
