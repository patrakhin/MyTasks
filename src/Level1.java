import java.util.*;
public class Level1 {

    public static void MatrixTurn(String Matrix[], int M, int N, int T) {
        int [] [] startMatrix = new int [M] [N];
        String [] endMatrix = new String[M];
        int memory1 = 0;
        int memory2 = 0;
        //recoding to startMatrix
        for (int k =0; k < M; k ++) {
            for (int b = 0; b < N; b++) {
                char [] recodingChar = Matrix[k].toCharArray();
                startMatrix [k] [b] += Integer.parseInt(String.valueOf(recodingChar [b]));
            }
        }
        //search count sub matrix
        int countSubMatrix = 0;
        if (M > N) {
            countSubMatrix = (N/2);
        }
        if (M < N) {
            countSubMatrix = (M/2);
        }
        if (M == N) {
            countSubMatrix = (M/2);
        }
        // Matrix spinning if M and N > 2
        int countShift = 0;
        for (int t = 0; t < T ; t ++) {
            for(; countShift < countSubMatrix; countShift++) {
                memory1 = startMatrix[countShift][countShift];
                memory2 = startMatrix[(M - 1) - countShift][(N - 1) - countShift];
                //left vertical
                for (int i = countShift; i <= (startMatrix.length - 2) - countShift; i++) {
                    startMatrix[i][countShift] = startMatrix[i + 1] [countShift];
                }
                // right vertical
                for (int i = (startMatrix.length - 1) - countShift; i >= (1) + countShift; i --) {
                    startMatrix[i][(startMatrix[0].length - 1) - countShift] = startMatrix [i -1] [(startMatrix[0].length - 1) - countShift];
                }
                // horizon line up
                for (int j = (startMatrix[0].length - 1) - countShift; j >= 1 + countShift; j--) {
                    startMatrix[countShift][j] = startMatrix[countShift][j - 1];
                }
                // cell = memory
                startMatrix[countShift][1 + countShift] = memory1;
                // horizon line down
                for (int j = countShift; j < (startMatrix[0].length - 2) - countShift; j++) {
                    startMatrix[(startMatrix.length - 1) - countShift][j] = startMatrix[(startMatrix.length - 1) - countShift][j + 1];
                }
                // cell = memory
                startMatrix[(startMatrix.length - 1) - countShift][(startMatrix[0].length - 2) - countShift] = memory2;
            }
        }
        //decoding Matrix to string array
        Arrays.fill(endMatrix, "");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j ++ ) {
                endMatrix [i] += String.valueOf(startMatrix[i] [j]);
            }
        }
        for (int i = 0; i < M; i++) {
            Matrix [i] = endMatrix[i];
        }
    }
}
