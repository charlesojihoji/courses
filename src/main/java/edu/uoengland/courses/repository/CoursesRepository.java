package edu.uoengland.courses.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uoengland.courses.entity.Course;

@Repository
public interface CoursesRepository extends JpaRepository<Course, UUID>{

}
