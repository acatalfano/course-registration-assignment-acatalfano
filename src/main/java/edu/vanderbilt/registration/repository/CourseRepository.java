package edu.vanderbilt.registration.repository;

import edu.vanderbilt.registration.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository for the {@link Course} entity
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {}
