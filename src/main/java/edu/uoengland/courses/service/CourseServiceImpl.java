package edu.uoengland.courses.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uoengland.courses.dto.CourseChapterDTO;
import edu.uoengland.courses.dto.CourseDTO;
import edu.uoengland.courses.entity.CourseChapters;
import edu.uoengland.courses.entity.CourseFaculty;
import edu.uoengland.courses.repository.CoursesRepository;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CoursesRepository coursesRepository;

	@Override
	public CourseFaculty createACourse(CourseDTO courseDTO) {

		CourseFaculty courseObject = new CourseFaculty();

		courseObject.setCourseName(courseDTO.getCourseName());
		courseObject.setFacultyId(courseDTO.getFacultyId());
		courseObject.setCourseFacultyMember(courseDTO.getCourseFacultyMember());
		courseObject.setCourseDescription(courseDTO.getCourseDescription());
		courseObject.setCourseCreatedAt(LocalDateTime.now());
		courseObject.setCourseUpdatedAt(LocalDateTime.now());
		courseObject.setCourseImage(courseDTO.getCourseImage());
		courseObject.setCourseVideo(courseDTO.getCourseVideo());
		courseObject.setCourseDuration(courseDTO.getCourseDuration());
		courseObject.setCoursePrice(courseDTO.getCoursePrice());
		
		Set<CourseChapters> courseChapterSet = new HashSet<>();

		for (CourseChapterDTO courseChapterDTO : courseDTO.getCourseChapters()) {

			CourseChapters courseChapters = new CourseChapters();

			courseChapters.setChapterTitle(courseChapterDTO.getChapterTitle());
			courseChapters.setChapterDescription(courseChapterDTO.getChapterDescription());
			courseChapters.setCourseFaculty(courseObject);
			courseChapterSet.add(courseChapters);
		}

		courseObject.setCourseChapters(new ArrayList<>(courseChapterSet));

		courseObject.setCourseCreatedAt(LocalDateTime.now());
		courseObject.setCourseUpdatedAt(LocalDateTime.now());
		
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

		CourseFaculty updatedCourse = coursesRepository.findByCourseId(courseDTO.getCourseId());

		updatedCourse.setCourseId(courseDTO.getCourseId());
		updatedCourse.setCourseName(courseDTO.getCourseName());
		updatedCourse.setFacultyId(courseDTO.getFacultyId());
		updatedCourse.setCourseFacultyMember(courseDTO.getCourseFacultyMember());
		updatedCourse.setCourseDescription(courseDTO.getCourseDescription());
		updatedCourse.setCourseImage(courseDTO.getCourseImage());
		updatedCourse.setCourseDuration(courseDTO.getCourseDuration());
		updatedCourse.setCoursePrice(courseDTO.getCoursePrice());
		updatedCourse.setCourseVideo(courseDTO.getCourseVideo());
		updatedCourse.setCourseUpdatedAt(LocalDateTime.now());

		List<CourseChapters> ccptList = new ArrayList<CourseChapters>();

		for (CourseChapterDTO ccptDTO : courseDTO.getCourseChapters()) {

			for(CourseChapters obj : updatedCourse.getCourseChapters()) {
				
				//If course chapters already exist
				if( ccptDTO.getCourseChapterId().equals(obj.getCourseChapterId()) ) {
					obj.setChapterDescription(ccptDTO.getChapterDescription());
					obj.setChapterTitle(ccptDTO.getChapterTitle());
					obj.setCourseFaculty(updatedCourse);
					
					ccptList.add(obj);
				}
				
				//For course chapters that never existed before
				else {
					CourseChapters newObj = new CourseChapters();
					newObj.setChapterDescription(ccptDTO.getChapterDescription());
					newObj.setChapterTitle(ccptDTO.getChapterTitle());
					newObj.setCourseFaculty(updatedCourse);
					
					ccptList.add(newObj);
				}
			}
			
			//If no course chapters ever existed before in the database
			if (ccptList.size() == 0) {
				CourseChapters newObj = new CourseChapters();
				newObj.setChapterDescription(ccptDTO.getChapterDescription());
				newObj.setChapterTitle(ccptDTO.getChapterTitle());
				newObj.setCourseFaculty(updatedCourse);
				
				ccptList.add(newObj);
			}
		}

		updatedCourse.setCourseChapters(ccptList);

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
}
