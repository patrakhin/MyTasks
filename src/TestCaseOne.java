import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCaseOne {
    @Test
    void bastShoe() {
        String actual_1 = Level1.BastShoe("1 Hello");
        String expected_1 = "Hello";
        assertEquals(expected_1, actual_1);

        String actual_2 = Level1.BastShoe("1 , World!");
        String expected_2 = "Hello, World!";
        assertEquals(expected_2, actual_2);

        String actual_3 = Level1.BastShoe("1 ++");
        String expected_3 = "Hello, World!++";
        assertEquals(expected_3, actual_3);

        String actual_4 = Level1.BastShoe("4");
        String expected_4 = "Hello, World!";
        assertEquals(expected_4, actual_4);

        String actual_5 = Level1.BastShoe("4");
        String expected_5 = "Hello";
        assertEquals(expected_5, actual_5);

        String actual_6 = Level1.BastShoe("5");
        String expected_6 = "Hello, World!";
        assertEquals(expected_6, actual_6);

        String actual_7 = Level1.BastShoe("4");
        String expected_7 = "Hello";
        assertEquals(expected_7, actual_7);

        String actual_8 = Level1.BastShoe("5");
        String expected_8 = "Hello, World!";
        assertEquals(expected_8, actual_8);

        String actual_9= Level1.BastShoe("5");
        String expected_9 = "Hello, World!++";
        assertEquals(expected_9, actual_9);

        String actual_10= Level1.BastShoe("5");
        String expected_10 = "Hello, World!++";
        assertEquals(expected_10, actual_10);

        String actual_11 = Level1.BastShoe("5");
        String expected_11 = "Hello, World!++";
        assertEquals(expected_11, actual_11);

        String actual_12 = Level1.BastShoe("4");
        String expected_12 = "Hello, World!";
        assertEquals(expected_12, actual_12);

        String actual_13 = Level1.BastShoe("4");
        String expected_13 = "Hello";
        assertEquals(expected_13, actual_13);

        String actual_14 = Level1.BastShoe("2 2");
        String expected_14 = "Hel";
        assertEquals(expected_14, actual_14);

        String actual_15 = Level1.BastShoe("4");
        String expected_15 = "Hello";
        assertEquals(expected_15, actual_15);

        String actual_16 = Level1.BastShoe("5");
        String expected_16 = "Hel";
        assertEquals(expected_16, actual_16);

        String actual_17 = Level1.BastShoe("5");
        String expected_17 = "Hel";
        assertEquals(expected_17, actual_17);

        String actual_18 = Level1.BastShoe("5");
        String expected_18 = "Hel";
        assertEquals(expected_18, actual_18);
    }
}