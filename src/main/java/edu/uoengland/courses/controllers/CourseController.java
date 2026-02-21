package edu.uoengland.courses.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uoengland.courses.dto.CourseDTO;
import edu.uoengland.courses.entity.CourseFaculty;
import edu.uoengland.courses.entity.Student;
import edu.uoengland.courses.service.CourseService;

@RestController
@RequestMapping("/courses")
@CrossOrigin("*")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public String createACourse(@RequestBody CourseDTO courseDTO) {
		
		courseService.createACourse(courseDTO);
		
		return "A course has been successfully saved.";
	}
	
	@GetMapping
	public List<CourseFaculty> getAllCourses() {
		
		return courseService.getAllCourses();
	}
	
	@GetMapping("/{courseId}")
	public Optional<CourseFaculty> getACourse(@PathVariable UUID courseId) {
		
		return courseService.getACourse(courseId);
	}
	
	@GetMapping("/faculty/{facultyName}")
	public List<CourseFaculty> getAllCoursesForAFacultyMember(@PathVariable String facultyName){
		
		return courseService.getAllCoursesForAFacultyMember(facultyName);
	}
	
	@GetMapping("/{facultyName}/{courseName}")
	public CourseFaculty getDetailsOfACourseForAFacultyMember(@PathVariable String facultyName, @PathVariable String courseName) {
		
		return courseService.getDetailsOfACourseForAFacultyMember(facultyName, courseName);
	}
	
	@GetMapping("/students/{facultyName}/{courseName}")
	public List<Student> getListOfStudentsForACourseForAFacultyMember(@PathVariable String facultyName, @PathVariable String courseName) {
		
		return courseService.getListOfStudentsForACourseForAFacultyMember(facultyName, courseName);
	}
	
	@GetMapping("/forAStudent/{studentId}")
	public List<CourseDTO> getAListOfCoursesForAStudent(@PathVariable UUID studentId){
		
		return courseService.getAListOfCoursesForAStudent(studentId);
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
