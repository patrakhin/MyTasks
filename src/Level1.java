import java.util.*;
public class Level1 {
    public static String TheRabbitsFoot (String s, boolean encode) {
        String s2 = s;
        if (encode) {
            s2 = s.replaceAll("\\s",""); //удаляем все пробелы из строки - строка перед шифровкой
        }
        int countgap = 0; //счетчик пробелов
        int count = 0; // счетчик символов в строке
        //считаем количество пробелов для дешифровки
        for (int i = 0; i < s2.length(); i++) {
            if (encode) {
                break;
            }
            if (s2.charAt(i) == ' ') {
                countgap += 1;
            }
        }
        StringBuilder aftercode = new StringBuilder(); // строка после шифровки - расшифровки
        double numderofsqrt = Math.sqrt(s2.length()); //находим кв.корень длины строки без пробелов
        int string = (int) numderofsqrt; // строка
        int column = (int) ((numderofsqrt - string) * 10); //столбец
        // если количество столбцов = 0, прибавим количество посчитанных пробелов плюс 3
        if (column == 0) {
            column = countgap + 3;
        }
        //создаем матрицу
        char [] [] redbag; // символьная матрица
        while ((string * column) < s2.length()) {
            string += 1;
        }
        redbag = new char[string][column];
        //КОДИРУЕМ
        // заполняем по строчно двумерный массив
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
        //выводим зашифрованный текст : сверху-вниз  справа на лево
        for (int j = 0; j < column; j++){
            if (!encode) {
                break;
            }
            for (int i = 0; i < string; i++) {
                aftercode.append(redbag[i][j]);
            }
            aftercode.append(" ");
        }
        //РАСКОДИРУЕМ
        StringBuilder finish = new StringBuilder();
        count = 0; //обнуляем счетчик
        int countStrings = 0;
        int countColum = 1;
        //считаем количество символов в первом слове до пробела - это будет количество строк
        for (int j = 0 ; j < s2.length() ; j++ ) {
            if (s2.charAt(j) == ' ' || encode) {
                break;
            }
            countStrings += 1;
        }
        //считаем количество слов, это количество пробелов + 1
        for (int j = 0 ; j < s2.length() ; j++ ) {
            if (encode) {
                break;
            }
            if (s2.charAt(j) == ' ') {
                countColum += 1;
            }
        }
        //создаем матрицу определенного нами размера
        //заполняем по столбцам сверху вниз слева на право, если символ == “ ” при заполнении, в начале столбца, то берем следующий символ
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
        //  создаем расшифрованную строку
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
        aftercode = new StringBuilder(aftercode.toString().replaceAll("\\p{C}", "")); //тирмим строку для выдачи результата
        aftercode = new StringBuilder(aftercode.toString().trim());
        return aftercode.toString();
    }
}
