import java.util.*;
public class Level1 {
    public static String [] ShopOLAP(int N, String [] items) {
        HashMap <String, Integer> mapItems = new HashMap<>();
        boolean breakEr = false;
        String key = "";
        String value = "";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < items [i].length(); j++) {
                if (items [i].charAt(j) != ' ' && !breakEr) {
                    key += items [i].charAt(j);
                }
                if (items [i].charAt(j) == ' ') {
                    breakEr = true;
                }
                if (items [i].charAt(j) != ' ' && breakEr) {
                    value += items [i].charAt(j);
                }
            }
            if (mapItems.containsKey(key)) {
                mapItems.put(key, (mapItems.get(key) + Integer.parseInt(value)));
            }
            if (!mapItems.containsKey(key)) {
                mapItems.put(key, Integer.parseInt(value));
            }
            key = "";
            value = "";
            breakEr = false;
        }
        // sort map by  lexicography_name
        List<String> list = new ArrayList<>(mapItems.keySet());
        list.sort(null);
        //crate sort map
        String [] sortItems = new String[mapItems.size()];
        for (int i = 0; i < list.size(); i++) {
            sortItems [i] = (list.get(i) + ' ' + mapItems.get(list.get(i)));
        }
        return sortItems;
    }
}
