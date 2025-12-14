import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Util;

public class UtilTest {

    @Test
    @DisplayName("toTitleCase: i love oranges -> I Love Oranges")
    public void testToTitleCase1() {
        String str = "i love oranges";

        String expected = "I Love Oranges";
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toTitleCase: null -> null")
    public void testToTitleCase2() {
        String str = null;

        String expected = null;
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toTitleCase: empty string -> empty string")
    public void testToTitleCase3() {
        String str = "";

        String expected = "";
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toTitleCase: o -> O")
    public void testToTitleCase4() {
        String str = "o";

        String expected = "O";
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }
}
