import java.util.*;
public class Level1 {
    public static int [] WordSearch (int len, String s, String subs)  {
            ArrayList<String> stringBroken = new ArrayList<>();
            ArrayList<String> stringBuilt = new ArrayList<>();
            StringBuilder buffer = new StringBuilder();
            StringBuilder bufferBuilt = new StringBuilder();
            StringBuilder subBuffer = new StringBuilder();
            String gap = " ";
            int count = 0;

            for (int i = count; i < s.length(); i++) {
                if (s.charAt(i) != ' ' && i+1 < s.length()) {
                    buffer.append(String.valueOf(s.charAt(i)));
                    continue;
                }
                if (s.charAt(i) == ' ') {
                    stringBroken.add(buffer.toString());
                    buffer = new StringBuilder();
                    continue;
                }
                if (s.charAt(i) != ' ' && i == s.length()-1) {
                    buffer.append(String.valueOf(s.charAt(i)));
                    stringBroken.add(buffer.toString());
                    buffer = new StringBuilder();
                }
            }

            for (int i = 0; i < stringBroken.size(); i ++) {
                if ( !stringBuilt.isEmpty()) {
                    for (int f = 0; f < stringBuilt.size(); f++) {
                        if (!stringBuilt.get(f).contains(gap) && bufferBuilt.length() == 0) {
                            bufferBuilt = new StringBuilder();
                            bufferBuilt.append(gap);
                        }
                    }
                }
                if ((stringBroken.get(i)).length() <= len) { //если строка меньше или равна ширине
                    bufferBuilt.append(stringBroken.get(i));
                    if (bufferBuilt.length() + gap.length() <= len && i != stringBroken.size() - 1) { //1*
                        bufferBuilt.append(gap);
                        if ( (i + 1) < stringBroken.size() && bufferBuilt.length() + (stringBroken.get(i+1)).length() <= len) {
                            continue; //1*
                        }
                    }
                    if (bufferBuilt.length() + gap.length() <= len) { //2*
                        if ( (i + 1) < stringBroken.size() && bufferBuilt.length() + (stringBroken.get(i+1)).length() >= len) {
                            stringBuilt.add(bufferBuilt.toString());
                            bufferBuilt = new StringBuilder();
                            continue; //2*
                        }
                    }
                    if (bufferBuilt.length() + gap.length() >= len) { //3*
                        stringBuilt.add(bufferBuilt.toString());
                        bufferBuilt = new StringBuilder();
                        continue; //3*
                    }
                    if (i == stringBroken.size() - 1) { //4*
                        stringBuilt.add(bufferBuilt.toString());
                        bufferBuilt = new StringBuilder(); //4*
                        break;
                    }
                }

                if ((stringBroken.get(i)).length() >= len) { // если строка больше или равна ширине
                    bufferBuilt.append(stringBroken.get(i));
                    for (int j = 0; j < len; j++) {
                        subBuffer.append(bufferBuilt.charAt(j)); //забираем символы в саббуфер на величину разбивки
                    }
                    stringBuilt.add(subBuffer.toString());
                    subBuffer = new StringBuilder();
                    for (int k = len ; k < bufferBuilt.length(); k++) {
                        subBuffer.append(bufferBuilt.charAt(k)); //забираем символы в буфер на величину разбивки
                        if (subBuffer.length() == len && k < (bufferBuilt.length()) - 1) {
                            stringBuilt.add(subBuffer.toString());
                            subBuffer = new StringBuilder();
                        }
                    }
                    bufferBuilt = new StringBuilder(subBuffer.toString());
                    subBuffer = new StringBuilder();
                }
            }

            //poiskovik
            count = 0;
            int b = 0; //счетчик символов s2
            int [] result = new int[stringBuilt.size()];

            for (int g = 0; g < stringBuilt.size(); g++) {
                if (stringBuilt.get(g).length() >= subs.length()) {
                    for (int m = 0; m < stringBuilt.get(g).length(); m++) {
                        for (int i = 0; i < subs.length(); i++) {
                            if (stringBuilt.get(g).charAt(m) != subs.charAt(b)) {
                                b = 0;
                                break;
                            }
                            b += 1;
                            if (b == subs.length()) {
                                if (m != stringBuilt.get(g).length() - 1 && stringBuilt.get(g).charAt(m) != ' ') {
                                    b = 0;
                                    break;
                                }
                                result[g] += 1;
                                b = 0;
                                break;
                            }
                            break;
                        }
                    }
                }

            }
            return result;
    }
}