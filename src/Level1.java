import java.util.*;
public class Level1 {
    public static int [] MadMax(int N, int [] Tele) {
        //arrange the array in ascending order
        int buffer;
        for (int j = 0; j < N; j ++) {
            int min = j;
            for (int i  = j + 1; i < N; i ++) {
                if (Tele[min] > Tele[i]) {
                    min = i;
                }
            }
            buffer = Tele [j];
            Tele [j] = Tele [min];
            Tele [min] = buffer;
        }
        //middle array
        int mid = 0 + ((Tele.length-1) - 0) / 2;
        // order the array descending from the middle
        int buffermid;
        for (int j = mid; j < N; j ++) {
            int max = j;
            for (int i  = j + 1; i < N; i ++) {
                if (Tele[max] < Tele[i]) {
                    max = i;
                }
            }
            buffermid = Tele [j];
            Tele [j] = Tele [max];
            Tele [max] = buffermid;
        }
        return Tele;
    }
}
