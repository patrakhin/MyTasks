import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestSix {

    @Test
    void bastShoe() {
        //excepted item
        Level1.BastShoe("1 Privet");
        String actual = Level1.BastShoe("3 5");
        String expected = "t";
        assertEquals(expected, actual);
    }
}
