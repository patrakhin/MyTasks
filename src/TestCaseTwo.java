import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCaseTwo {
    @Test
    void bastShoe() {
        String actual = Level1.BastShoe("1 Privet");
        String expected = "Privet";
        assertEquals(expected, actual);

        String actual_0 = Level1.BastShoe("1  Mir");
        String expected_0 = "Privet Mir";
        assertEquals(expected_0, actual_0);

        String actual_0_1 = Level1.BastShoe("1 ++");
        String expected_0_1 = "Privet Mir++";
        assertEquals(expected_0_1, actual_0_1);

        String actual_1_0 = Level1.BastShoe("3 7");
        String expected_1_0 = "M";
        assertEquals(expected_1_0, actual_1_0);

        String actual_1 = Level1.BastShoe("3 8");
        String expected_1 = "i";
        assertEquals(expected_1, actual_1);

        String actual_1_1 = Level1.BastShoe("3 9");
        String expected_1_1 = "r";
        assertEquals(expected_1_1, actual_1_1);

        String actual_1_3_1_1 = Level1.BastShoe("1  Privet");
        String expected_1_3_1_1 = "Privet Mir++r Privet";
        assertEquals(expected_1_3_1_1, actual_1_3_1_1);

        String actual_2 = Level1.BastShoe("4");
        String expected_2 = "Privet Mir++";
        assertEquals(expected_2, actual_2);

        String actual_2_0 = Level1.BastShoe("5");
        String expected_2_0 = "Privet Mir++r Privet";
        assertEquals(expected_2_0, actual_2_0);

        String actual_2_1 = Level1.BastShoe("4");
        String expected_2_1 = "Privet Mir++";
        assertEquals(expected_2_1, actual_2_1);

        String actual_2_1_1 = Level1.BastShoe("1 )"); // Reload !!!
        String expected_2_1_1 = "Privet Mir++)";
        assertEquals(expected_2_1_1, actual_2_1_1);

        String actual_3 = Level1.BastShoe("1 A");
        String expected_3 = "Privet Mir++)A";
        assertEquals(expected_3, actual_3);

        String actual_3_1 = Level1.BastShoe("3 7");
        String expected_3_1 = "M";
        assertEquals(expected_3_1, actual_3_1);

        String actual_3_1_1 = Level1.BastShoe("4");
        String expected_3_1_1 = "Privet Mir++)M";
        assertEquals(expected_3_1_1, actual_3_1_1);

    }
}