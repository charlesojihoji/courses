package edu.uoengland.courses.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uoengland.courses.dto.CourseDTO;
import edu.uoengland.courses.entity.CourseFaculty;
import edu.uoengland.courses.repository.CoursesRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CoursesRepository coursesRepository;
	
	@Override
	public CourseFaculty createACourse(CourseDTO courseDTO) {
		
		CourseFaculty courseObject = new CourseFaculty();
		
		courseObject.setCourseName(courseDTO.getCourseName());
		courseObject.setCourseFacultyMember(courseDTO.getCourseFacultyMember());
		courseObject.setInitialNumOfStudentsEnrolled(courseDTO.getInitialNumOfStudentsEnrolled());
		
		return coursesRepository.save(courseObject);
	}

	@Override
	public List<CourseFaculty> getAllCourses() {

		return coursesRepository.findAll();
	}

	@Override
	public Optional<CourseFaculty> getACourse(UUID courseId) {

		return coursesRepository.findById(courseId);
	}

	@Override
	public void updateACourse(CourseDTO courseDTO) {

		CourseFaculty updatedCourse = new CourseFaculty();
		
		updatedCourse.setCourseId(courseDTO.getCourseId());
		updatedCourse.setCourseName(courseDTO.getCourseName());
		updatedCourse.setCourseFacultyMember(courseDTO.getCourseFacultyMember());
		updatedCourse.setInitialNumOfStudentsEnrolled(courseDTO.getInitialNumOfStudentsEnrolled());
		
		coursesRepository.save(updatedCourse);
	}

	@Override
	public void deleteACourse(UUID courseId) {

		coursesRepository.deleteById(courseId);
	}

	@Override
	public List<CourseFaculty> getAllCoursesForAFacultyMember(String facultyName) {

		return coursesRepository.findByCourseFacultyMember(facultyName);
	}

	@Override
	public CourseFaculty getDetailsOfACourseFOrAFacultyMember(String facultyName, String courseName) {

		return coursesRepository.findByCourseFacultyMemberAndCourseName(facultyName, courseName);
	}

}
