package edu.vanderbilt.registration.repository;

import edu.vanderbilt.registration.model.courseMember.CourseMember;
import edu.vanderbilt.registration.model.courseMember.CourseMemberKey;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repository for the {@link CourseMember} mapping-table entity
 */
public interface CourseMemberRepository
        extends JpaRepository<CourseMember, CourseMemberKey> {}
