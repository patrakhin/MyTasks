import java.util.*;
public class Level1 {
    public static String Keymaker(int k) {
        StringBuilder out = new StringBuilder();
        int [] startArray = new int[k];
        boolean flagOneStep = false;
        boolean flagClose = false;
        boolean flagCheck = false;
        int countClose = 0;
        int countCheck = 0;
        int closeNumber = 0;
        int checkNumber = 0;
        //decoding into array
        for (int i = 0; i < k; i++) {
            startArray [i] = 0;
        }
        //open and close doors
        for (int i = 0; i < k; i ++) {
            countClose += 1;
            countCheck += 1;
            //step one
            for (int j = 0; j < k && !flagOneStep; j++) {
                startArray[j] = 1;
                if (j == k - 1) {
                    flagOneStep = true;
                }
            }
            //step two even
            for (int a = i; a < k && (i % 2 != 0); a += countClose) {
                //  then count = 1,
                startArray [a] = 0;
            }
            //step three uneven
            for (int b = i; b < k && (i % 2 == 0) && i != 0; b += countCheck) {
                // then count = 2
                if (startArray [b] == 0) {
                    startArray [b] = 1;
                    continue;
                }
                if (startArray [b] == 1) {
                    startArray [b] = 0;
                }
            }
        }
        // reading array to string
        for (int i = 0; i < k; i++) {
            out.append(startArray[i]);
        }
        return out.toString();
    }
}
