import java.util.*;
public class Level1 {
    public static int [] WordSearch (int len, String s, String subs)  {
        ArrayList<String> stringBroken = new ArrayList<>();
        ArrayList<String> stringBuilt = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        StringBuilder bufferBuilt = new StringBuilder();
        StringBuilder subBuffer = new StringBuilder();
        String finish = "";
        String gap = " ";
        int count = 0;

        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(r) == ' ') {
                count += 1;
                continue;
            }
            buffer = new StringBuilder(gap);
            break;
        }

        for (int i = count; i < s.length(); i++) {

            if (s.charAt(i) != ' ' && i+1 < s.length()) {
                buffer.append(String.valueOf(s.charAt(i)));
                continue;
            }
            if (s.charAt(i) == ' ') {
                //buffer += String.valueOf(start.charAt(i)); //без этого выбирает только слова без пробелов
                stringBroken.add(String.valueOf(buffer));
                buffer = new StringBuilder("");
                continue;
            }
            if (s.charAt(i) != ' ' && i == s.length()-1) {
                buffer.append(String.valueOf(s.charAt(i)));
                stringBroken.add(String.valueOf(buffer));
                buffer = new StringBuilder("");
            }

        }


        for (int i = 0; i < stringBroken.size(); i ++) {
            if ( !stringBuilt.isEmpty()) {
                for (int f = 0; f < stringBuilt.size(); f++) {
                    if (!stringBuilt.get(f).contains(gap) && bufferBuilt.length() == 0) {
                        bufferBuilt = new StringBuilder(bufferBuilt + gap);
                    }
                }
            }
            if ((stringBroken.get(i)).length() <= len) { //если строка меньше или равна ширине
                bufferBuilt = new StringBuilder(bufferBuilt + stringBroken.get(i));
                if (bufferBuilt.length() + gap.length() <= len) { //1*
                    bufferBuilt = new StringBuilder(bufferBuilt + gap);
                    if ( (i + 1) < stringBroken.size() && bufferBuilt.length() + (stringBroken.get(i+1)).length() <= len) {
                        continue; //1*
                    }
                }
                if (bufferBuilt.length() + gap.length() <= len) { //2*
                    bufferBuilt = new StringBuilder(bufferBuilt + gap);
                    if ( (i + 1) < stringBroken.size() && bufferBuilt.length() + (stringBroken.get(i+1)).length() >= len) {
                        stringBuilt.add(String.valueOf(bufferBuilt));
                        bufferBuilt = new StringBuilder("");
                        continue; //2*
                    }
                }
                if (bufferBuilt.length() + gap.length() >= len) { //3*
                    stringBuilt.add(String.valueOf(bufferBuilt));
                    bufferBuilt = new StringBuilder("");
                    continue; //3*
                }
                if (i == stringBroken.size() - 1) { //4*
                    stringBuilt.add(String.valueOf(bufferBuilt));
                    bufferBuilt = new StringBuilder(""); //4*
                    break;
                }

            }



            if ((stringBroken.get(i)).length() >= len) { // если строка больше или равна ширине

                bufferBuilt = new StringBuilder(bufferBuilt + stringBroken.get(i));
                for (int j = 0; j < len; j++) {
                    subBuffer.append(bufferBuilt.charAt(j)); //забираем символы в саббуфер на величину разбивки
                }
                stringBuilt.add(String.valueOf(subBuffer));
                subBuffer = new StringBuilder("");
                for (int k = len ; k < bufferBuilt.length(); k++) {
                    subBuffer.append(bufferBuilt.charAt(k)); //забираем символы в буфер на величину разбивки
                    if (subBuffer.length() == len && k < (bufferBuilt.length()) - 1) {
                        stringBuilt.add(String.valueOf(subBuffer));
                        subBuffer = new StringBuilder("");
                    }
                }
                bufferBuilt = subBuffer;
                subBuffer = new StringBuilder("");
            }

        }
//poiskovik

        int b = 0; //счетчик символов s2
        int [] result = new int[stringBroken.size()];

        for (int g = 0; g < stringBuilt.size(); g++) {
            if (stringBuilt.get(g).length() >= subs.length()) {
                for (int m = 0; m < stringBuilt.get(g).length(); m++) {
                    if (b == subs.length()) {
                        result[g] += 1;
                        b = 0;
                        break;
                    }
                    for (int i = 0; i < subs.length(); i++) {
                        //Если не совпали, сбрасываем b и берем новый i
                        if (stringBuilt.get(g).charAt(m) != subs.charAt(b)) {
                            b = 0;
                            break;
                        }
                        b += 1;
                        // Если b становиться равным длине строки s2, значит строка совпала полностью.
                        // Завершаем функцию
                        break;
                    }
                }
            }
        }
        return result;
    }

}
