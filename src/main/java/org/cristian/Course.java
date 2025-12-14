package org.cristian;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import util.Util;

import java.util.ArrayList;
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
    private List<Integer> finalScores;

    private static int nextId = 1; //to indicate the next ID that will be used

    public Course(String courseName, double credits, Department department) {
        this.courseId = "C-" + department.getDepartmentId() + "-" + String.format("%02d", nextId++); //string concat, match form C-DO1-01
        this.courseName = Util.toTitleCase(courseName); //titlecasing
        this.credits = credits;
        this.assignments = new ArrayList<>();
        this.department = department;
        this.finalScores = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
    }

    /**
     * checks if sum of weights of all assignments of that course equals to 100%
     *
     * @return a boolean value depending on if the sum of weight of all assignment of that course equal 100%
     */
    public boolean isAssignmentWeightValid() {
        double allWeight = 0;

        for (Assignment assignment : assignments) {
            allWeight += assignment.getWeight();
        }

        return Math.abs(allWeight - 100) <= 0.01; //so if its 99.99, 99.99 - 100 = -0.01 but abs makes it 0.01 so it's fine
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
        if (registeredStudents.contains(student)) {
            return false; //cannot have repetition
        }

        registeredStudents.add(student);

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null); //add null to each
        }

        finalScores.add(null); //add one null

        return true;
    }

    /**
     * calculates the weighted average score of a student
     *
     * @return the int array that holds the values of the averages
     */
    //public int[] calcStudentsAverage() {

    //}

    /**
     * adds a new assignment to the course, always return `true`
     *
     * @param assignmentName the given string representing the name of the assignment
     * @param weight         the given double value representing the weight
     * @return a boolean value, always true as mentioned above
     */
    public boolean addAssignment(String assignmentName, double weight) {
        Assignment newAssign = new Assignment(assignmentName, weight);

        assignments.add(newAssign);

        for (int i = 0; i < registeredStudents.size(); i++) { //up to num of student
            newAssign.getScores().add(null);
        }

        return true; //always
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

    /**
     * converts a course to a string that contains the courseId,
     * the courseName, the credits, the departmentName, the assignments,
     * the registeredStudents (only studentId, studentName, departmentName)
     * Note: also a line to show if current isAssignmentWeightValid is valid or not
     *
     * @return a course to be a string containing all the relevant details mentioned above.
     */
    @Override
    public String toString() {
        String courseDetails = "Course ID: " + courseId + "\nCourse Name: " + courseName +
                "\nCredits: " + credits + "\nDepartment Name: " + department.getDepartmentName() +
                "\nAssignment Weights validity: " + ((isAssignmentWeightValid() ? "valid" : "not valid")) +
                "\nAssignments: ";

        if (assignments.isEmpty()) {
            courseDetails += "Nothing"; // in case there is no assignment
        } else {
            for (Assignment assignment : assignments) {
                courseDetails += "\nAssignment ID: " + assignment.getAssignmentId() +
                        "\nAssignment Name: " + assignment.getAssignmentName() +
                        "\nAssignment weight: " + assignment.getWeight() + "%";
            }
        }

        courseDetails += "\nRegistered students: ";
        if (registeredStudents.isEmpty()) {
            courseDetails += "No student"; //in case there is no one
        } else {
            for (Student student : registeredStudents) {
                courseDetails += "\n" + student.toSimplifiedString(); // to actually take the info and display it nice
            }
        }

        return courseDetails;
    }

    /**
     * converts a course to be a simple string with only courseId, courseName, credits, departmentName
     *
     * @return the string representing course with the relevant information
     */
    public String toSimplifiedString() {
        return courseId + ", " + courseName + ", " + credits + ", " + department.getDepartmentName();
    }
}
