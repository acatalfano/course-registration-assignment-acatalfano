package edu.vanderbilt.registration.repository;

import edu.vanderbilt.registration.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Repository for the {@link Student} entity
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    /**
     * @param courseId
     *         the ID of the course of interest
     *
     * @return {@code List<{@link Student}>}
     *         containing all the students in the course of interest
     */
    @Query("SELECT s FROM Student s WHERE EXISTS (" +
           "    SELECT cm FROM CourseMember cm" +
           "    WHERE cm.student.id = s.id" +
           "        AND cm.course.id = :courseId" +
           ")")
    List<Student> getStudentsInCourse(@Param("courseId") long courseId);
}
