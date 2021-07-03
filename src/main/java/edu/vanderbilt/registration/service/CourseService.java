package edu.vanderbilt.registration.service;

import edu.vanderbilt.registration.model.Course;
import edu.vanderbilt.registration.model.Student;
import edu.vanderbilt.registration.repository.CourseRepository;
import edu.vanderbilt.registration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CourseService {
    /**
     * Auto-wired field connecting Course Service to Course Repository
     */
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course create(Course course) {
        return courseRepository.saveAndFlush(course);
    }

    public Collection<Student> getStudentsByCourse(long courseId) {
        return courseRepository.getById(courseId).getStudents();
    }

    public Course addStudentToCourse(long courseId, long studentId) {
        var student = studentRepository.getById(studentId);
        var course = courseRepository.getById(courseId);
        course.getStudents().add(student);
        student.getCourses().add(course);
        courseRepository.saveAndFlush(course);
        studentRepository.saveAndFlush(student);
        return course;
    }


    // @TODO: set up cascade-delete
    // @TODO: test w/ postman to see that the related entity logic works!
}
