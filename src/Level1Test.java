import static org.junit.jupiter.api.Assertions.*;

class Level1Test {

    @org.junit.jupiter.api.Test
    void biggerGreater1 () {
        String actual = Level1.BiggerGreater("ая");
        String expected = "яа";
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void biggerGreater2 () {
        String actual = Level1.BiggerGreater("fff");
        String expected = "";
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void biggerGreater3 () {
        String actual = Level1.BiggerGreater("нклм");
        String expected = "нкмл";
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void biggerGreater4 () {
        String actual = Level1.BiggerGreater("вибк");
        String expected = "викб";
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void biggerGreater5 () {
        String actual = Level1.BiggerGreater("вкиб");
        String expected = "ибвк";
        assertEquals(expected, actual);
    }
}