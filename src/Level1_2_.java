import java.util.*;
public class Level1 {
    public static int odometer (int [] oksana) {
        int allWay = 0;
        for (int i = 0; i < oksana.length; i++) {
            if (i == 0) {
                allWay += (oksana [i] * oksana [i + 1]);
            }
            if (i % 2 == 0 && i > 0) {
               allWay += oksana [i] * (oksana [i + 1] - oksana [i - 1]);
            }
        }
        return allWay;
    }
}
