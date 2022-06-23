import java.util.*;
public class Level1 {
    public static int SumOfThe (int N, int [] data) {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;

        for ( int i =  0; i < data.length; i++) {
            if (i == 0) {
                for (int j = (i+1); j < data.length; j++) {
                    sum1 += data [j];
                }
                if (data [i] == sum1) {
                    return sum1;
                }
                sum1 = 0;
            }
            if (i != data.length - 1) {
                for (int k = i+1; k < data.length; k++) {
                    sum2 += data [k];
                }
                for (int f = 0; f < i; f++) {
                    sum3 += data[f];
                }
                if (data [i] == (sum2 + sum3)) {
                    sum4 = (sum2 + sum3);
                    return sum4;
                }
                sum2 = 0;
                sum3 = 0;
            }
            if (i == data.length - 1) {
                for (int k = 0; k < data.length - 1; k++) {
                    sum2 += data [k];
                }
                if ( data [i] == sum2)
                    data [i] = sum4;
                break;
                }
            }
        return sum4;
    }
}
