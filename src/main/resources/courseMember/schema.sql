CREATE TABLE IF NOT EXISTS course_member
(
    course_id  BIGINT REFERENCES course (id),
    student_id BIGINT REFERENCES student (id),
    PRIMARY KEY (course_id, student_id)
);
