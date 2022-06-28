public class Level1_8_ {
    public static int SumOfThe (int N, int [] data) {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                for (int j = (i + 1); j < N; j++) {
                    sum1 += data[j];
                }
                if (data[i] == sum1) {
                    sum4 = data[i];
                }
                sum1 = 0;
            }
            if (i > 0 && i != N - 1) {
                for (int k = i + 1; k < N; k++) {
                    sum2 += data[k];
                }
                for (int f = 0; f < i; f++) {
                    sum3 += data[f];
                }
                if (data[i] == (sum2 + sum3)) {
                    return data[i];
                }
                sum2 = 0;
                sum3 = 0;
            }
            if (i > 0 && i == N - 1) {
                for (int k = 0; k < N - 1; k++) {
                    sum2 += data[k];
                }
                if (data[i] == sum2) {
                    return data[i];
                }
                sum2 = 0;
            }

        }
        return sum4;
    }

}
