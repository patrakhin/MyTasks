import java.util.*;
public class Level1 {
    public static int [] WordSearch (int len, String s, String subs)  {
        ArrayList<String> stringBroken = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        int countergap = -1; //счетчик
        int countpoz = 0; // указатель позиции последнего пробела в заданной величине разбивки
        int j = 0;
        boolean flag = true;
        int v = 0;

        for ( ; j < s.length(); j++) {
            if (countpoz == 0) {
                countpoz = j;
                countergap = j;
            }
            if (len < (s.length() - countergap)) {
                for (int a = 0 ; a < len; a ++) { //считаем пробелы в границах величины разбивки
                    countergap += 1;
                    if (s.charAt(j + a) == ' ') {
                        countpoz = countergap;
                        flag = false;
                    }
                }
            }
            else {
                v = j;
                for ( ; v < s.length(); v ++) { //считаем пробелы в границах величины разбивки
                    countergap += 1;
                    if (s.charAt( v ) == ' ') {
                        countpoz = countergap;
                        flag = false;
                    }
                }
            }
            if (!flag) {
                for ( ; j < countpoz; j++) {
                    buffer.append(s.charAt(j));
                }
                stringBroken.add(buffer.toString());
                buffer = new StringBuilder();
                j = countpoz - 1;
                countpoz = 0;
                flag = true;
            }
            else {
                if ((s.length() - j) < len) {
                    for (int n = 0; n < (s.length() - j); n++) {
                        buffer.append(s.charAt(j + n));
                    }
                    stringBroken.add(buffer.toString());
                    buffer = new StringBuilder();
                    j = s.length() -1;
                    break;
                }
                for (int n = 0; n < len; n++) {
                    buffer.append(s.charAt(j + n));
                }
                stringBroken.add(buffer.toString());
                buffer = new StringBuilder();
                j = j + len -1;
            }
        }

        int [] result = new int[stringBroken.size()];
        for (int k = 0; k < stringBroken.size(); k++) {
            if (stringBroken.get(k).contains(subs)) {
                result [k] = 1;
            }
            else {
                result [k] = 0;
            }

        }
            return result;
    }
}