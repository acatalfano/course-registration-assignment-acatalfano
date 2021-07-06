package edu.vanderbilt.registration.service;

import edu.vanderbilt.registration.model.Student;
import edu.vanderbilt.registration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Service that accesses the {@link StudentRepository}
 * to make {@link Student}-related updates and queries
 */
@Service
public class StudentService {
    /**
     * Auto-wired field to connect student service to student repository
     */
    @Autowired
    private StudentRepository repository;

    /**
     * @return {@code List<{@link Student}>}
     *         Containing every {@link Student} in the repository
     */
    public List<Student> getAll() {
        return repository.findAll();
    }

    /**
     * @param student
     *         The {@link Student} to create
     *
     * @return The {@link Student} that was just created
     */
    public Student create(Student student) {
        return repository.saveAndFlush(student);
    }

    /**
     * @param id
     *         The ID of the {@link Student} to delete
     *
     * @return The {@link Student} that was just deleted
     */
    public Student deleteById(long id) {
        var deletedStudent = repository.getById(id);
        repository.deleteById(id);
        repository.flush();
        return deletedStudent;
    }
}
