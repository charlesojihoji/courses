package edu.uoengland.courses.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.uoengland.courses.dto.CourseDTO;
import edu.uoengland.courses.entity.CourseFaculty;
import edu.uoengland.courses.entity.Student;

@Repository
public interface CoursesRepository extends JpaRepository<CourseFaculty, UUID>{

	List<CourseFaculty> findByCourseFacultyMember(String facultyName);
	CourseFaculty findByCourseFacultyMemberAndCourseName(String facultyName, String courseName);

	@Query("""
	           SELECT new edu.uoengland.courses.dto.CourseDTO(
	                    cf.courseId,
	                    cf.courseName,
	                    cf.courseFacultyMember
	           )
	           FROM CourseFaculty cf
	           JOIN cf.students s
	           WHERE s.id = :studentId
	           """)
	    List<CourseDTO> findCourseDTOByStudentId(@Param("studentId") UUID studentId);
}
