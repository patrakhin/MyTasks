import java.util.*;
public class Level1 {
    public static boolean TankRush (int H1, int W1, String S1, int H2, int W2, String S2) {
        int count = 0;
        //need vars and flags
        int countStrings = 0;
        int buffSyncColumn = 0;
        boolean bannerSync = true;
        boolean bannerSync2 = true;
        int markBannerTrue = 0;
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
        count = 0; // now it's hit of column
        int i = 0;
        int j = 0;
        int n = 0;

        while (i < H2) {
            if (markBannerTrue == 1) {
                break;
            }
            while (j < W2) {
                if (markBannerTrue == 1) {
                    break;
                }
                while (n < H1) {
                    if (markBannerTrue == 1) {
                        break;
                    }
                    for (int m = 0; m < W1; m++) {
                        boolean breakEr = true;
                        if (!bannerSync) { //sync
                            count = 0;
                            m = buffSyncColumn;
                            buffSyncColumn = 0; //
                            bannerSync2 = false;
                        }
                        if (!bannerSync2 && tank [i] [0] != map [n] [m]) { //NO after sync
                            bannerSync = true;
                            bannerSync2 = true;
                            count = 0;
                            buffSyncColumn = 0;
                            countStrings = 0;
                            i -= 1;
                            n -= 1;
                            j = 0;
                            break;
                        }
                        if (tank [i] [j] != map [n] [m] && m + 1 != W1 - 1) { //NO after sync will set
                            bannerSync = true;
                            bannerSync2 = true;
                            count = 0;
                            buffSyncColumn = 0;
                            countStrings = 0;
                            continue; // go to next numb
                        }
                        if (tank[i][j] != map[n][m] && m + 1 == W1 - 1 && tank[i][j] != map[n][m + 1]) { //NO after sync will set
                            bannerSync = true;
                            bannerSync2 = true;
                            count = 0;
                            buffSyncColumn = 0;
                            countStrings = 0;
                            breakEr = false; //  and go to next string
                        }
                        if (n == H1 - 1 && i != H2 - 1 && countStrings != H2 && breakEr) {
                            markBannerTrue = 1;
                            breakEr = false;
                        }
                        if (!bannerSync2 && tank [i] [0] == map [n] [m]) { //YES after sync
                            bannerSync = true;
                            bannerSync2 = true;
                            count += 1;
                            buffSyncColumn = m;
                            j += 1;
                            continue;
                        }
                        if (bannerSync && tank [i] [j] == map [n] [m] && count == 0 && buffSyncColumn == 0) { //YES without sync
                            count += 1;
                            buffSyncColumn = m; //
                            j += 1;
                            continue; // ИДЕМ ЗА СЛДЕДУЮЩ ЧИСЛОМ
                        }
                        if (bannerSync && tank [i] [j] == map [n] [m] && count != 0 && count  + 1 != W2) { //YES without sync
                            j += 1;
                            count += 1;
                            continue;
                        }
                        if (bannerSync && tank [i] [j] == map [n] [m] && count != 0 && count  + 1 == W2) { //YES without sync
                            count += 1;
                        }
                        if (bannerSync && tank [i] [j] == map [n] [m] && count == W2 && i != H2 - 1 && breakEr) { //YES without sync
                            count = 0;
                            countStrings += 1;
                            i += 1;
                            j = 0;
                            bannerSync = false; // go to sync
                            breakEr = false;
                        }
                        if (bannerSync  && count == W2 && i == H2 - 1 && countStrings == H2 - 1 && breakEr) {
                            countStrings = H2; //HIT!!
                            markBannerTrue = 1;
                            bannerTrue = true;
                            breakEr = false;
                        }
                        if (bannerSync  && count == W2 && i == H2 - 1 && countStrings != H2 && breakEr) {
                            markBannerTrue = 1; // NO HIT !!!
                            breakEr = false;
                        }
                        if (!breakEr) {
                            break;
                        }
                    }
                    n++;
                }
                j++;
            }
            i++;
        }
        return bannerTrue;
    }
}
