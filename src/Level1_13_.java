import java.util.*;
public class Level1 {
    public static int [] UFO(int N, int [] data, boolean octal) {
        int [] ufo = new int[N];
        int buff = 0;
        int trans = 0;
        int stepen = 0;
        int bufTrans = 0;
        int osnovanie = 0;
        int countRich = 1;
        String strich = ""; //
        if (octal) {
            osnovanie = 8; //
        }
        if (!octal) {
            osnovanie = 16; //
        }
            for (int j = 0; j < N; j++) {
                strich = Integer.toString(data[j]);
                for (int i = 0; i < strich.length(); i++) {
                    buff = Integer.parseInt(String.valueOf(strich.charAt(i)));
                    stepen = (int) Math.pow(osnovanie, (strich.length() - countRich));
                    trans = (buff * stepen);
                    bufTrans += trans;
                    countRich += 1;
                }
                ufo [j] = bufTrans;
                bufTrans = 0;
                countRich = 1;
            }
        return ufo;
    }
}
