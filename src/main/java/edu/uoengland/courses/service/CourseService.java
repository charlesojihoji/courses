package edu.uoengland.courses.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import edu.uoengland.courses.dto.CourseDTO;
import edu.uoengland.courses.entity.Course;

public interface CourseService {

	public Course createACourse(CourseDTO courseDTO);

	public List<Course> getAllCourses();

	public Optional<Course> getACourse(UUID courseId);

	public void updateACourse(CourseDTO courseDTO);

	public void deleteACourse(UUID courseId);
}
