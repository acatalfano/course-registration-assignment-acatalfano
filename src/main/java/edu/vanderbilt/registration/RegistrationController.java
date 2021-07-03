package edu.vanderbilt.registration;

import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    public static final String API_VERSION = "1.0";

    public static final String COURSE_ID_PARAMETER = "courseId";
    public static final String STUDENT_ID_PARAMETER = "studentId";

    public static final String STUDENT_PATH = "/api/" + API_VERSION +"/student";
    public static final String INDIVIDUAL_STUDENT_PATH = STUDENT_PATH +"/{" + STUDENT_ID_PARAMETER + "}";

    public static final String COURSE_PATH = "/api/" + API_VERSION +"/course";
    public static final String INDIVIDUAL_COURSE_PATH = COURSE_PATH +"/{" + COURSE_ID_PARAMETER + "}";
    public static final String INDIVIDUAL_COURSE_STUDENT_PATH = INDIVIDUAL_COURSE_PATH +"/{" + STUDENT_ID_PARAMETER + "}";
}
