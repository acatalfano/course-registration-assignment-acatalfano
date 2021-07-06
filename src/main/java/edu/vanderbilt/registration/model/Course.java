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
 * This class encodes the {@code Course} entity.
 *
 * Includes passive-side of One-to-Many mapping
 * from {@code Course} to {@link CourseMember}
 * ultimately facilitates a Many-to-Many mapping
 * to {@link Student}
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COURSE")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    /**
     * Passive-side of One-to-Many mapping
     * from {@code Course} to {@link CourseMember}
     */
    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private Set<CourseMember> memberships;
}
