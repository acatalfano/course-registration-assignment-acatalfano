// @@ Great job commenting your code!
package edu.vanderbilt.registration;

import org.springframework.web.bind.annotation.RestController;


/**
 * This class contains all the endpoint and parameter constants
 * used by the other Controllers
 */
@RestController
public class RegistrationController {

    /**
     * The API version handled by this Controller
     */
    private static final String API_VERSION = "1.0";
    /**
     * Path fragment for API-versioning that's encoded in every endpoint's URL
     */
    private static final String API_PATH = "/api" + API_VERSION;

    /**
     * Path fragment used for accessing {@link edu.vanderbilt.registration.model.Student} resources
     */
    public static final String STUDENT_PATH = API_PATH + "/student";
    /**
     * Path fragment used for accessing {@link edu.vanderbilt.registration.model.Course} resource
     */
    public static final String COURSE_PATH = API_PATH + "/course";

    /**
     * Path parameters
     */
    public static final String COURSE_ID_PARAMETER = "courseId";
    public static final String STUDENT_ID_PARAMETER = "studentId";

    /**
     * Path for accessing a specific {@link edu.vanderbilt.registration.model.Student} resource
     */
    public static final String INDIVIDUAL_STUDENT_PATH =
            STUDENT_PATH + "/{" + STUDENT_ID_PARAMETER + "}";

    /**
     * Path for accessing a specific {@link edu.vanderbilt.registration.model.Course} resource
     */
    public static final String INDIVIDUAL_COURSE_PATH =
            COURSE_PATH + "/{" + COURSE_ID_PARAMETER + "}";

    /**
     * Path for accessing a specific {@link edu.vanderbilt.registration.model.Student} resource
     * who is registered for a specific {@link edu.vanderbilt.registration.model.Course}
     */
    public static final String INDIVIDUAL_COURSE_STUDENT_PATH =
            INDIVIDUAL_COURSE_PATH + "/{" + STUDENT_ID_PARAMETER + "}";
}
