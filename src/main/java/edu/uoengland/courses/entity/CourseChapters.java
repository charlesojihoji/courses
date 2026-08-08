package edu.uoengland.courses.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="course_chapters")
public class CourseChapters {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name="course_chapter_id", unique=true)
	private UUID courseChapterId;
	
	@Column(name="chapter_title", nullable=false)
	private String chapterTitle;

	@Column(name="chapter_description", nullable=false)
	private String chapterDescription;
	
	@Column(name="chapter_status", nullable=false)
	private String chapterStatus;

	@ManyToOne
	@JoinColumn(name="course_id")
	private CourseFaculty courseFaculty;
	
	public CourseChapters() {
		super();
	}

	public CourseChapters(UUID courseChapterId, String chapterTitle, String chapterDescription, String chapterStatus,
			CourseFaculty courseFaculty) {
		super();
		this.courseChapterId = courseChapterId;
		this.chapterTitle = chapterTitle;
		this.chapterDescription = chapterDescription;
		this.chapterStatus = chapterStatus;
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

	public String getChapterStatus() {
		return chapterStatus;
	}

	public void setChapterStatus(String chapterStatus) {
		this.chapterStatus = chapterStatus;
	}

	public CourseFaculty getCourseFaculty() {
		return courseFaculty;
	}

	public void setCourseFaculty(CourseFaculty courseFaculty) {
		this.courseFaculty = courseFaculty;
	}
}
