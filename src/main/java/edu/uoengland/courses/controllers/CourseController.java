package edu.uoengland.courses.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uoengland.courses.dto.CourseDTO;
import edu.uoengland.courses.entity.Course;
import edu.uoengland.courses.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public String createACourse(@RequestBody CourseDTO courseDTO) {
		
		courseService.createACourse(courseDTO);
		
		return "A course has been successfully saved.";
	}
	
	@GetMapping
	public List<Course> getAllCourses() {
		
		return courseService.getAllCourses();
	}
	
	@GetMapping("/{courseId}")
	public Optional<Course> getACourse(@PathVariable UUID courseId) {
		
		return courseService.getACourse(courseId);
	}
	
	@PutMapping("/update")
	public String updateACourse(@RequestBody CourseDTO courseDTO) {
		
		courseService.updateACourse(courseDTO);
		
		return "The course with ID " + courseDTO.getCourseId() + " has been successfully updated.";
	}
	
	@DeleteMapping("/delete/{courseId}")
	public String deleteACourse(@PathVariable UUID courseId) {
		
		courseService.deleteACourse(courseId);
		
		return "The course with ID " + courseId + " has been successfully deleted.";
	}
}
