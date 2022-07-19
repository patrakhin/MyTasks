import java.util.*;
public class Level1 {
    public static String [] ShopOLAP(int N, String [] items) {
        HashMap<String, Integer> mapItems = new HashMap<>();
        HashMap <Integer, String> mapIndex = new HashMap<>(); //for double sel of item
        boolean breakEr = false;
        String key = ""; //id-Items
        String value = ""; //id-Sel
        boolean flagFull = false;
        String [] stringKey = new String[items.length];
        int [] intValue = new int[items.length];
        //if keys equal - addition
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < items[i].length(); j++) {
                if (items[i].charAt(j) != ' ' && !breakEr) {
                    key += items[i].charAt(j);
                }
                if (items[i].charAt(j) == ' ') {
                    breakEr = true;
                }
                if (items[i].charAt(j) != ' ' && breakEr) {
                    value += items[i].charAt(j);
                }
            }
            if (mapItems.containsKey(key)) {
                mapItems.put(key, (mapItems.get(key) + Integer.parseInt(value)));
            }
            if (!mapItems.containsKey(key)) {
                mapItems.put(key, Integer.parseInt(value));
            }
            stringKey [i] = key;
            intValue [i] = Integer.parseInt(value);

            key = "";
            value = "";
            breakEr = false;
        }
        //put in mapIndex double values
        for (int i = 0; i < mapItems.size(); i++) {
            for (int k = i + 1; k < mapItems.size(); k++) {
                if (intValue[i] == intValue[k]) {
                    mapIndex.put(i, stringKey[i]);
                    mapIndex.put(k, stringKey[k]);
                }
            }
        }
        // if mapIndex don't empty - flag = true
        if (mapIndex.size() != 0) {
            flagFull = true;
        }
        //sort double values to lexicography
        List<String> listLexicography = new ArrayList<>(mapIndex.values());
        listLexicography.sort(null);
        //revers selItems
        HashMap <Integer, String> selItems = new HashMap<>();
        for (int i = 0; i < mapItems.size(); i++) {
            selItems.put(intValue[i], stringKey [i]);
        }
        //sort intValue
        for (int i = 0; i < intValue.length; i++) {
            for (int j = i+1; j < intValue.length; j++) {
                if (intValue[i] < intValue[j]) {
                    int buff = intValue [i];
                    intValue [i] = intValue[j];
                    intValue [j] = buff;
                }
            }
        }
        //endArray
        boolean bulidDouble = false;
        boolean flagEnd = false;
        String [] endArray = new String[mapItems.size()];
        for (int i = 0; i < mapItems.size(); i++) {
            for (String s : listLexicography) {
                if (i == mapItems.size() - 1 && intValue[i - 1] == intValue[i]) {
                    endArray[i] = (s + ' ' + mapItems.get(s));
                    flagEnd = true;
                    break;
                }
                if (flagFull && intValue[i] == intValue[i + 1] && i + 1 != mapItems.size()) {
                    endArray[i] = (s + ' ' + mapItems.get(s));
                    i += 1;
                    bulidDouble = true;
                    continue;
                }
                if (flagFull && intValue[i] != intValue[i + 1] && i + 1 != mapItems.size() && bulidDouble) {
                    endArray[i] = (s + ' ' + mapItems.get(s));
                    i += 1;
                    break;
                }
            }
            if (flagEnd) {
                break;
            }
            endArray [i] = (selItems.get(intValue[i]) + ' '+ mapItems.get(selItems.get(intValue[i])));
        }
        return endArray;
    }
}
