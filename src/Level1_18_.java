import java.util.*;
public class Level1 {
    public static boolean MisterRobot(int N, int [] data) {
        boolean flagTime = true;
        boolean found = false;
        //searching N in data
        for(int x : data){
            if(x == N){
                found = true;
                break;
            }
        }
        if (!found || N <= 4) {
            return false;
        }
        // copy of data to standard
        int [] standard = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            standard [i] =  data [i];
        }

        // copy of standard to increasing
        int []  increasing = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            increasing [i] = standard [i];
        }
        int buff = 0;
        // sort standard increase
        for (int i = 0; i < standard.length; i ++) {
            for (int j = i + 1; j < standard.length; j ++) {
                if (standard [i] > standard [j]) {
                    buff = standard [i];
                    standard [i] = standard [j];
                    standard [j] = buff;
                }
            }
        }
        // compare N with MAX
        if (N != standard [standard.length - 1]) {
            return false;
        }
        // sorting increasing
        buff = 0;
        int countHit =0;

        long startTime = System.currentTimeMillis();
        for (int k = 0; k < increasing.length; k++) {
            for (int i = 0; i < increasing.length; i++) {
                for (int j = i + 1; j < (j + 1) && (j+1) < increasing.length; j++) {
                    if (increasing[i] > increasing[j]) {
                        buff = increasing[i];
                        increasing[i] = increasing[j];
                        increasing[j] = increasing[j + 1];
                        increasing[j + 1] = buff;
                    }
                    if (increasing[i] < increasing[j]) {
                        break;
                    }
                }
            }
            for (int a = 0; a < increasing.length; a++) {
                if (increasing [a] == standard [a]) {
                    countHit += 1;
                }
            }
            if (countHit == increasing.length) {
                break;
            }
            countHit = 0;
            long endTime = System.currentTimeMillis();
            if (endTime-startTime > 1000) {
                flagTime = false;
                break;
            }
            if (k == increasing.length - 1 && countHit != increasing.length) {
                found = false;
                return false;
            }
        }
        return flagTime;
    }

}
