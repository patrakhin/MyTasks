import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestLevel1 {

    @Test
    void test_1a() {
        //test restore Undo
        String actual = Level1.BastShoe("1 a");
        String expected = "a";
        assertEquals(expected, actual);

        String actual_1 = Level1.BastShoe("1 b");
        String expected_1 = "ab";
        assertEquals(expected_1, actual_1);

        String actual_5 = Level1.BastShoe("4");
        String expected_5 = "a";
        assertEquals(expected_5, actual_5);

        String actual_6 = Level1.BastShoe("1 BC");
        String expected_6 = "aBC";
        assertEquals(expected_6, actual_6);

        String actual_7 = Level1.BastShoe("4");
        String expected_7 = "a";
        assertEquals(expected_7, actual_7);

        String actual_8 = Level1.BastShoe("5");
        String expected_8 = "aBC";
        assertEquals(expected_8, actual_8);

        String actual_9 = Level1.BastShoe("5");
        String expected_9 = "aBC";
        assertEquals(expected_9, actual_9);

        String actual_9_1 = Level1.BastShoe("5");
        String expected_9_1 = "aBC";
        assertEquals(expected_9_1, actual_9_1);
    }

    @Test
    void test_2a() {
        //test forever Undo
        String actual2_1 = Level1.BastShoe("1 a");
        String expected2_1 = "a";
        assertEquals(expected2_1, actual2_1);

        String actual2_2 = Level1.BastShoe("1 b");
        String expected2_2 = "ab";
        assertEquals(expected2_2, actual2_2);

        String actual2_3 = Level1.BastShoe("4");
        String expected2_3 = "a";
        assertEquals(expected2_3, actual2_3);

        String actual2_4 = Level1.BastShoe("4");
        String expected2_4 = "";
        assertEquals(expected2_4, actual2_4);

        String actual2_5 = Level1.BastShoe("4");
        String expected2_5 = "";
        assertEquals(expected2_5, actual2_5);

        String actual2_8 = Level1.BastShoe("4");
        String expected2_8 = "";
        assertEquals(expected2_8, actual2_8);
    }
}