import java.util.*;
public class Level1 {
    public static boolean LineAnalysis (String line) {
        int returnVar =0;
        HashMap <String, Boolean> map = new HashMap<>();
        map.put("*", true);
        map.put("**", true);
        map.put("***", true);
        map.put("*.*", true);
        map.put("*..*..*..*..*..*..*", true);
        map.put("*.......*.......*", true);
        for (int i = 0; i < map.size(); i++) {
            if (map.containsKey(line)) {
                returnVar = 1 ;
            }
            if (!map.containsKey(line)) {
                returnVar = 0;
            }
        }
        if (returnVar == 1) {
            return true;
        }
        return false;
    }
}
