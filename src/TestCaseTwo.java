import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCaseTwo {

    @Test
    void bastShoe() {
        Level1.BastShoe("1 Privet");
        Level1.BastShoe("3 0");
        String actual = Level1.BastShoe("1 ut");
        String expected = "Put";
        assertEquals(expected, actual);
    }
}