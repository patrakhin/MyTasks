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
    }
}
