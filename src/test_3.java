import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class test_3 {

    @Test
    void bastShoe() {
        //test restore Undo
        String actual_5 = Level1.BastShoe("1 a");
        String expected_5 = "a";
        assertEquals(expected_5, actual_5);

        String actual_6 = Level1.BastShoe("1 b");
        String expected_6 = "ab";
        assertEquals(expected_6, actual_6);

        String actual_7 = Level1.BastShoe("1 c");
        String expected_7 = "abc";
        assertEquals(expected_7, actual_7);

        String actual_8 = Level1.BastShoe("1 d");
        String expected_8 = "abcd";
        assertEquals(expected_8, actual_8);

        String actual_9 = Level1.BastShoe("1 e");
        String expected_9 = "abcde";
        assertEquals(expected_9, actual_9);

        String actual_9_1 = Level1.BastShoe("4");
        String expected_9_1 = "abcd";
        assertEquals(expected_9_1, actual_9_1);
    }
}