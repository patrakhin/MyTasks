import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class test_2 {

    @Test
    void bastShoe() {
        //test Put + Output and Undo
        String actual = Level1.BastShoe("1 a");
        String expected = "a";
        assertEquals(expected, actual);

        String actual_1 = Level1.BastShoe("1 b");
        String expected_1 = "ab";
        assertEquals(expected_1, actual_1);

        String actual_2 = Level1.BastShoe("1 c");
        String expected_2 = "abc";
        assertEquals(expected_2, actual_2);

        String actual_3 = Level1.BastShoe("3 0");
        String expected_3 = "a";
        assertEquals(expected_3, actual_3);

        String actual_4 = Level1.BastShoe("3 1");
        String expected_4 = "b";
        assertEquals(expected_4, actual_4);

        String actual_5 = Level1.BastShoe("3 2");
        String expected_5 = "c";
        assertEquals(expected_5, actual_5);

        String actual_6 = Level1.BastShoe("4");
        String expected_6 = "ab";
        assertEquals(expected_6, actual_6);

        String actual_7 = Level1.BastShoe("4");
        String expected_7 = "a";
        assertEquals(expected_7, actual_7);

        String actual_8 = Level1.BastShoe("4");
        String expected_8 = "";
        assertEquals(expected_8, actual_8);

        String actual_9 = Level1.BastShoe("4");
        String expected_9 = "";
        assertEquals(expected_9, actual_9);

    }
}