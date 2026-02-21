package edu.uoengland.courses.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import edu.uoengland.courses.dto.CourseDTO;
import edu.uoengland.courses.entity.CourseFaculty;
import edu.uoengland.courses.entity.Student;

public interface CourseService {

	public CourseFaculty createACourse(CourseDTO courseDTO);

	public List<CourseFaculty> getAllCourses();

	public Optional<CourseFaculty> getACourse(UUID courseId);

	public void updateACourse(CourseDTO courseDTO);

	public void deleteACourse(UUID courseId);

	public List<CourseFaculty> getAllCoursesForAFacultyMember(String facultyName);

	public CourseFaculty getDetailsOfACourseForAFacultyMember(String facultyName, String courseName);

	public List<Student> getListOfStudentsForACourseForAFacultyMember(String facultyName, String courseName);

	public List<CourseDTO> getAListOfCoursesForAStudent(UUID studentId);
}
