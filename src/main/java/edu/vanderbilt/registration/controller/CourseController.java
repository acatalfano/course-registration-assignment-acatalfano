package edu.vanderbilt.registration.controller;


import edu.vanderbilt.registration.RegistrationController;
import edu.vanderbilt.registration.model.Course;
import edu.vanderbilt.registration.model.Student;
import edu.vanderbilt.registration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * This class is responsible for handling all the endpoints
 * that query or update {@link Course}-related data
 */
@RestController
public class CourseController {
    @Autowired
    private CourseService service;

    /**
     * GET /api/1.0/course
     *
     * @return all existing courses
     */
    @GetMapping(RegistrationController.COURSE_PATH)
    public List<Course> getAllCourses() {
        return service.getAll();
    }

    /**
     * POST /api/1.0/course
     * body: {@link Course}
     *
     * @param course
     *         via request body, the course to create
     *
     * @return the created course
     */
    @PostMapping(RegistrationController.COURSE_PATH)
    public Course createCourse(@RequestBody Course course) {
        return service.create(course);
    }

    /**
     * GET /api/1.0/course/{courseId}
     *
     * @param courseId
     *         the course ID to retrieve
     *
     * @return the course matching the requested courseId
     */
    @GetMapping(RegistrationController.INDIVIDUAL_COURSE_PATH)
    public Collection<Student> getStudentsInCourse(@PathVariable(RegistrationController.COURSE_ID_PARAMETER) long courseId) {
        return service.getStudentsByCourse(courseId);
    }

    /**
     * POST /api/1.0/course/{courseId}?studentId={studentId}
     *
     * @param courseId
     *         path param, the course ID to add a student to
     * @param studentId
     *         query param, the student ID registering for the course
     *
     * @return the course after being updated
     */
    @PostMapping(RegistrationController.INDIVIDUAL_COURSE_PATH)
    public Course registerStudentForCourse(
            @PathVariable(RegistrationController.COURSE_ID_PARAMETER) long courseId,
            @RequestParam long studentId
    ) {
        return service.addStudentToCourse(courseId, studentId);
    }

    /**
     * DELETE /api/1.0/course/{courseId}
     *
     * @param courseId
     *         path param, the course ID to delete
     *
     * @return the course that was just deleted
     */
    @DeleteMapping(RegistrationController.INDIVIDUAL_COURSE_PATH)
    public Course deleteCourse(@PathVariable(RegistrationController.COURSE_ID_PARAMETER) long courseId) {
        return service.deleteById(courseId);
    }

    /**
     * DELETE /api/1.0/course/{courseId}/{studentId}
     *
     * @param courseId
     *         path param, the course ID from which to unregister a student
     * @param studentId
     *         path param, the student ID to unregister from the course
     */
    @DeleteMapping(RegistrationController.INDIVIDUAL_COURSE_STUDENT_PATH)
    public void dropStudentFromCourse(
            @PathVariable(RegistrationController.COURSE_ID_PARAMETER) long courseId,
            @PathVariable(RegistrationController.STUDENT_ID_PARAMETER) long studentId
    ) {
        service.deleteCourseMemberByPairwiseId(courseId, studentId);
    }
}
