import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
class TestThreeOfLife {

    @org.junit.jupiter.api.Test
    void treeOfLife1 () {
        String [] start= {".+..", "..+.", ".+.."};
        String  actual = Arrays.toString(Level1.TreeOfLife(3, 4, 1, start));
        String expected = Arrays.toString( new String[]{"++++", "++++", "++++"});
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void treeOfLife2 () {
        String [] start= {".+..", "..+.", ".+.."};
        String  actual = Arrays.toString(Level1.TreeOfLife(3, 4, 2, start));
        String expected = Arrays.toString( new String[]{"...+", "+...", "...+"});
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void treeOfLife3 () {
        String [] start= {".+..", "..+.", ".+.."};
        String  actual = Arrays.toString(Level1.TreeOfLife(3, 4, 3, start));
        String expected = Arrays.toString( new String[]{"++++", "++++", "++++"});
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void treeOfLife4 () {
        String [] start= {".+..", "..+.", ".+.."};
        String  actual = Arrays.toString(Level1.TreeOfLife(3, 4, 4, start));
        String expected = Arrays.toString( new String[]{".+..", "..+.", ".+.."});
        assertEquals(expected, actual);
    }
}