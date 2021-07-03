package edu.vanderbilt.registration.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity representing a {@code Student} object.
 * Consists of
 * {@link Student} and {@link Course}
 */
@Data
@NoArgsConstructor(force = true)
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private String profilePhotoUrl;

    /**
     * Owner-side of Many-to-Many mapping relationship between {@link Student} and {@link Course}
     */
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "course_member",
            joinColumns = { @JoinColumn(name = "student_id")},
            inverseJoinColumns = { @JoinColumn(name = "course_id" )}
    )
    private Set<Course> courses = new HashSet<>();
}
