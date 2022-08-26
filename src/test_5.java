import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class test_5 {

    @Test
    void bastShoe() {
        //test forever Redo
        String actual = Level1.BastShoe("1 a");
        String expected = "a";
        assertEquals(expected, actual);

        String actual_1 = Level1.BastShoe("1 b");
        String expected_1 = "ab";
        assertEquals(expected_1, actual_1);

        String actual_5 = Level1.BastShoe("4");
        String expected_5 = "a";
        assertEquals(expected_5, actual_5);

        String actual_6 = Level1.BastShoe("5");
        String expected_6 = "ab";
        assertEquals(expected_6, actual_6);

        String actual_7 = Level1.BastShoe("5");
        String expected_7 = "ab";
        assertEquals(expected_7, actual_7);

        String actual_8 = Level1.BastShoe("5");
        String expected_8 = "ab";
        assertEquals(expected_8, actual_8);
    }
}