package edu.vanderbilt.registration.service;

import edu.vanderbilt.registration.model.Course;
import edu.vanderbilt.registration.model.Student;
import edu.vanderbilt.registration.model.courseMember.CourseMember;
import edu.vanderbilt.registration.model.courseMember.CourseMemberKey;
import edu.vanderbilt.registration.repository.CourseMemberRepository;
import edu.vanderbilt.registration.repository.CourseRepository;
import edu.vanderbilt.registration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


/**
 * Service that accesses:
 * <ul>
 *  <li>the {@link CourseRepository}</li>
 *  <li>the {@link StudentRepository}</li>
 *  <li>the {@link CourseMemberRepository}</li>
 * </ul>
 * To make {@link Course}-related updates and queries
 */
@Service
public class CourseService {
    /**
     * Auto-wired field connecting {@code CourseService} to {@link CourseRepository}
     */
    @Autowired
    private CourseRepository courseRepository;

    /**
     * Auto-wired field connecting {@code CourseService} to {@link StudentRepository}
     */
    @Autowired
    private StudentRepository studentRepository;

    /**
     * Auto-wired field connecting {@code CourseService} to {@link CourseMemberRepository}
     */
    @Autowired
    private CourseMemberRepository courseMemberRepository;

    /**
     * @return {@code List<{@link Course}>}
     *         containing every {@link Course} in the repository
     */
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    /**
     * @param course
     *         The {@link Course} to create
     *
     * @return The {@link Course} that was created
     */
    public Course create(Course course) {
        return courseRepository.saveAndFlush(course);
    }

    /**
     * @param courseId
     *         The ID of the {@link Course} of interest
     *
     * @return {@code List<{@link Student}} containing all Students
     *         in the {@link Course} of interest
     */
    public Collection<Student> getStudentsByCourse(long courseId) {
        return studentRepository.getStudentsInCourse(courseId);
    }

    /**
     * @param courseId
     *         The ID of the {@link Course} to which to add the {@link Student}
     * @param studentId
     *         The ID of the {@link Student} who is adding the {@link Course}
     *
     * @return The {@link Course} that the {@link Student} was just added to
     */
    public Course addStudentToCourse(long courseId, long studentId) {
        CourseMemberKey key = CourseMemberKey.builder()
                                             .courseId(courseId)
                                             .studentId(studentId)
                                             .build();

        Course course = courseRepository.getById(courseId);
        Student student = studentRepository.getById(studentId);


        CourseMember member = CourseMember.builder()
                                          .id(key)
                                          .student(student)
                                          .course(course)
                                          .build();
        courseMemberRepository.saveAndFlush(member);
        return courseRepository.getById(courseId);
    }

    /**
     * @param courseId
     *         The ID of the {@link Course} to delete
     *
     * @return The {@link Course} that was just deleted
     */
    public Course deleteById(long courseId) {
        var deletedCourse = courseRepository.getById(courseId);
        courseRepository.deleteById(courseId);
        courseRepository.flush();
        return deletedCourse;
    }

    /**
     * @param courseId
     *         The ID of the {@link Course} to remove a {@link Student} from
     * @param studentId
     *         The ID of the {@link Student} who is dropping the {@link Course}
     */
    public void deleteCourseMemberByPairwiseId(long courseId, long studentId) {
        CourseMemberKey key = CourseMemberKey.builder()
                                             .courseId(courseId)
                                             .studentId(studentId)
                                             .build();
        courseMemberRepository.deleteById(key);
    }
}
