import java.util.*;
public class Level1 {
    int [] WordSearch (int len, String s, String subs)   {
        ArrayList<String> stringBroken = new ArrayList<>();
        ArrayList<String> stringBuilt = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        StringBuilder bufferBuilt = new StringBuilder();
        StringBuilder subBuffer = new StringBuilder();
        buffer.append(String.valueOf(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '*' && i+1 < s.length()) {
                buffer.append(String.valueOf(s.charAt(i)));
                continue;
            }
            if (s.charAt(i) == '*') {
                buffer.append(String.valueOf(s.charAt(i))); //без этого выбирает только слова без пробелов
                stringBroken.add(buffer.toString());
                buffer = new StringBuilder();
            }
            if (s.charAt(i) != '*' && i == s.length()-1) {
                buffer.append(String.valueOf(s.charAt(i)));
                stringBroken.add(buffer.toString());
                buffer = new StringBuilder();
            }
        }
        for (int i = 0; i < stringBroken.size(); i ++) {
            if ((stringBroken.get(i)).length() <= len) { //если первая строка меньше ширины
                bufferBuilt.append(stringBroken.get(i));
                if (i < stringBroken.size() - 1 && (stringBroken.get(i+1)).length() <= len && (bufferBuilt.length() + (stringBroken.get(i + 1)).length()) <= len) { //1
                    bufferBuilt.append(stringBroken.get(i + 1));
                    i = (i + 1);
                    continue;
                }
                if (i < stringBroken.size() - 1 && (stringBroken.get(i+1)).length() >= len && (bufferBuilt.length() + (stringBroken.get(i + 1)).length()) >= len) { //2
                    stringBuilt.add(bufferBuilt.toString());
                    bufferBuilt = new StringBuilder();
                    continue;
                }
                if (i < stringBroken.size() - 1 && (stringBroken.get(i+1)).length() <= len && (bufferBuilt.length() + (stringBroken.get(i + 1)).length()) >= len) { //3
                    stringBuilt.add(bufferBuilt.toString());
                    bufferBuilt = new StringBuilder();
                    continue;
                }
                if (i+1 == stringBroken.size() - 1 && (bufferBuilt.length() + (stringBroken.get(i + 1)).length()) >= len) { //4
                    bufferBuilt.append(stringBroken.get(i + 1));
                    stringBuilt.add(bufferBuilt.toString());
                    bufferBuilt = new StringBuilder();
                    continue;
                }
                if ((i+1) == stringBroken.size() - 1 && (bufferBuilt.length() + (stringBroken.get(i + 1)).length()) <= len) { //5
                    bufferBuilt.append(stringBroken.get(i + 1));
                    stringBuilt.add(bufferBuilt.toString());
                    bufferBuilt = new StringBuilder();
                }
                if (i == stringBroken.size() - 1) { //6
                    stringBuilt.add(bufferBuilt.toString());
                    bufferBuilt = new StringBuilder();
                }
            }
            if ((stringBroken.get(i)).length() >= len) {
                bufferBuilt.append(stringBroken.get(i));
                for (int j = 0; j < len; j++) {
                    subBuffer.append(bufferBuilt.charAt(j)); //забираем символы в буфер на величину разбивки
                }
                stringBuilt.add(subBuffer.toString());
                subBuffer = new StringBuilder();
                for (int k = len; k < bufferBuilt.length(); k++) {
                    subBuffer.append(bufferBuilt.charAt(k)); //забираем символы в буфер на величину разбивки
                }
                bufferBuilt = new StringBuilder(subBuffer.toString());
                subBuffer = new StringBuilder();
            }


        }

        int [] result = new int[stringBuilt.size()];
        for (int y = 0; y < stringBuilt.size(); y++) {
            if ((stringBuilt.get(y)).contains(subs)) {
                result[y] = 1;
            }
            if (!(stringBuilt.get(y)).contains(subs)) {
                result [y] = 0;
            }
        }
        return result;
    }
}
