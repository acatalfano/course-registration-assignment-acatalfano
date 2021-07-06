package edu.vanderbilt.registration.model.courseMember;

import edu.vanderbilt.registration.model.Course;
import edu.vanderbilt.registration.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;


/**
 * This class encodes the {@code CourseMember} entity.
 *
 * Includes owner-side of two Many-to-One mappings.
 * One from {@code CourseMember} to {@link Course}.
 * One from {@code CourseMember} to {@link Student}.
 * Together these mappings facilitate
 * a Many-to-Many mapping
 * between {@link Course} and {@link Student}
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "COURSE_MEMBER")
public class CourseMember {
    @EmbeddedId
    private CourseMemberKey id;

    @ManyToOne
    @MapsId("studentId")
    @Nullable
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @Nullable
    private Course course;
}
