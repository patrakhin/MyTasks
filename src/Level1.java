public class Sol1 {
    public static int squirrel (int N) {
        int orderNumber = 5;
        if (N > 0) {
            int factorial = N;
            for (int i = 1; i < N; i++) {
                factorial *= i;
            }
            char [] charFactorial = String.valueOf(factorial).toCharArray();
            String a = "";
            for (int x = 0; x < (charFactorial.length - (charFactorial.length - orderNumber)); x++) {
                a = String.valueOf(charFactorial[x]);
            }
            return Integer.parseInt(a);
        }
        return 1;

    }
    public static void main(String[] args) {
        int a = 8;
        System.out.println(squirrel(a));
    }
}
