import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCaseOne {
    @BeforeAll
    static void bastShoe_0 () {
        String start = "1 Privet";
        Level1.BastShoe(start);
    }
    @Test
    void bastShoe() {
        //excepted item
        String actual = Level1.BastShoe("3 0");
        String expected = "P";
        assertEquals(expected, actual);

        String actual_1 = Level1.BastShoe("3 1");
        String expected_1 = "r";
        assertEquals(expected_1, actual_1);

        String actual_2 = Level1.BastShoe("3 2");
        String expected_2 = "i";
        assertEquals(expected_2, actual_2);

        String actual_3 = Level1.BastShoe("3 3");
        String expected_3 = "v";
        assertEquals(expected_3, actual_3);

        String actual_4 = Level1.BastShoe("3 4");
        String expected_4 = "e";
        assertEquals(expected_4, actual_4);

        String actual_5 = Level1.BastShoe("3 5");
        String expected_5 = "t";
        assertEquals(expected_5, actual_5);
    }
}