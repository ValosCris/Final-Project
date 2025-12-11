package org.cristian;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import util.Util;

import java.util.ArrayList;
import java.util.List;

@ToString
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

    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }
        //to be continued
        return true;
    }

    public boolean dropCourse(Course course) {
        //to be continued
        return false;
    }

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = Util.toTitleCase(studentName); //needs to be titlecased
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>(); //told to make it empty arraylist
    }

    //add simplified toString
}
