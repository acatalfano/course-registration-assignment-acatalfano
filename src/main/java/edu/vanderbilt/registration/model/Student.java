package edu.vanderbilt.registration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.vanderbilt.registration.model.courseMember.CourseMember;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * This class encodes the {@code Student} entity.
 *
 * Includes passive-side of One-to-Many mapping
 * from {@code Student} to {@link CourseMember}
 * ultimately facilitates a Many-to-Many mapping
 * to {@link Course}
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String profilePhotoUrl;

    /**
     * passive side of one-to-many link between
     * between {@code Student} and {@link CourseMember}
     */
    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private Set<CourseMember> memberships;
}
