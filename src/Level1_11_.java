import java.util.*;
public class Level1 {
    public static String BigMinus (String s1, String s2) {
        int point = 9;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int diff = 0;
        double s1a = 0;
        double s2a = 0;
        String buff ="";
        String zeroC = "123";
        String zeroD = "123";
        boolean flag = false;
        boolean banner = false;
        StringBuilder subString = new StringBuilder(); //for cut strings
        StringBuilder buildString1 = new StringBuilder(); //build string one
        StringBuilder buildString2 = new StringBuilder(); //build string two
        StringBuilder buildString1a = new StringBuilder();
        StringBuilder buildString2a = new StringBuilder();
        String buildString1b = "";
        String buildString2b = "";
        String bigMinus = "";
        //strings <= 9 symbols
        if (s1.length() <= point && s2.length() <= point) {
            a = Integer.parseInt(s1);
            b = Integer.parseInt(s2);
            if (a >= b) {
                c = a - b;
            }
            else {
                c = b - a;
            }
            bigMinus = String.valueOf(c);
            return bigMinus;
        }
        //once string >=9 symbols and twice <= 9 symbols
        if (s1.length() >= point && s2.length() <= point && !banner) {
            diff = s1.length() - s2.length();
            subString.append("0".repeat(diff));
            banner = true;
        }
        if (s1.length() <= point && s2.length() >= point && !banner) {
            buff = s1;
            s1 = s2;
            s2 = buff;
            diff = s1.length() - s2.length();
            subString.append("0".repeat(diff));
            banner = true;
        }

        //searching the biggest string
        if (s1.length() >= point && s2.length() >= point && !banner) {
            buildString1.append(".");
            buildString2.append(".");
            for (int j = (s1.length() - point); j < s1.length(); j++) {
                buildString1.append(s1.charAt(j)); // build right part s1 contains 9 symbols
            }
            for (int j = (s2.length() - point); j < s2.length(); j++) {
                buildString2.append(s2.charAt(j)); // build right part s1 contains 9 symbols
            }

            for (int j =0 ; j < (s1.length() - point); j++) {
                buildString1a.append(s1.charAt(j)); // build left part s1
            }
            for (int j =0 ; j < (s2.length() - point); j++) {
                buildString2a.append(s2.charAt(j)); // build left part s2
            }
            buildString1b = buildString1a.toString() + buildString1;
            buildString2b = buildString2a.toString() + buildString2;
            s1a = Double.parseDouble(buildString1b);
            s2a = Double.parseDouble(buildString2b);
            if (s1a >= s2a) {                          //  s1 >= s2
                diff = s1.length() - s2.length();
                subString.append("0".repeat(Math.max(0, diff)));
            }
            else {
                buff = s1;
                s1 = s2;
                s2 = buff;
                diff = s1.length() - s2.length();
                subString.append("0".repeat(Math.max(0, diff)));
            }
        }
        buildString1 = new StringBuilder(); // reset
        buildString2 = new StringBuilder(); // reset
        subString.append(s2); // it's a second string now
        for (int j = (s1.length() - point); j < s1.length(); j++) {
            buildString1.append(s1.charAt(j));
            buildString2.append(subString.charAt(j));
        }
        a = Integer.parseInt(buildString1.toString());
        b = Integer.parseInt(buildString2.toString());
        if (a >= b) {
            c = a - b;
        }
        else {
            a = a + 1000000000;
            c = a - b;
            flag = true;
        }
        if (c == 0) {
            zeroC = "000000000";
        }
        a = 0; b = 0;
        buildString1 = new StringBuilder();
        buildString2 = new StringBuilder();
        for (int j = 0; j < (s1.length() - point); j++) {
            buildString1.append(s1.charAt(j));
            buildString2.append(subString.charAt(j));
        }
        a = Integer.parseInt(buildString1.toString());
        b = Integer.parseInt(buildString2.toString());
        if (!flag) {
            d = a - b;
        }
        else {
            d = (a - 1) - b;
        }
        if (d == 0) {
            zeroD = "";
        }
        if (d == 0 && c != 0) {
            bigMinus = zeroD + Integer.toString(c);
        }
        if (d == 0 && c == 0) {
            bigMinus = "0";
        }
        if (d != 0 && c == 0) {
            bigMinus = String.valueOf(d) + zeroC;
        }
        if (d != 0 && c != 0) {
            bigMinus = String.valueOf(d) + String.valueOf(c);
        }
        return bigMinus;
    }
}
