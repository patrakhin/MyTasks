import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

class Level1Test {
    @BeforeAll
    static void test_0 () {
        String actual = "1 Privet";
        Level1.BastShoe(actual);
    }

    @org.junit.jupiter.api.Test
    void test_1 () {
        String expected = "";
        String expected_2 = "Privet";
        // expected empty string
        String actual_1 = Level1.BastShoe("3 -1");
        assertEquals(expected, actual_1);

        String actual_2_1 = Level1.BastShoe("3 6");
        assertEquals(expected, actual_2_1);

        // expected current string
        String actual_3_1 = Level1.BastShoe("3");
        assertEquals(expected_2, actual_3_1);

        String actual_4_1 = Level1.BastShoe("3 ");
        assertEquals(expected_2, actual_4_1);

        String actual_5_1 = Level1.BastShoe("3d");
        assertEquals(expected_2, actual_5_1);

        String actual_6_1 = Level1.BastShoe("34");
        assertEquals(expected_2, actual_6_1);

        String actual_7_1 = Level1.BastShoe("3-");
        assertEquals(expected_2, actual_7_1);

        //excepted item
        String actual_8_1 = Level1.BastShoe("3 0");
        String expected_8 = "P";
        assertEquals(expected_8, actual_8_1);

        Level1.BastShoe("1 rivet");
        String actual_9_1 = Level1.BastShoe("3 1");
        String expected_9 = "r";
        assertEquals(expected_9, actual_9_1);

        Level1.BastShoe("4");
        String actual_10_1 = Level1.BastShoe("3 2");
        String expected_10 = "i";
        assertEquals(expected_10, actual_10_1);

        Level1.BastShoe("4");
        Level1.BastShoe("5");
        String actual_11_1 = Level1.BastShoe("3 3");
        String expected_11 = "v";
        assertEquals(expected_11, actual_11_1);

        Level1.BastShoe("4");
        Level1.BastShoe("5");
        String actual_12_1 = Level1.BastShoe("3 4");
        String expected_12 = "e";
        assertEquals(expected_12, actual_12_1);

        Level1.BastShoe("4");
        Level1.BastShoe("5");
        String actual_13_1 = Level1.BastShoe("3 5");
        String expected_13 = "t";
        assertEquals(expected_13, actual_13_1);
    }

}
