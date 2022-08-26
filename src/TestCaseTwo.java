import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCaseTwo {
    @Test
    void bastShoe() {
        String actual = Level1.BastShoe("1 a");
        String expected = "a";
        assertEquals(expected, actual);

        String actual_1 = Level1.BastShoe("1 b");
        String expected_1 = "ab";
        assertEquals(expected_1, actual_1);

        String actual_2 = Level1.BastShoe("1 c");
        String expected_2 = "abc";
        assertEquals(expected_2, actual_2);

        String actual_3 = Level1.BastShoe("1 d");
        String expected_3 = "abcd";
        assertEquals(expected_3, actual_3);

        String actual_4 = Level1.BastShoe("1 e");
        String expected_4 = "abcde";
        assertEquals(expected_4, actual_4);

        String actual_5 = Level1.BastShoe("4");
        String expected_5 = "abcd";
        assertEquals(expected_5, actual_5);

        String actual_6 = Level1.BastShoe("4");
        String expected_6 = "abc";
        assertEquals(expected_6, actual_6);

        String actual_7 = Level1.BastShoe("4");
        String expected_7 = "ab";
        assertEquals(expected_7, actual_7);

        String actual_8 = Level1.BastShoe("4");
        String expected_8 = "a";
        assertEquals(expected_8, actual_8);

        String actual_9 = Level1.BastShoe("4");
        String expected_9 = "";
        assertEquals(expected_9, actual_9);
    }
}