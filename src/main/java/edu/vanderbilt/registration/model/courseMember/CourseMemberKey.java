package edu.vanderbilt.registration.model.courseMember;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


/**
 * This class encodes the composite ID used by the {@link CourseMember} entity
 * The primary key consists of the {@code STUDENT_ID} and {@code COURSE_ID} columns
 */
@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Builder
@Embeddable
public class CourseMemberKey implements Serializable {
    @Column(name = "STUDENT_ID")
    private final long studentId;

    @Column(name = "COURSE_ID")
    private final long courseId;
}
