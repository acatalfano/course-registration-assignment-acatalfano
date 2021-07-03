package edu.vanderbilt.registration.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity representing a {@code course}.
 * Contains
 */
@Data
@NoArgsConstructor(force = true)
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;

    @ManyToMany(mappedBy = "courses")
    Set<Student> students = new HashSet<>();
}
