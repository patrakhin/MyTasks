import java.util.*;
public class Level1 {
    public static int squirrel (int N) {
        int orderNumber = 1;
        if (N > 0) { // filter of "0"
            int factorial = N;
            for (int i = 1; i < N; i++) { //calculation of factorial
                factorial *= i;
            }
            char [] charFactorial = String.valueOf(factorial).toCharArray(); // preparation for output
            String a = ""; // the buffer
            for (int x = 0; x < (charFactorial.length - (charFactorial.length - orderNumber)); x++) {
                a = String.valueOf(charFactorial[x]);
            }
            return Integer.parseInt(a); // output value of orderNumber
        }
        return 1; // output factorial "0"
    }
}
