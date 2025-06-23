package part3;

public class CourseEnrollmentManager {

    public static void enrollStudent(String studentId, String courseId, EligibilityRule rule) {
        System.out.println("Attempting to enroll " + studentId + " in " + courseId + "...");

        try {
            if (rule.isEligible(studentId, courseId)) {
                System.out.println("Enrollment successful for " + studentId + " in " + courseId + "! Happy learning!");
            } else {
                System.out.println("Enrollment failed: " + studentId + " is not eligible for " + courseId + ".");
            }
        } catch (EnrollmentDeniedException e) {
            System.out.println("Enrollment failed for " + studentId + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Lambda for rule
        EligibilityRule rule = (studentId, courseId) -> {
            if ("SKILL999".equals(studentId)) {
                throw new EnrollmentDeniedException("Student account suspended due to outstanding fees, Roshan!");
            }
            if ("JAVA101".equals(courseId) && !studentId.startsWith("SKILL")) {
                throw new EnrollmentDeniedException("Invalid student ID format. Please use 'SKILL' prefix, Anisha!");
            }
            return "SKILL".equals(studentId.substring(0, 5)) && "JAVA101".equals(courseId);
        };

        enrollStudent("SKILL123", "JAVA101", rule);     
        enrollStudent("SKILL999", "PYTHON202", rule);  
        enrollStudent("STUDENT001", "JAVA101", rule);   
        enrollStudent("SKILL456", "MATH300", rule);    
    }
}
