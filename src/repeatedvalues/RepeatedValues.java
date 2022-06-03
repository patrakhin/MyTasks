package repeatedvalues;
import mycreatinglist.CreatingList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RepeatedValues {
    private static final Logger imLogger = Logger.getLogger(RepeatedValues.class.getName());
    public static void listOfRepeated (int countOfRepeat) {
        ArrayList <Integer> startList = (ArrayList<Integer>) CreatingList.listOfValues(); // получили список из 100 значений (диапазон от 1 до 10)
        HashMap <Integer, Integer> numberOfRepeat = new HashMap<>(); // словарь повторяющихся значений
        for (int x = 0; x < startList.size(); x ++) { // обходим список значений
            if ( !numberOfRepeat.containsKey(startList.get(x)) )  // если нет в наличии ключа равного значению из списка
                numberOfRepeat.put(startList.get(x), 0); // тогда значение и есть ключ, а число повторов  = 0
            else { // иначе (если такой ключ есть)
                int buffer = numberOfRepeat.get(startList.get(x)); // получаем по ключу число повторов
                numberOfRepeat.put(startList.get(x), buffer+1); // и увеличиваем число повторов на 1 (перезаписываем)
            }
            if (countOfRepeat <= numberOfRepeat.get(startList.get(x))) { // если значение >= заданного количества повторов
                int finalX = x;
                imLogger.log(Level.INFO, ()-> "Number = " + startList.get(finalX) + " Repeats = " + numberOfRepeat.get(startList.get(finalX))); // выводим
            }
        }
    }
    public static void main(String[] args) { listOfRepeated(1); } // количество повторов
}
