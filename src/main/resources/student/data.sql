INSERT INTO student (id, first_name, last_name, profile_photo_url)
VALUES (1, 'fred', 'jones', 'url.1')
     , (2, 'lisa', 'simpson', 'url.2')
     , (3, 'santa', 'claus', 'url.3')
     , (4, 'mrs', 'claus', 'url.4')
;

INSERT INTO course (id, title, description)
VALUES (1, 'CS 101', 'Intro to CS')
     , (2, 'EECS 281', 'The bane of my undergrad')
     , (3, 'EECS 280', 'A huge difference for just 1 number!')
     , (4, 'CS 6000', 'b.c at Vandy, our courses get 4 digits!')
;

INSERT INTO course_member (course_id, student_id)
VALUES (1, 4)
     , (1, 3)
     , (2, 1)
     , (3, 2)
     , (4, 3)
     , (3, 2)
;
