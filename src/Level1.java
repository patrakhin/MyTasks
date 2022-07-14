import java.util.*;
public class Level1 {
    public static int MaximumDiscount (int N, int [] price) {
        //variable
        int buff = 0;
        //arrange in descending order
        for (int i = 0; i < price.length; i++) {
            for (int j = i + 1; j < price.length; j++ ) {
                if (price [i] < price [j]) {
                    buff = price[j];
                    price [j] = price[i];
                    price [i] = buff;
                }
            }
        }
        // count items for free ver.1
        int freeItemsVer1 = N / 3;
        // savingsVer1
        int savingsVer1 = 0;
        int count = price.length - freeItemsVer1;
        while (count < price.length) {
            savingsVer1 += price[count];
            count += 1;
        }
        // savingsVer2
        int savingsVer2 = 0;
        for (int i = 2; i < price.length; i+=3) {
            savingsVer2 += price [i];
        }
        // comparing discount and return Max
        return Math.max(savingsVer1, savingsVer2);
    }
}
