package edu.uoengland.courses.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uoengland.courses.dto.CourseDTO;
import edu.uoengland.courses.entity.CourseFaculty;
import edu.uoengland.courses.entity.Student;
import edu.uoengland.courses.repository.CoursesRepository;
import edu.uoengland.courses.repository.StudentRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CoursesRepository coursesRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public CourseFaculty createACourse(CourseDTO courseDTO) {
		
		CourseFaculty courseObject = new CourseFaculty();
		
		courseObject.setCourseName(courseDTO.getCourseName());
		courseObject.setCourseFacultyMember(courseDTO.getCourseFacultyMember());
		courseObject.setInitialNumOfStudentsEnrolled(courseDTO.getInitialNumOfStudentsEnrolled());
		
		Set<Student> studentSet = new HashSet();
				
		for(UUID obj: courseDTO.getStudentId()) {
			
			Optional<Student> studentObj = studentRepository.findById(obj);
			studentSet.add(studentObj.get());
		}

		courseObject.setStudents(studentSet);
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
	public CourseFaculty getDetailsOfACourseForAFacultyMember(String facultyName, String courseName) {

		return coursesRepository.findByCourseFacultyMemberAndCourseName(facultyName, courseName);
	}

	@Override
	public List<Student> getListOfStudentsForACourseForAFacultyMember(String facultyName, String courseName) {

		return studentRepository.findStudentsByCourseAndFaculty(courseName, facultyName);
	}

	@Override
	public List<CourseDTO> getAListOfCoursesForAStudent(UUID studentId) {

		return coursesRepository.findCourseDTOByStudentId(studentId);
	}

}
