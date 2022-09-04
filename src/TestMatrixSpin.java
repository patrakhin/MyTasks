import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TestMatrixSpin {

    @org.junit.jupiter.api.Test
    void matrixTurn1 () {

        String [] Matrix = new String[] {"12", "43"};
        Level1.MatrixTurn(Matrix, 2, 2, 1);
        String [] expected = {"41", "32"};
        assertArrayEquals(expected, Matrix);
    }

    @org.junit.jupiter.api.Test
    void matrixTurn2 () {
        String [] Matrix = new String[] {"12345", "23456", "34567", "45678"};
        Level1.MatrixTurn(Matrix, 4, 5, 1);
        String [] expected = {"21234", "34345", "45656", "56787"};
        assertArrayEquals(expected, Matrix);
    }

    @org.junit.jupiter.api.Test
    void matrixTurn3 () {
        String [] Matrix = new String[] {"1234", "2345", "3456", "4567", "5678"};
        Level1.MatrixTurn(Matrix, 5, 4, 1);
        String [] expected = {"2123", "3434", "4545", "5656", "6787"};
        assertArrayEquals(expected, Matrix);
    }

    @org.junit.jupiter.api.Test
    void matrixTurn4 () {
        String [] Matrix = new String[] {"123456", "234567", "345678", "456789"};
        Level1.MatrixTurn(Matrix, 4, 6, 1);
        String [] expected = {"212345", "343456", "456767", "567898"};
        assertArrayEquals(expected, Matrix);
    }
}