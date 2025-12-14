package org.cristian;

public class Main {
    public static void main(String[] args) {
        Address address = new Address(1234, "Sigma", "Alpha", Address.Province.QC, "A1B2C3");
        Department department = new Department("Chemistry");
        Student student1 = new Student("John Pork", Student.Gender.MALE, address, department);
        Student student2 = new Student("Tim Cheese", Student.Gender.MALE, address, department);
        Student student3 = new Student("Marge Simpson", Student.Gender.FEMALE, address, department);
        Course course = new Course("Looksmaxxing", 2.5, department);

        course.registerStudent(student1);
        course.registerStudent(student2);
        course.registerStudent(student3);

        course.addAssignment("Molecules", 35);
        course.addAssignment("Gaz", 20);
        course.addAssignment("Solutions", 40);
        course.addAssignment("Sigma bonds", 5);

        course.generateScores();
        course.displayScores();
    }
}
