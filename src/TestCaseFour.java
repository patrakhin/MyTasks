import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestFour {

    @Test
    void bastShoe() {
        //excepted item
        Level1.BastShoe("1 Privet");
        String actual = Level1.BastShoe("3 3");
        String expected = "v";
        assertEquals(expected, actual);
    }
}