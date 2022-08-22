import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestFive {

    @Test
    void bastShoe() {
        //excepted item
        Level1.BastShoe("1 Privet");
        String actual = Level1.BastShoe("3 4");
        String expected = "e";
        assertEquals(expected, actual);
    }
}