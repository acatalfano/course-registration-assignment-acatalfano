package edu.vanderbilt.registration.service;

import edu.vanderbilt.registration.model.Student;
import edu.vanderbilt.registration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    /**
     * Auto-wired field to connect student service to student repository
     */
    @Autowired
    private StudentRepository repository;

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student create(Student student) {
        return repository.saveAndFlush(student);
    }

    public Student deleteById(long id) {
        var deletedStudent = repository.getById(id);
        repository.deleteById(id);
        repository.flush();
        return deletedStudent;
    }
}
