import org.cristian.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    @DisplayName("isPostalCodeValid: A1B2C3 -> true")
    public void testIsPostalCodeValid1() {
        String postalCode = "A1B2C3";

        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: A1BC3 -> false")
    public void testIsPostalCodeValid2() {
        String postalCode = "A1BC3";

        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: null -> false")
    public void testIsPostalCodeValid3() {
        String postalCode = null;

        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: 1A2B3C -> false")
    public void testIsPostalCodeValid4() {
        String postalCode = "1A2B3C";

        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: A1B2C3D4E5 -> false")
    public void testIsPostalCodeValid5() {
        String postalCode = "A1B2C3D4E5";

        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: B2C3A1 -> true")
    public void testIsPostalCodeValid6() {
        String postalCode = "B2C3A1";

        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }
}
