package org.cristian;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import util.Util;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private final String studentId; //not sure but assuming from instructions that it's letter S followed by 6 digits
    private String studentName; //in title case like departmentName and courseName
    private Gender gender;
    private Address address;
    private Department department;
    private List<Course> registeredCourses;

    private static int nextId = 1; //changes after nextId++ to provide other IDs

    public enum Gender {
        MALE, FEMALE
    }

    /**
     * registers a course, adds the course to the student's list of registeredCourses
     * then adds the student to the course's list of registeredStudents
     * and appends a null value for the scores of each assignment of the course
     * Note: if the course exists already in the student's list of registeredCourses
     * -> return false directly without adding anything.
     *
     * @param course the given object of Course
     * @return a boolean value depending on if the course was registered or not
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) { //in case course is existing already in list of registeredCourses
            return false;
        }

        registeredCourses.add(course);

        if (!course.getRegisteredStudents().contains(this)) { //if student not already in course -> add student
            course.getRegisteredStudents().add(this);
        }

        for (Assignment assignment : course.getAssignments()) { //use of enhanced for loop because we just go through assignments
            assignment.getScores().add(null); //to add null to every assignment score
        }

        return true;
    }

    /**
     * drops a course, removes the course from the student's list of registeredCourses
     * and removes the student from the course's list of registeredStudents
     * Note: if course is not already in the student's list of registeredCourses
     * -> return false directly without removing anything.
     *
     * @param course the given object of Course
     * @return a boolean value depending on if the course was dropped or not
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) { //in case course is not in list of registeredCourses
            return false;
        }

        registeredCourses.remove(course); //remove course from registered course

        course.getRegisteredStudents().remove(this); //get rid of student from registered student

        return true;
    }

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = Util.toTitleCase(studentName); //needs to be titlecased
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>(); //told to make it empty arraylist
    }

    /**
     * converts a student to a simple string
     *
     * @return a simple string with only the `studentId`, the `studentName`, and `departmentName`
     */
    public String toSimplifiedString() {
        String deptName = "";
        if (department != null && department.getDepartmentName() != null) {
            deptName = department.getDepartmentName();
        }

        return studentId + ", " + studentName + ", " + deptName; //string concatenation to convert to string
    }

    /**
     * converts a student to a string that contains the `studentId`, the `studentName`,
     * the `gender`, the `address` and the `department`,
     * and the `registeredCourses` (only the `courseId`, the `courseName`, and the `departmentName`)
     *
     * @return a string with all student details
     */
    @Override
    public String toString() {
        String studentDetails = "Student ID: " + studentId +
                "\nName: " + studentName +
                "\nGender: " + gender +
                "\nAddress: " + address +
                "\nDepartment: " + department +
                "\nRegistered Courses:";

        if (registeredCourses.isEmpty()) {
            studentDetails += " Nothing";
        } else {
            for (Course course : registeredCourses) {
                studentDetails += "\n" + course.getCourseId() +
                        ": " + course.getCourseName() +
                        ", dept: " + course.getDepartment().getDepartmentName();
            }
        }

        return studentDetails;
    }
}
