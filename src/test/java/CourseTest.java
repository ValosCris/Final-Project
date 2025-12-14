import org.cristian.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CourseTest {

    @Test
    @DisplayName("isAssignmentWeightValid: given weight < 100 -> false")
    public void testIsAssignmentWeightValid1() {
        Department department = new Department("Health science");
        Course course = new Course("Biology", 3.5, department);

        course.addAssignment("Counting", 50);
        course.addAssignment("Counting II", 49);

        boolean validityExpected = false;
        boolean validityActual = course.isAssignmentWeightValid();
        Assertions.assertEquals(validityExpected, validityActual);
    }

    @Test
    @DisplayName("isAssignmentWeightValid: given weight > 100 -> false")
    public void testIsAssignmentWeightValid2() {
        Department department = new Department("Health science");
        Course course = new Course("Biology", 3.5, department);

        course.addAssignment("Factorization", 150);

        boolean validityExpected = false;
        boolean validityActual = course.isAssignmentWeightValid();
        Assertions.assertEquals(validityExpected, validityActual);
    }

    @Test
    @DisplayName("isAssignmentWeightValid: given weights <= 100 -> true")
    public void testIsAssignmentWeightValid3() {
        Department department = new Department("Health science");
        Course course = new Course("Biology", 3, department);

        course.addAssignment("Balancing equations", 99.9);

        boolean validityExpected = true; //allows difference of 0.01
        boolean validityActual = course.isAssignmentWeightValid();
        Assertions.assertEquals(validityExpected, validityActual);
    }

    @Test
    @DisplayName("registerStudent: give student info to register works? -> true")
    public void testRegisterStudent1() {
        Address address = new Address(1234, "Sigma", "Alpha", Address.Province.QC, "A1B2C3");
        Department department = new Department("Chemistry");
        Student student = new Student("John Pork", Student.Gender.MALE, address, department);
        Course course = new Course("Looksmaxxing", 2.5, department);

        boolean registeringExpected = true;
        boolean registeringActual = course.registerStudent(student);

        Assertions.assertEquals(registeringExpected, registeringActual);
    }

    @Test
    @DisplayName("registerStudent: give student info to register twice works? -> false")
    public void testRegisterStudent2() {
        Address address = new Address(1234, "Sigma", "Alpha", Address.Province.QC, "A1B2C3");
        Department department = new Department("Chemistry");
        Student student = new Student("John Pork", Student.Gender.MALE, address, department);
        Course course = new Course("Looksmaxxing", 2.5, department);

        course.registerStudent(student);

        boolean registeringExpected = false;
        boolean registeringActual = course.registerStudent(student); //test the twice registering

        Assertions.assertEquals(registeringExpected, registeringActual);
    }

    @Test
    @DisplayName("addAssignment: adding a simple assignment to a defined course works? -> true")
    public void testAddAssignment1() {
        Department department = new Department("Chemistry");
        Course course = new Course("Looksmaxxing", 2.5, department);

        boolean addingAssignExpected = true;
        boolean addingAssignActual = course.addAssignment("Molecules", 15);

        Assertions.assertEquals(addingAssignExpected, addingAssignActual);
    }

    @Test
    @DisplayName("calcStudentsAverage: no assignments -> only zeros")
    public void testCalcStudentsAverage1() {
        Address address = new Address(1234, "Sigma", "Alpha", Address.Province.QC, "A1B2C3");
        Department department = new Department("Chemistry");
        Student student = new Student("John Pork", Student.Gender.MALE, address, department);
        Course course = new Course("Looksmaxxing", 2.5, department);

        course.registerStudent(student);

        int[] averagesExpected = {0}; // no given assignment
        int[] averagesActual = course.calcStudentsAverage();

        Assertions.assertArrayEquals(averagesExpected, averagesActual);
    }

    @Test
    @DisplayName("calcStudentsAverage: assignments with scores as null -> avg = 0")
    public void testCalcStudentsAverage2() {
        Address address = new Address(1234, "Sigma", "Alpha", Address.Province.QC, "A1B2C3");
        Department department = new Department("Chemistry");
        Student student = new Student("John Pork", Student.Gender.MALE, address, department);
        Course course = new Course("Looksmaxxing", 2.5, department);

        course.registerStudent(student);
        course.addAssignment("mini quiz", 1.0);
        course.addAssignment("Exam", 40);

        int[] averagesExpected = {0}; // only null scores because by default, so avg = 0
        int[] averagesActual = course.calcStudentsAverage();

        Assertions.assertArrayEquals(averagesExpected, averagesActual);
    }
}
