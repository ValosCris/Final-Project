# Final Project

## Author: Ioan Cristian Valoschi 6318136

This is the final project for the course Introduction to Programming at Vanier College.

## Classes

### Address 
    student address, validates postal codes like A1B2C3 which have length of 6 and alternate with letter and digit.

### Department 
    checks if departmentName is only made of letters and spaces, with IDs that automatically increase in the style D01, letter D followed by two digits.

### Student 
    can register/drop courses, students with automatically increased IDs of the style S000001 : letter S followed by 6 digits.

### Assignment 
    calculates assignment average, generates random scores for the students in an assignment.

### Course 
    verifies if an assignment weight is valid so that all assignments sum up to 100%, registers students, calculates average for every student, adds assignments, generates and displays scores.

### Util 
    has the method toTitleCase, used to titleCase `studentName`, `departmentName`, `courseName`

## Notes
    Each class has its own testing, e.g: DepartmentTest, AddressTest, and so on.
    In the Main class, the displayScores method from Course class is being tested to visualize better the output.

## Custom toString methods
    Student and Course classes have a customized toString and toSimplifiedString because I had to format it in a way that lombok cannot provide.