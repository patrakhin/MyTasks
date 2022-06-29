import java.util.*;
public class Level1 {
    public static String TheRabbitsFoot (String s, boolean encode) {
        String s2 = s;
        if (encode) {
            s2 = s.replaceAll("\\s","");
        }
        int countgap = 0;
        int count = 0;

        for (int i = 0; i < s2.length(); i++) {
            if (encode) {
                break;
            }
            if (s2.charAt(i) == ' ') {
                countgap += 1;
            }
        }
        StringBuilder aftercode = new StringBuilder();
        double numderofsqrt = Math.sqrt(s2.length());
        int string = (int) numderofsqrt;
        int column = (int) ((numderofsqrt - string) * 10);

        if (column == 0) {
            column = countgap + 3;
        }

        char [] [] redbag;
        while ((string * column) < s2.length()) {
            string += 1;
        }
        redbag = new char[string][column];

        for (int i = 0; i < string; i++){
            if (!encode) {
                break;
            }
            for (int j = 0; j < column; j++) {
                redbag [i] [j] = s2.charAt(count);
                if (count == s2.length() -1) {
                    break;
                }
                count += 1;
            }
        }

        for (int j = 0; j < column; j++){
            if (!encode) {
                break;
            }
            for (int i = 0; i < string; i++) {
                aftercode.append(redbag[i][j]);
            }
            aftercode.append(" ");
        }

        StringBuilder finish = new StringBuilder();
        count = 0;
        int countStrings = 0;
        int countColum = 1;

        for (int j = 0 ; j < s2.length() ; j++ ) {
            if (s2.charAt(j) == ' ' || encode) {
                break;
            }
            countStrings += 1;
        }

        for (int j = 0 ; j < s2.length() ; j++ ) {
            if (encode) {
                break;
            }
            if (s2.charAt(j) == ' ') {
                countColum += 1;
            }
        }

        if (!encode) {
            redbag = new char[countStrings][countColum];
        }
        for (int j = 0 ; j < countColum ; j++ ) {
            if (encode) {
                break;
            }
            for (int i = 0; i < countStrings; i++) {
                redbag  [i][j] = s2.charAt(count);
                if (redbag [0][j] == ' ') {
                    count +=1;
                    redbag  [0][j] = s2.charAt(count);
                }
                if (count == s2.length()-1 ) {
                    break;
                }
                count +=1;
            }
        }

        for (int i = 0 ; i < countStrings ; i++ ) {
            if (encode) {
                break;
            }
            for (int j = 0; j < countColum; j++) {
                finish.append(redbag[i][j]);
            }
        }
        if (!encode) {
            return finish.toString().trim();
        }
        aftercode = new StringBuilder(aftercode.toString().replaceAll("\\p{C}", "").trim());
        return aftercode.toString();
    }
}
