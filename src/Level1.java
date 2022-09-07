import java.util.*;
public class Level1 {
    public static boolean Football (int F[], int N) {
        int [] increasing = new int[F.length];
        int [] decreasing = new int [F.length];
        int [] revers = new  int [F.length];
        int [] pieseRevers = new  int [F.length];
        int countChangeIncreasing = 0;
        int countChangeDecreasing = 0;
        int countRevers = 0;
        int lost = 0;
        int pointA = 0;
        int pointB = 0;
        boolean flagRevers = false;
        int countPieseRevers = 0;

        //sort by increasing
        System.arraycopy(F, 0, increasing, 0, F.length);
        Arrays.sort(increasing);
        //sort by decreasing
        System.arraycopy(F, 0, decreasing, 0, F.length);
        for ( int i = 0; i < decreasing.length; ++i ) {
            for (int j = i+1; j < decreasing.length; ++j) {
                if (decreasing[j] > decreasing[i]) {
                    int tmp = decreasing[j];
                    decreasing[j] = decreasing[i];
                    decreasing[i] = tmp;
                }
            }
        }
        //revers
        System.arraycopy(F, 0, revers, 0, F.length);
        for (int i = 0; i < N / 2; i++) {
            int temp = revers [i];
            revers [i] = revers[N - 1 - i];
            revers [N - 1 - i] = temp;
        }
        // revers two
        System.arraycopy(F, 0, pieseRevers, 0, F.length);
        int k = 0;
        int countLoop = 0;
        for (; k < N - 1; k ++) {

            if (F[k] > F [k+1] && !flagRevers) {
                pointA = k;
                flagRevers = true;
                countLoop += 1;
            }
            if (F[k] < F[k+1] && flagRevers && (pointA != k)) {
                pointB = k;
                k = N-1;
            }
            if (k+1 == N - 1 && flagRevers && (pointA != k)) {
                pointB = k + 1;
                k = N-1;
            }
            if (flagRevers) {
                countLoop += 1;
            }
        }
        //
        if (pointB - pointA <= 1) {
            pieseRevers = new int[N];
        }
        for (int j = 0; j < countLoop / 2; j++) {
            int temp = pieseRevers [pointA + j];
            pieseRevers [pointA + j] = pieseRevers [pointB - j];
            pieseRevers [pointB - j] = temp;
        }
        //


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
            if (increasing [i] == pieseRevers [i]) {
                countPieseRevers += 1;
            }

        }
        // logic
        //if revers
        if (countRevers == N) {
            return true;
        }
        if (countPieseRevers == N) {
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
