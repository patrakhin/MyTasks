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





/*
//
    public static void ListOfRepeated (int CountOfRepeat) {
        ArrayList <Integer> Start = CreatingList.ListOfValues(); // получили список из 100 значений (диапазон от 1 до 10)
        HashMap <Integer, Integer> NumberOfRepeat = new HashMap<>(); // словарь повторяющихся значений
        Set<Integer> CollectionOfKeys = NumberOfRepeat.keySet(); // коллекция ключей
        for (int x = 0; x < Start.size(); x ++) { // обходим список значений
            if ( !NumberOfRepeat.containsKey(Start.get(x)) )  // если нет в наличии ключа равного значению из списка
                NumberOfRepeat.put(Start.get(x), 0); // тогда значение и есть ключ, а число повторов  = 0
            else { // иначе (если такой ключ есть)
                int buffer = NumberOfRepeat.get(Start.get(x)); // получаем по ключу число повторов
                NumberOfRepeat.put(Start.get(x), buffer+1); // и увеличиваем число повторов на 1 (перезаписываем)
            }
            if (x == Start.size()-1) { // когда словарь сформирован
                for (Integer i : CollectionOfKeys) { // обходим словарь по коллекции ключей
                    if (CountOfRepeat <= NumberOfRepeat.get(i)) { // если значение >= заданного количества повторов
                        System.out.println("Number = " + i + " Repeats = " + NumberOfRepeat.get(i)); // выводим
                    }
                }
            }
        }
    }


//
    public static void ListOfRepeated (int CountOfRepeat) {
        ArrayList <Integer> Start = CreatingList.ListOfValues(); // получили список из 100 значений (диапазон от 1 до 10)
        HashMap <Integer, Integer> NumberOfRepeat = new HashMap<>(); // словарь повторяющихся значений
        Set<Integer> z = NumberOfRepeat.keySet(); // коллекция ключей
        for (int x = 0; x < Start.size(); x ++) { // обходим список значений
                    if ( !NumberOfRepeat.containsKey(Start.get(x)) )  // если нет в наличии ключа равного значению из списка
                        NumberOfRepeat.put(Start.get(x), 0); // тогда значение и есть ключ, а число повторов  = 0
                    else { // иначе (если такой ключ есть)
                        int buffer = NumberOfRepeat.get(Start.get(x)); // получаем по ключу число повторов
                        NumberOfRepeat.put(Start.get(x), buffer+1); // и увеличиваем число повторов на 1 (перезаписываем)
                    }
        }
        for (Integer i : NumberOfRepeat.keySet() ) { // обходим словарь
            if (CountOfRepeat <= NumberOfRepeat.get(i)) { // если число повторов >= заданного количества повторов
                System.out.println("Number = " + i + "   Repeats = " + NumberOfRepeat.get(i) ); // выводим список
            }
        }
    }
    public static void main(String[] args) { ListOfRepeated(0); } // количество повторов

 //
     public static void ListOfRepeated (int CountOfRepeat) {
        ArrayList <Integer> Start = CreatingList.ListOfValues(); // получили список из 100 значений (диапазон от 1 до 10)
        HashMap <Integer, Integer> NumberOfRepeat = new HashMap<>(); // список повторяющихся значений
        int CounterOfRepeated = 0; // количество повторов значений
        int Comparing; // сравниваемое значение
        for (int x = 0; x < Start.size(); x ++) { // обходим список значений
                for (int i = x + 1; i < Start.size(); i ++) { // обходим список значений начиная со следующего
                    Comparing = Start.get(x); // сравниваемое значение по индексу Х из списка
                    if (Comparing == Start.get(i)) { // если сравнив.значение равно следующему
                        CounterOfRepeated ++; // тогда счетчик +1
                    }
                }
            NumberOfRepeat.put(x, CounterOfRepeated ); // добавляем в список количество повторов
            CounterOfRepeated = 0; // обнуляем счетчик повторов
        }
        for (Integer i : NumberOfRepeat.keySet()) {
            if (CountOfRepeat <=  NumberOfRepeat.get(i) ) {
                System.out.println("Key = " + i + "  Value = " + NumberOfRepeat.get(i));
            }
        }
    }
    public static void main(String[] args) {
        ListOfRepeated(5);
    }


//
    public static void ListOfRepeated (int CountOfRepeat) {
        ArrayList <Integer> Start = CreatingList.ListOfValues(); // получили список из 100 значений (диапазон от 1 до 10)
        HashMap <Integer, Integer> FilterOfList = new HashMap<>(); // список значений которые уже были учтены
        HashMap <Integer, Integer> NumberOfRepeat = new HashMap<>(); // список повторяющихся значений
        int CounterOfRepeated = 0; // количество повторов значений
        int Comparing; // сравниваемое значение
        int Unique = 0;
        for (int x = 0; x < Start.size(); x ++) { //обходим список значений
            if (x == 0) {
                FilterOfList.put(Unique , Start.get(x)); //если это первое значение из массива, просто добавь его в список
            }
            else {
                for (int s = 0; s < x; s++) { // иначе сравни со значениями в списке, если такое есть, начни заново
                    if (Start.get(x) == s) {
                        break;
                    }
                }
            }
            for (int i = x + 1; i < Start.size(); i ++) {
               Comparing = Start.get(x);
               if (Comparing == Start.get(i)) {
                   CounterOfRepeated ++;
               }
            }
            FilterOfList.put(Unique, Start.get(x)); // значение уникальное, добавь его в список
            NumberOfRepeat.put(x, CounterOfRepeated ); // добавляем в список количество повторов
            CounterOfRepeated = 0;
            Unique ++;

        }
        for (Integer i : FilterOfList.keySet()) {
            if (CountOfRepeat <=  FilterOfList.get(i) ) {
                System.out.println("Key Uniq= " + i + "  Value Uniq = " + FilterOfList.get(i));
            }
        }
        for (Integer i : NumberOfRepeat.keySet()) {
            if (CountOfRepeat <=  NumberOfRepeat.get(i) ) {
                System.out.println("Key = " + i + "  Value = " + NumberOfRepeat.get(i));
            }
        }
    }
//
        for (Integer i : FilterOfList.keySet()) {
            if (CountOfRepeat <=  FilterOfList.get(i) ) {
                System.out.println("Key = " + i + "  Value = " + FilterOfList.get(i));
            }
        }
 */