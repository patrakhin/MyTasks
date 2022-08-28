import java.util.*;
public class Level1 {
    public static String BiggerGreater(String input) {
        StringBuilder result = new StringBuilder();
        char[] restructure = input.toCharArray();
        boolean flag = false; //it's eng  true - rus
        HashMap<Character, Integer> alphabet = new HashMap<>();
        HashMap<Integer, Character> reversAlphabetRus = new HashMap<>();
        HashMap<Integer, Character> reversAlphabetEng = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        alphabet.put('а', 1); alphabet.put('б', 2); alphabet.put('в', 3); alphabet.put('г', 4); alphabet.put('д', 5); alphabet.put('е', 6);
        alphabet.put('ё', 7); alphabet.put('ж', 8); alphabet.put('з', 9); alphabet.put('и', 10); alphabet.put('й', 11); alphabet.put('к', 12);
        alphabet.put('л', 13); alphabet.put('м', 14); alphabet.put('н', 15); alphabet.put('о', 16); alphabet.put('п', 17); alphabet.put('р', 18);
        alphabet.put('с', 19); alphabet.put('т', 20); alphabet.put('у', 21); alphabet.put('ф', 22); alphabet.put('х', 23); alphabet.put('ц', 24);
        alphabet.put('ч', 25); alphabet.put('ш', 26); alphabet.put('щ', 27); alphabet.put('ъ', 28); alphabet.put('ы', 29); alphabet.put('ь', 30);
        alphabet.put('э', 31); alphabet.put('ю', 32); alphabet.put('я', 33);
        alphabet.put('a', 1); alphabet.put('b', 2);
        alphabet.put('c', 3);
        alphabet.put('d', 4);
        alphabet.put('e', 5);
        alphabet.put('f', 6);
        alphabet.put('g', 7);
        alphabet.put('h', 8);
        alphabet.put('i', 9);
        alphabet.put('j', 10);
        alphabet.put('k', 11);
        alphabet.put('l', 12);
        alphabet.put('m', 13);
        alphabet.put('n', 14);
        alphabet.put('o', 15);
        alphabet.put('p', 16);
        alphabet.put('q', 17);
        alphabet.put('r', 18);
        alphabet.put('s', 19);
        alphabet.put('t', 20);
        alphabet.put('u', 21);
        alphabet.put('v', 22);
        alphabet.put('w', 23);
        alphabet.put('x', 24);
        alphabet.put('y', 25);
        alphabet.put('z', 26);

        reversAlphabetRus.put(1, 'а');
        reversAlphabetRus.put(2, 'б');
        reversAlphabetRus.put(3, 'в');
        reversAlphabetRus.put(4, 'г');
        reversAlphabetRus.put(5, 'д');
        reversAlphabetRus.put(6, 'е');
        reversAlphabetRus.put(7, 'ё');
        reversAlphabetRus.put(8, 'ж');
        reversAlphabetRus.put(9, 'з');
        reversAlphabetRus.put(10, 'и');
        reversAlphabetRus.put(11, 'й');
        reversAlphabetRus.put(12, 'к');
        reversAlphabetRus.put(13, 'л');
        reversAlphabetRus.put(14, 'м');
        reversAlphabetRus.put(15, 'н');
        reversAlphabetRus.put(16, 'о');
        reversAlphabetRus.put(17, 'п');
        reversAlphabetRus.put(18, 'р');
        reversAlphabetRus.put(19, 'с');
        reversAlphabetRus.put(20, 'т');
        reversAlphabetRus.put(21, 'у');
        reversAlphabetRus.put(22, 'ф');
        reversAlphabetRus.put(23, 'х');
        reversAlphabetRus.put(24, 'ц');
        reversAlphabetRus.put(25, 'ч');
        reversAlphabetRus.put(26, 'ш');
        reversAlphabetRus.put(27, 'щ');
        reversAlphabetRus.put(28, 'ъ');
        reversAlphabetRus.put(29, 'ы');
        reversAlphabetRus.put(30, 'ь');
        reversAlphabetRus.put(31, 'э');
        reversAlphabetRus.put(32, 'ю');
        reversAlphabetRus.put(33, 'я');

        reversAlphabetEng.put(1, 'a');
        reversAlphabetEng.put(2, 'b');
        reversAlphabetEng.put(3, 'c');
        reversAlphabetEng.put(4, 'd');
        reversAlphabetEng.put(5, 'e');
        reversAlphabetEng.put(6, 'f');
        reversAlphabetEng.put(7, 'g');
        reversAlphabetEng.put(8, 'h');
        reversAlphabetEng.put(9, 'i');
        reversAlphabetEng.put(10, 'j');
        reversAlphabetEng.put(11, 'k');
        reversAlphabetEng.put(12, 'l');
        reversAlphabetEng.put(13, 'm');
        reversAlphabetEng.put(14, 'n');
        reversAlphabetEng.put(15, 'o');
        reversAlphabetEng.put(16, 'p');
        reversAlphabetEng.put(17, 'q');
        reversAlphabetEng.put(18, 'r');
        reversAlphabetEng.put(19, 's');
        reversAlphabetEng.put(20, 't');
        reversAlphabetEng.put(21, 'u');
        reversAlphabetEng.put(22, 'v');
        reversAlphabetEng.put(23, 'w');
        reversAlphabetEng.put(24, 'x');
        reversAlphabetEng.put(25, 'y');
        reversAlphabetEng.put(26, 'z');

        if (Character.UnicodeBlock.of(restructure[0]).equals(Character.UnicodeBlock.CYRILLIC)) {
            flag = true;
        }
        if (Character.UnicodeBlock.of(restructure[0]).equals(Character.UnicodeBlock.BASIC_LATIN)) {
            flag = false;
        }
        for (char c : restructure) {
            arrayList.add(alphabet.get(c));
        }

        int indexMax = 0;
        int indexMin = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) > arrayList.get(indexMax)) {
                indexMax = i;
            }
            if (arrayList.get(i) < arrayList.get(indexMin)) {
                indexMin = i;
            }
        }
        //if arrayList.size = 2
        if (arrayList.size() == 2 && indexMax == 0) {
            result = new StringBuilder();
            return result.toString();
        }
        if (arrayList.size() == 2) {
            int buf = arrayList.get(indexMax);
            arrayList.remove(indexMax);
            arrayList.add(indexMax, arrayList.get(0));
            arrayList.remove(0);
            arrayList.add(0, buf);
        }
        for (int i = 0; i < arrayList.size() && flag && arrayList.size() == 2; i++) {
            result.append(reversAlphabetRus.get(arrayList.get(i)));
        }
        for (int i = 0; i < arrayList.size() && !flag && arrayList.size() == 2; i++) {
            result.append(reversAlphabetEng.get(arrayList.get(i)));
        }
        if (arrayList.size() == 2) {
            return result.toString();
        }
        //if symbols of strings is equals
        Integer[] sortingArrayOne;
        sortingArrayOne = arrayList.toArray(new Integer[0]);
        Arrays.sort(sortingArrayOne, Comparator.reverseOrder());    //

        Integer[] sortingArrayTwo = arrayList.toArray(new Integer[0]);

        if (Arrays.equals(sortingArrayTwo, sortingArrayOne)) {
            result = new StringBuilder();
            return result.toString();
        }
        //if indexMax = 0 and indexMin = 1
        int indexSecondMAx = 1;
        for (int i = 1; i < arrayList.size() && indexMax == 0; i++) {
            if (arrayList.get(i) > arrayList.get(indexSecondMAx)) {
                indexSecondMAx = i;
            }
        }
        if (indexMax == 0) {
            int buf = arrayList.get(indexSecondMAx);
            arrayList.remove(indexSecondMAx);
            arrayList.add(indexSecondMAx, arrayList.get(indexSecondMAx - 1));
            arrayList.remove(indexSecondMAx - 1);
            arrayList.add(indexSecondMAx - 1, buf);
        }
        for (int i = 0; i < arrayList.size() && flag && indexMax == 0; i++) {
            result.append(reversAlphabetRus.get(arrayList.get(i)));
        }
        for (int i = 0; i < arrayList.size() && !flag && indexMax == 0; i++) {
            result.append(reversAlphabetEng.get(arrayList.get(i)));
        }

        if (indexMax == 0) {
            return result.toString();
        }

        //if indexMax is last
        if (indexMax == (arrayList.size() - 1)) {
            int buf = arrayList.get(indexMax);
            arrayList.remove(indexMax);
            arrayList.add(indexMax, arrayList.get(indexMax - 1));
            arrayList.remove(indexMax - 1);
            arrayList.add(indexMax - 1, buf);
        }
        for (int i = 0; i < arrayList.size() && flag && indexMax == (arrayList.size() - 1); i++) {
            result.append(reversAlphabetRus.get(arrayList.get(i)));
        }
        for (int i = 0; i < arrayList.size() && !flag && indexMax == (arrayList.size() - 1); i++) {
            result.append(reversAlphabetEng.get(arrayList.get(i)));
        }

        if (indexMax == (arrayList.size() - 1)) {
            return result.toString();
        }

        //if  indexMax isn't 0 index
        boolean flagSomeIndexMax = false;
        boolean flagBreak = false;
        Integer[] comparedArray;
        comparedArray = arrayList.toArray(new Integer[0]);
        int someIndexMax = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (flagBreak) {
                break;
            }
            if (arrayList.get(0) < arrayList.get(i) && arrayList.get(i) < arrayList.get(indexMax)&& !flagSomeIndexMax) {
                someIndexMax = i;
                flagSomeIndexMax = true;
            }
            if (flagSomeIndexMax) {
                int buf = arrayList.get(someIndexMax);
                arrayList.remove(someIndexMax);
                arrayList.add(someIndexMax, arrayList.get(0));
                arrayList.remove(0);
                arrayList.add(0, buf);
            }

            if (comparedArray[1] >= arrayList.get(1) && flagSomeIndexMax) {
                int bufMax = arrayList.get(indexMax);
                int bufMin = arrayList.get(indexMin);
                arrayList.remove(indexMax);
                arrayList.add(indexMax, bufMin);
                arrayList.remove(indexMin);
                arrayList.add(indexMin, bufMax);
                flagBreak = true;
            }
            if (comparedArray[1] < arrayList.get(1) && flagSomeIndexMax && !flagBreak) {
                flagBreak = true;
            }
        }
        for (int i = 0; i < arrayList.size() && flag; i++) {
            result.append(reversAlphabetRus.get(arrayList.get(i)));
        }
        for (int i = 0; i < arrayList.size() && !flag; i++) {
            result.append(reversAlphabetEng.get(arrayList.get(i)));
        }
        return result.toString();
    }
}
