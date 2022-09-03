import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TestMatrixSpin {

    @org.junit.jupiter.api.Test
    void matrixTurn1 () {
        Level1 level1 = new Level1();
        String [] Matrix = new String[] {"12", "43"};
        level1.MatrixTurn(Matrix, 2, 2, 1);
        String [] actual= level1.getMatrix();
        String [] expected = {"41", "32"};
        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void matrixTurn2 () {
        Level1 level1 = new Level1();
        String [] Matrix = new String[] {"12345", "23456", "34567", "45678"};
        level1.MatrixTurn(Matrix, 4, 5, 1);
        String [] actual= level1.getMatrix();
        String [] expected = {"21234", "34345", "45656", "56787"};
        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void matrixTurn3 () {
        Level1 level1 = new Level1();
        String [] Matrix = new String[] {"1234", "2345", "3456", "4567", "5678"};
        level1.MatrixTurn(Matrix, 5, 4, 1);
        String [] actual= level1.getMatrix();
        String [] expected = {"2123", "3434", "4545", "5656", "6787"};
        assertArrayEquals(expected, actual);
    }
}