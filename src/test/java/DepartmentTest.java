import org.cristian.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DepartmentTest {

    @Test
    @DisplayName("isDepartmentNameValid: null -> false")
    public void isDepartmentNameValid1() {
        String departmentName = null;

        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: empty -> false")
    public void isDepartmentNameValid2() {
        String departmentName = "";

        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: a b cd -> true")
    public void isDepartmentNameValid3() {
        String departmentName = "a b cd";

        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: Ab Cd1 -> false")
    public void isDepartmentNameValid4() {
        String departmentName = "Ab Cd1";

        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: space -> false")
    public void isDepartmentNameValid5() {
        String departmentName = " ";

        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }
}
