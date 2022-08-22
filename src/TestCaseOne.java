import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCaseOne {

    @Test
    void bastShoe() {
        //excepted item
        Level1.BastShoe("1 Privet");
        String actual = Level1.BastShoe("3 0");
        String expected = "P";
        assertEquals(expected, actual);
    }
}