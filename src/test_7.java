import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class test_7 {

    @Test
    void bastShoe() {
        // delete more than length
        String actual = Level1.BastShoe("1 abc");
        String expected = "abc";
        assertEquals(expected, actual);

        String actual_1 = Level1.BastShoe("2 100");
        String expected_1 = "";
        assertEquals(expected_1, actual_1);

    }
}