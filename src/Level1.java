import java.util.*;
public class Level1 {
    public static int [] WordSearch (int len, String s, String subs)  {
        ArrayList<String> stringBroken = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        int counterpoz = 0; //указатель текущей позиции
        int countgap = 0; // указатель позиции последнего пробела в заданной величине разбивки
        boolean flag = true;

        while (counterpoz < s.length()) {
            if (s.charAt(counterpoz) == ' ') { //если первый символ это пробел - сдвигааем указатель позиций на 1
                counterpoz += 1;
            }
            //считаем позицию последнего пробела в границах разбивки
            if (len <= (s.length() - counterpoz)) { //если величина разбивки меньше разницы длины строки и текущей позиции
                for (int i = 0; i < len; i++) { //тогда идем на эту величину разбивки
                    if (s.charAt(counterpoz + i) == ' ') {
                        countgap = counterpoz + i; //посчитали позицию последнего пробела
                        flag = false;
                    }
                }
            }
            if (len >= (s.length() - counterpoz)) { //если величина разбивки  больше разницы дл строки и текущ позиции
                for (int i = 0; i < (s.length() - counterpoz); i++) { //тогда идем на величину этой разницы
                    if (s.charAt(counterpoz + i) == ' ') {
                        countgap = counterpoz + i; //посчитали позицию последнего пробела
                        flag = false;
                    }
                }
            }//если пробел есть  флаг в фолс
            if (!flag) {
                for (int i = 0; i < (countgap - counterpoz); i++) { //тогда идем от указателя позиций до позиции последнего пробела
                    buffer.append(s.charAt(counterpoz + i)); //ложим в буфер символы до последнего пробела
                }
                counterpoz = countgap; // согласно указателя пробела  - выставляем указатель позицй
                String bufferAfterTTrim = buffer.toString().trim(); //тримим буфер
                if (bufferAfterTTrim.length() > 0) {
                    stringBroken.add(bufferAfterTTrim); //трим строку передаем в список
                }
                buffer = new StringBuilder(); // обнуляем буфер
            }
            if (flag) {    //если пробела нет  флаг в тру
                //если величина разбивки меньше разницы длины строки и текущей позиции
                if (len <= (s.length() - counterpoz)) {
                    for (int i = 0; i < len; i++) { //тогда идем до величины разбивки
                        buffer.append(s.charAt(counterpoz + i)); //ложим в буфер символы до конца строки
                    }
                    counterpoz = counterpoz + len; // согласно счетчика  - выставляем указатель позицй
                    countgap = counterpoz; // счетчик пробелов выровняли с указателем позиций
                    String bufferAfterTrim = buffer.toString().trim(); //тримим буфер
                    if (bufferAfterTrim.length() > 0) {
                        stringBroken.add(bufferAfterTrim); //трим строку передаем в список
                    }
                    buffer = new StringBuilder(); // обнуляем буфер
                }
                //если величина разбивки больше разницы длины строки и текущей позиции
                if (len >= (s.length() - counterpoz)) {
                    for (int i = 0; i < (s.length() - counterpoz); i++) { //тогда идем до конца строки
                        buffer.append(s.charAt(counterpoz + i)); //ложим в буфер символы до концароки
                    }
                    counterpoz = counterpoz + (s.length() - counterpoz); // согласно счетчика  - выставляем указатель позицй
                    countgap = counterpoz; // счетчик пробелов выровняли с указателем позиций
                    String bufferAfterTrim = buffer.toString().trim(); //тримим буфер
                    if (bufferAfterTrim.length() > 0) {
                        stringBroken.add(bufferAfterTrim); //трим строку передаем в список
                    }
                    buffer = new StringBuilder(); // обнуляем буфер
                }
            }
            flag = true;
        }

        int [] result = new int[stringBroken.size()];
        subs = subs.trim();
        for ( int i = 0; i < stringBroken.size(); i++) {
            String[] splitString = stringBroken.get(i).split(" ");
            for (String value : splitString) {
                if (value.equalsIgnoreCase(subs)) {
                    result[i] = 1;
                    break;
                }
            }
        }
        return result;
    }
}