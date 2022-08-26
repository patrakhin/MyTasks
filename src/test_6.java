import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class test_6 {

    @Test
    void bastShoe() {
        //test incorrect commands
        String actual = Level1.BastShoe("1 abc");
        String expected = "abc";
        assertEquals(expected, actual);

        String actual_1 = Level1.BastShoe("2 -6");
        String expected_1 = "abc";
        assertEquals(expected_1, actual_1);

        String actual_5 = Level1.BastShoe("3 100");
        String expected_5 = "";
        assertEquals(expected_5, actual_5);

        String actual_6 = Level1.BastShoe("4 4");
        String expected_6 = "abc";
        assertEquals(expected_6, actual_6);

        String actual_7 = Level1.BastShoe("5 a");
        String expected_7 = "abc";
        assertEquals(expected_7, actual_7);
    }
}