import java.util.*;
public class Level1 {
    public static int ConquestCampaign(int N, int M, int L, int [] battalion) {
        int [] [] square = new int[N][M];
        for (int i = 0; i< (L*2); i++ ){ //Mark point's on map
            if (i %2 == 0){
                square [battalion[i]-1][battalion[i+1]-1]= 1;
            }
        }
        int countOfDays = 1;
        boolean flag = true;
        int [] [] squareEtalon = new int[N][M];
        for (int[] ints : squareEtalon) {
            Arrays.fill(ints, 1);
        }

        // in the late afternoon first  day is comparing squareEtalon and  square
        if (Arrays.deepEquals(squareEtalon,square)) {
            return countOfDays;
        }
        while (flag) {
            int[][] squareOne = new int[N][M];
            for (int y = 0; y < squareOne.length; y++) {
                System.arraycopy(square[y], 0, squareOne[y], 0, squareOne[0].length);
            }
            for (int y = 0; y < squareOne.length; y++) {
                for (int x = 0; x < squareOne[0].length; x++) {
                    if (x == 0 && squareOne[y][x] == 1 && squareOne[y][x + 1] != 1 ) {
                        squareOne[y][x + 1] = 1;
                        break;
                    }
                    if (x > 0 && x != (squareOne[0].length - 1) && squareOne[y][x] == 1 && (squareOne[y][x + 1] == 1)) {
                        continue;
                    }
                    if (x > 0 && x != (squareOne[0].length - 1) && squareOne[y][x] == 1) {
                        squareOne[y][x + 1] = 1;
                        squareOne[y][x - 1] = 1;
                        break;
                    }
                    if (x > 0 && x == (squareOne[0].length - 1) && squareOne[y][x] == 1 && (squareOne[y][x - 1] != 1)) {
                        squareOne[y][x - 1] = 1;
                        break;
                    }
                }
            }
            int[][] squareTwo = new int[N][M];
            for (int y = 0; y < squareOne.length; y++) {
                System.arraycopy(square[y], 0, squareTwo[y], 0, squareOne[0].length);
            }
            for (int x = 0; x < squareTwo[0].length; x++) {
                for (int y = 0; y < squareTwo.length; y++) {
                    if (y == 0 && squareTwo[y][x] == 1 && squareTwo[y + 1][x] != 1) {
                        squareTwo[y + 1][x] = 1;
                        break;
                    }
                    if (y == 0 && squareTwo[y][x] == 1 && squareTwo[y + 1][x] == 1) {
                        continue;
                    }

                    if (y > 0 && y != squareTwo.length - 1 && squareTwo[y][x] == 1 ) {
                        squareTwo[y + 1][x] = 1;
                        squareTwo[y - 1][x] = 1;
                        break;
                    }
                    if (y > 0 && y == squareTwo.length - 1 && squareTwo[y][x] == 1 && squareTwo[y - 1][x] != 1) {
                        squareTwo[y - 1][x] = 1;
                        break;
                    }
                }
            };
            int[][] squareAllMatrix = new int[N][M];
            for (int y = 0; y < squareAllMatrix.length; y++) {
                System.arraycopy(squareOne[y], 0, squareAllMatrix[y], 0, squareAllMatrix[0].length);
            }
            for (int y = 0; y < squareAllMatrix.length; y++) {
                for (int x = 0; x < squareAllMatrix[0].length; x++) {
                    squareAllMatrix[y][x] = squareOne[y][x];
                    if (squareAllMatrix[y][x] != 1) {
                        squareAllMatrix[y][x] = squareTwo[y][x];
                    }
                }
            }
            for (int y = 0; y < square.length; y++) {
                System.arraycopy(squareAllMatrix[y], 0, square[y], 0, square[0].length);
            }
            countOfDays = countOfDays + 1;
            if (Arrays.deepEquals(squareEtalon,squareAllMatrix)) {
                flag = false;
            }
        }
        return countOfDays;
    }
}
