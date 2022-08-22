import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestThree {
    @BeforeAll
    static void bastShoe_3 () {
        String start = "1 Privet";
        Level1.BastShoe(start);
    }
    @Test
    void bastShoe() {
        String actual = Level1.BastShoe("3 0");
        String expected = "P";
        assertEquals(expected, actual);

        String actual_1 = Level1.BastShoe("2 2");
        String expected_1 = "Priv";
        assertEquals(expected_1, actual_1);

        String actual_2 = Level1.BastShoe("4");
        String expected_2 = "Privet";
        assertEquals(expected_2, actual_2);

        String actual_3 = Level1.BastShoe("5");
        String expected_3 = "Priv";
        assertEquals(expected_3, actual_3);

    }
}