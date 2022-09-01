import java.util.*;
public class Level1 {
    public static String [] TreeOfLife (int H, int W, int N, String [] tree) {
        int [] [] digitalTree = new int[H][W];
        //recoding
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                char [] recoding = tree [i].toCharArray();
                if (recoding [j] == '.') {
                    digitalTree [i] [j] = 0;
                }
                if (recoding [j] == '+') {
                    digitalTree [i] [j] = 1;
                }
            }
        }
        //Tree
        boolean flagGrowDelete = false;
        int countAges = 0;
        int ageDelete = 3;
        for (int i = 1; i < N + 1; i++) {
            countAges += 1;
            if (countAges % 2 == 0) {
                flagGrowDelete = true;
            }
            // ears 1 3 5 ... only grow up
            for (int a = 0; a < H ; a++) {
                for (int j = 0; j < W; j++) {
                    digitalTree [a] [j] += 1;
                }
            }
            // ears 2 4 6 ... grow up and delete
            for (int x = 0; x < 1 && flagGrowDelete; x++) {
                // delete Horizontal
                for (int a = 0; a < H; a++) {
                    for (int j = 0; j < W; j++) {
                        if ((j == W - 1) && (digitalTree[a][j] < ageDelete) && (digitalTree[a][j -1] >= ageDelete)) {
                            digitalTree[a][j] = 0;
                        }
                        if ((j == W - 1) && (digitalTree[a][j] >= ageDelete) && (digitalTree[a][j -1] < ageDelete)) {
                            digitalTree[a][j - 1] = 0;
                        }
                        if ((j > 0) && (j != W - 1) && (digitalTree[a][j] >= ageDelete) && (digitalTree[a][j -1] < ageDelete)) {
                            digitalTree[a][j - 1] = 0;
                        }
                        if ((j > 0) && (j != W - 1) && (digitalTree[a][j] < ageDelete) && (digitalTree[a][j -1] >= ageDelete) && (digitalTree[a][j +  1] < ageDelete)) {
                            digitalTree[a][j] = 0;
                        }
                    }
                }
                // delete Vertical
                for (int j = 0; j < W; j ++) {
                    for (int a = 0; a < H; a ++) {
                        if ((a == H - 1) && (digitalTree[a][j] < ageDelete) && (digitalTree[a - 1][j] >= ageDelete)) {
                            digitalTree[a][j] = 0;
                        }
                        if ((a == H - 1) && (digitalTree[a][j] >= ageDelete) && (digitalTree[a - 1][j] < ageDelete)) {
                            digitalTree[a - 1][j] = 0;
                        }
                        if ((a > 0) && (a != H - 1) && (digitalTree[a][j] >= ageDelete) && (digitalTree[a - 1][j] < ageDelete)) {
                            digitalTree[a - 1][j] = 0;
                        }
                        if ((a > 0) && (a != H - 1) && (digitalTree[a][j] < ageDelete) && (digitalTree[a - 1][j] >= ageDelete) && (digitalTree[a + 1][j] < ageDelete)) {
                            digitalTree[a][j] = 0;
                        }
                    }
                }
                // delete only old branch
                for (int j = 0; j < W; j ++) {
                    for (int a = 0; a < H; a ++) {
                        if ((digitalTree[a][j] >= ageDelete)) {
                            digitalTree[a][j] = 0;
                        }
                    }
                }
            }
            flagGrowDelete = false;
        }
        //coding
        String[] exit = new String[tree.length];
        Arrays.fill(exit, "");
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (digitalTree[i][j] == 0) {
                    exit [i] += ".";
                }
                if (digitalTree[i][j]  > 0) {
                    exit [i] += "+";
                }

            }
        }
        return exit;
    }
}
