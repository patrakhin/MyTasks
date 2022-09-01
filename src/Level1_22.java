import java.util.*;
public class Level1 {
    public static boolean SherlockValidString (String s) {
        char[] restructure = s.toCharArray();
        int[] arrayList = new int[s.length()];
        HashMap<Integer, Integer> repeated = new HashMap<>();
        //decoding
        for (int i = 0; i < restructure.length; i++) {
            arrayList[i] = (restructure[i]);
        }
        // search repeated
        for (int i = 0; i < arrayList.length; i++) {
            if (repeated.containsKey(arrayList[i])) {
                continue;
            }
            for (int j = i; j < arrayList.length; j++) {
                if ( arrayList[j] == arrayList [i] && !repeated.containsKey(arrayList[j])) {
                    repeated.put(arrayList[i], 0);
                }
                if ( arrayList[j] == arrayList [i] && repeated.containsKey(arrayList[j])) {
                    repeated.put(arrayList[i], repeated.get(arrayList[i]) + 1);
                }
            }
        }
        //get all values to list
        ArrayList<Integer> values = new ArrayList<>(repeated.values());
        int [] declineArray = new int[values.size()];
        for (int i = 0; i < declineArray.length; i++) {
            declineArray [i] = values.get(i);
        }
        //sort decline
        for (int i = 0; i < declineArray.length; i++) {
            for (int j = 0; j < declineArray.length; j++) {
                if (declineArray[i] >= declineArray[j]) {
                    int x = declineArray[i];
                    declineArray[i] = declineArray[j];
                    declineArray[j] = x;
                }
            }
        }
        // search valid

        //if all equals
        if (declineArray [0] == declineArray[declineArray.length - 1]) {
            return true;
        }
        //if are equal to all but the latter and latter - 1 = 0
        if ((declineArray [0] == declineArray[declineArray.length - 2]) && (((declineArray[declineArray.length - 1]) - 1) == 0)) {
            return true;
        }
        //if are equal to all but the first
        return (declineArray[declineArray.length - 1] == declineArray[1]) && ((declineArray[0] - 1) == declineArray[declineArray.length - 1]);
    }
}
