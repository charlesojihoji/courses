package edu.uoengland.courses.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uoengland.courses.entity.CourseFaculty;
import edu.uoengland.courses.entity.Student;

@Repository
public interface CoursesRepository extends JpaRepository<CourseFaculty, UUID>{

	List<CourseFaculty> findByCourseFacultyMember(String facultyName);
	CourseFaculty findByCourseFacultyMemberAndCourseName(String facultyName, String courseName);

}
