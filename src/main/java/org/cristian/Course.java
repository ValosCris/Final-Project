package org.cristian;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@EqualsAndHashCode
@Setter
@Getter
public class Course {
    private String courseId; //auto increase + follow style: C-departmentId-twoDigitCourseId`, e.g.: `C-D01-01`, `C-D01-05
    private String courseName; //Note: has to be titlecased, use Util class
    private double credits; //e.g: 1.5, 2, 2.5, 3
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;

    private static int nextId = 1; //to indicate the next ID that will be used

    /**
     * checks if sum of weights of all assignments of that course equals to 100%
     *
     * @return a boolean value depending on if the sum of weight of all assignment of that course equal 100%
     */
    public boolean isAssignmentWeightValid() {

    }

    /**
     * adds a student to the student list of the course,
     * adds a null element to each assignment of this course,
     * adds a new null element for the finalScores
     *
     * @param student the given object of Student
     * @return a boolean value depending on if the student was registered
     */
    public boolean registerStudent(Student student) {

    }

    /**
     * calculates the weighted average score of a student
     *
     * @return the int array that holds the values of the averages
     */
    public int[] calcStudentsAverage() {

    }

    /**
     * adds a new assignment to the course, always return `true`
     *
     * @param assignmentName the given string representing the name of the assignment
     * @param weight         the given double value representing the weight
     * @return a boolean value, always true as mentioned above
     */
    public boolean addAssignment(String assignmentName, double weight) {

    }

    /**
     * generates random scores for each assignment and student,
     * and calculates the final score for each student.
     */
    public void generateScores() {

    }

    /**
     * displays the scores of a course in a table,
     * with the assignment averages and student weighted average
     */
    //Note: (helper methods might be required)
    public void displayScores() {

    }

    //add String toSimplifiedString method
    //add String toString method

}
