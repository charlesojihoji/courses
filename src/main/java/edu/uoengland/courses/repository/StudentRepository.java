package edu.uoengland.courses.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.uoengland.courses.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID>{

	@Query("""
	        SELECT DISTINCT s
	        FROM Student s
	        JOIN s.courseFaculty cf
	        WHERE cf.courseName = :courseName
	          AND cf.courseFacultyMember = :courseFacultyMember
	    """)
	    List<Student> findStudentsByCourseAndFaculty(
	            @Param("courseName") String courseName,
	            @Param("courseFacultyMember") String courseFacultyMember
	    );
}
