import java.util.*;
public class Level1 {
    public static boolean TankRush (int H1, int W1, String S1, int H2, int W2, String S2) {

        //need vars and flags
        int count = 0;

        int countAll = 0; //
        boolean columnFlag = true; //
        boolean stringFlag = true; //
        boolean bannerTrue = false;
        //check size
        if (H2 > H1 || W2 > W1) {
            return false;
        }
        if (H2 == 1 || W2 == 1) {
            return false;
        }
        int [] [] map = new int[H1][W1];
        int [] [] tank = new int[H2][W2];
        //building map
        for (int i = 0; i < H1; i++) {
            for (int j = 0; j < W1; j++) {
                if (S1.charAt(count) == ' ') {
                    count += 1;
                }
                String d = String.valueOf(S1.charAt(count));
                map[i][j] = Integer.parseInt(d);
                count += 1;
            }
        }
        count = 0; //
        //building tank
        for (int i = 0; i < H2; i++) {
            for (int j = 0; j < W2; j++) {
                if (S2.charAt(count) == ' ') {
                    count += 1;
                }
                String v = String.valueOf(S2.charAt(count));
                tank[i][j] = Integer.parseInt(v);
                count += 1;
            }
        }
        // searching hit
        for (int n = 0; n < H1; n ++) {
            for (int m = 0; m < W1; m++) {
                for (int i = 0; i < H2; i++) {
                    for (int j = 0; j < W2; j++) {
                        if (m + j > W1 - 1 || m + (W2 - 1) > W1 - 1) {
                            countAll = 0;
                            columnFlag = false;
                        }
                        if (n + i > H1 - 1 || n + (H2 - 1) > H1 - 1) {
                            countAll = 0;
                            stringFlag = false;
                        }
                        if (columnFlag && stringFlag && tank [i] [j] == map [n+i] [m+j]) {
                            countAll += 1;
                        }

                        if (countAll == (W2 * H2)) {
                            return true;
                        }

                        if (columnFlag && stringFlag && countAll != 0 && countAll < (W2 * W1) && tank [i] [j] == map [n+i] [m+j]) {
                            continue;
                        }

                        if (columnFlag && stringFlag && tank [i] [j] == tank [H2 - 1] [W2 - 1]  && tank [i] [j] != map [n+i] [m+j]) {
                            countAll = 0;
                            continue;
                        }
                        if (columnFlag && stringFlag && tank [i] [j] != map [n+i] [m+j]) {
                            countAll = 0;
                            continue;
                        }
                        if (!columnFlag && stringFlag) {
                            columnFlag = true;
                            m = W1;
                            i = H2;
                            j = W2;
                            break;
                        }
                        if (columnFlag && !stringFlag) {
                            return false;
                        }
                        if (!columnFlag && !stringFlag) {
                            return false;
                        }
                    }
                }
            }
        }
        return bannerTrue;
    }
}
