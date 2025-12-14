import org.cristian.Address;
import org.cristian.Course;
import org.cristian.Department;
import org.cristian.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    @DisplayName("registerCourse: one simple registering -> true")
    public void testRegisterCourse1() {
        Address address = new Address(1234, "Sigma", "Alpha", Address.Province.QC, "A1B2C3");
        Department department = new Department("Chemistry");
        Student student = new Student("John Pork", Student.Gender.MALE, address, department);
        Course course = new Course("Looksmaxxing", 2.5, department);

        boolean expected = true;
        boolean actual = student.registerCourse(course);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("registerCourse: registering twice the same -> false")
    public void testRegisterCourse2() {
        Address address = new Address(1234, "Sigma", "Alpha", Address.Province.QC, "A1B2C3");
        Department department = new Department("Chemistry");
        Student student = new Student("John Pork", Student.Gender.MALE, address, department);
        Course course = new Course("Looksmaxxing", 2.5, department);

        student.registerCourse(course);
        boolean expected = false;
        boolean actual = student.registerCourse(course);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("dropCourse: course not initially registered -> false ")
    public void testDropCourse1() {
        Address address = new Address(1234, "Sigma", "Alpha", Address.Province.QC, "A1B2C3");
        Department department = new Department("Chemistry");
        Student student = new Student("John Pork", Student.Gender.MALE, address, department);
        Course course = new Course("Looksmaxxing", 2.5, department);

        boolean expected = false;
        boolean actual = student.dropCourse(course);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("dropCourse: course initially registered -> true ")
    public void testDropCourse2() {
        Address address = new Address(1234, "Sigma", "Alpha", Address.Province.QC, "A1B2C3");
        Department department = new Department("Chemistry");
        Student student = new Student("John Pork", Student.Gender.MALE, address, department);
        Course course = new Course("Looksmaxxing", 2.5, department);

        student.registerCourse(course);
        boolean expected = true;
        boolean actual = student.dropCourse(course);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toSimplifiedString: contains name of student? -> true")
    public void testToSimplifiedString1() {
        Address address = new Address(1234, "Sigma", "Alpha", Address.Province.QC, "A1B2C3");
        Department department = new Department("Chemistry");
        Student student = new Student("John Pork", Student.Gender.MALE, address, department);

        String result = student.toSimplifiedString();

        boolean expectedContainsName = true;
        boolean actualContainsName = result.contains("John Pork");

        Assertions.assertEquals(expectedContainsName, actualContainsName);
    }

    @Test
    @DisplayName("toSimplifiedString: department is null -> department name remains empty")
    public void testToSimplifiedString2() {
        Address address = new Address(1234, "Sigma", "Alpha", Address.Province.QC, "A1B2C3");
        Department department = new Department(null);
        Student student = new Student("John Pork", Student.Gender.MALE, address, department);
        String stuId = student.getStudentId();

        student.toSimplifiedString();

        String deptNameExpected = stuId + ", John Pork, ";
        String deptNameActual = stuId + ", " + student.getStudentName() + ", ";

        Assertions.assertEquals(deptNameExpected, deptNameActual);
    }
}
