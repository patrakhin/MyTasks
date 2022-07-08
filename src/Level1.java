import java.util.*;
public class Level1 {
    public static int Unmanned (int L, int N, int [][] track) {
        HashMap <String, Integer> map = new HashMap <>();
        String [] variable = {"P","R","G"};
        int d = track [0].length; //3
        int tAbs = 0;
        int diff = 0;
        int ostatok = 0;
        int sumtAbs = 0;
        int buffPointTraffic = 0;
        boolean yesStop = true;
        boolean noStop = true;
        boolean flag = true;
        int theEndOfRoad = 0;
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < d ; i++) {
                map.put (variable[i], track [k] [i]);
            }
            int p = map.get("P");
            if (p > L) {
                theEndOfRoad = L;
                return theEndOfRoad;
            }
            if (!noStop ) { // if before delay don't drop time
                sumtAbs = 0;
            }
            if (!yesStop) { // if before delay drop time
                p = (map.get("P") - buffPointTraffic) + sumtAbs + buffPointTraffic;
            }
            noStop = true;
            yesStop = true;
            tAbs = 0;
            int r = map.get("R");
            int g = map.get("G");
            if (p < (r + g) && p < r && flag) {
                tAbs =(r - p); // drop time
                flag = false;
            }
            if (p < (r + g) && p >= r && flag) {
                tAbs = 0; // it's green light and don't drop time
                flag = false;
            }
            if (p == (r + g) && flag) {
                tAbs = r; // it's red light
                flag = false;
            }
            if (p > (r + g) && p % (r + g) == 0 && flag) {
                tAbs = r; // it's red light
                flag = false;
            }
            if (p > (r + g) && p % (r + g) != 0 && flag) {
                diff = (p / (r + g));
                ostatok = p - ((r + g) * diff); //
            }
            if (ostatok < (r + g) && ostatok < r && flag) {
                tAbs =(r - ostatok); // drop time on traffic
                flag = false;
            }
            if (ostatok < (r + g) && ostatok >= r && flag) {
                tAbs = 0; // green light and time don't drop
                flag = false;
            }

            if (tAbs == 0 && sumtAbs == 0) {  // drop time on traffic  - false and before - false
                sumtAbs = 0; //
                noStop = false; //
            }
            if (tAbs == 0 && sumtAbs != 0) {  // drop time on traffic  - false but before - true
                buffPointTraffic = map.get("P"); // position traffic latest for synchro
                sumtAbs += tAbs; // drop time on traffic
                yesStop = false; //
            }
            if (tAbs != 0) {  // drop time on traffic  - true
                buffPointTraffic = map.get("P"); // position traffic latest
                sumtAbs += tAbs; // drop time on traffic
                yesStop = false; //
            }
            if (k == (N -1) && sumtAbs != 0) { // this latest traffic and delay true
                theEndOfRoad = sumtAbs + (L - (map.get("P"))) + map.get("P");
            }
            if (k == (N -1) && sumtAbs == 0) { // this latest traffic and there's no lag.
                theEndOfRoad = L;
            }
            flag = true;
        }
        return theEndOfRoad;
    }
}
