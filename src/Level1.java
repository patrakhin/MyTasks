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
        boolean flagGrowUp = false;
        boolean flagGrowDelete;

        for (int i = 1; i < N + 1; i++) {
            if (i % 2 == 0) {
                flagGrowDelete = true;
            }
            else {
                flagGrowUp = true;
                flagGrowDelete = false;
            }
            // ears 1 3 5 ... only grow up
            for (int a = 0; a < H && flagGrowUp; a++) {
                for (int j = 0; j < W; j++) {
                    digitalTree [a] [j] += 1;
                }
            }
            flagGrowUp = false;
            // ears 2 4 6 ... grow up and delete
            for (int x = 0; x < 1 && flagGrowDelete; x++) {
                // grow up
                for (int a = 0; a < H; a++) {
                    for (int j = 0; j < W; j++) {
                        digitalTree [a] [j] += 1;
                    }
                }
                // delete Horizontal if branch 3 5 or 5< age
                for (int a = 0; a < H; a++) {
                    for (int j = 0; j < W; j++) {
                        int ageBranch = digitalTree [a] [j];
                        if (j == 0 && (ageBranch == 3 || ageBranch > 3)) {
                            digitalTree[a][j + 1] = 0;
                        }
                        if (j != 0 && j != (digitalTree[a].length - 1) && (ageBranch == 3 || ageBranch > 3)) {
                            digitalTree[a][j - 1] = 0;
                            digitalTree[a][j + 1] = 0;
                        }
                        if (j == (digitalTree[a].length - 1) && (ageBranch == 3 || ageBranch > 3)) {
                            digitalTree[a][j - 1] = 0;
                        }
                    }
                }
                // delete Vertical if branch 3 5 or 5< age
                for (int j = 0; j < W; j ++) {
                    for (int a = 0; a < H; a ++) {
                        int ageBranch = digitalTree [a] [j];
                        if (a == 0 && (ageBranch == 3 || ageBranch > 3)) {
                            digitalTree[a][j] = 0;
                            digitalTree[a + 1][j] = 0;
                        }
                        if (a != 0 && a != (digitalTree.length - 1) && (ageBranch == 3 || ageBranch > 3)) {
                            digitalTree[a][j] = 0;
                            digitalTree[a - 1][j] = 0;
                            digitalTree[a + 1][j] = 0;
                        }
                        if (a == (digitalTree.length - 1) && (ageBranch == 3 || ageBranch > 3)) {
                            digitalTree[a][j] = 0;
                            digitalTree[a - 1][j] = 0;
                        }
                    }
                }

            }
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
