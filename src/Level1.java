import java.util.*;
public class Level1 {
    public static String Keymaker(int k) {
        StringBuilder out = new StringBuilder();
        int [] startArray = new int[k];
        int mem = 0;
        //decoding into array
        for (int i = 0; i < k; i++) {
            startArray [i] = 0;
        }
        //open and close doors
        for (int i = 1; i <= k; i ++) {
            //step one
            if (i == 1) {
                Arrays.fill(startArray, 1);
            }
            //step
            for (int b = i - 1  ; b < startArray.length && i != 1; b += i) {
                // then count = 2
                if (startArray [b] == 0) {
                    startArray [b] = 1;
                    mem = b;
                }
                if (startArray [b] == 1 && b != mem) {
                    startArray [b] = 0;
                }
            }
        }
        // reading array to string
        for (int j : startArray) {
            out.append(j);
        }
        return out.toString();
    }
}
