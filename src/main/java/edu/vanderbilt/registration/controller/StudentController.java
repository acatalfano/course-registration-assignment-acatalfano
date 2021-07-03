package edu.vanderbilt.registration.controller;

import edu.vanderbilt.registration.RegistrationController;
import edu.vanderbilt.registration.model.Student;
import edu.vanderbilt.registration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    /**
     *
     * @return all existing students
     */
    @GetMapping(RegistrationController.STUDENT_PATH)
    public List<Student> getAllStudents() {
        return service.getAll();
    }

    /**
     *
     * @param student request body, the student to create
     * @return the student that was just created
     */
    @PostMapping(RegistrationController.STUDENT_PATH)
    public Student createStudent(@RequestBody Student student) {
        return service.create(student);
    }

    /**
     *
     * @param studentId path param, the student ID to delete
     * @return the student that was just deleted
     */
    @DeleteMapping(RegistrationController.INDIVIDUAL_STUDENT_PATH)
    public Student deleteStudent(@PathVariable(RegistrationController.STUDENT_ID_PARAMETER) long studentId) {
        return service.deleteById(studentId);
    }
}
