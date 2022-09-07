import java.util.*;
public class Level1 {
    public static boolean Football (int F[], int N) {
        int [] increasing = new int[F.length];
        int [] decreasing = new int [F.length];
        int [] revers = new  int [F.length];
        int countChangeIncreasing = 0;
        int countChangeDecreasing = 0;
        int countRevers = 0;
        int lost = 0;
        //sort by increasing
        System.arraycopy(F, 0, increasing, 0, F.length);
        Arrays.sort(increasing);
        //sort by decreasing
        System.arraycopy(F, 0, decreasing, 0, F.length);
        for ( int i = 1; i < decreasing.length; ++i ) {
            if ( decreasing [i-1] < decreasing [i] )
            {
                int tmp = decreasing [i-1];
                decreasing [i-1] = decreasing [i];
                decreasing [i] = tmp;
            }
        }
        //revers
        System.arraycopy(F, 0, revers, 0, F.length);
        for (int i = 0; i < N / 2; i++) {
            int temp = revers [i];
            revers [i] = revers[N - 1 - i];
            revers [N - 1 - i] = temp;
        }

        // compare index
        for (int i = 0; i < F.length; i++) {
            if (F [i] == increasing [i]) {
                countChangeIncreasing += 1;
            }
            if (F [i] == decreasing [i]) {
                countChangeDecreasing += 1;
            }
            if (F [i] == revers [i]) {
                countRevers += 1;
            }
            if (F [i] != increasing [i]) {
                lost += 1;
            }
        }
        // logic
        //if revers
        if (countRevers == N) {
            return true;
        }
        if (lost == countChangeDecreasing) {
            return true;
        }
        //if change
        if (countChangeIncreasing == N) {
            return false;
        }
        return lost == 2;
    }
}
