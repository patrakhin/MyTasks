import java.util.*;

public class Level1 {
    public static String BiggerGreater(String input) {
        String result = "";
        char[] restructure = input.toCharArray();
        int [] arrayList = new int[input.length()];
        int indexMax = 0;
        int indexMin = 0;
        boolean flagEquals = false;
        char [] structure = new char[restructure.length];
        int change ;
        //decoding
        for (int i = 0; i < restructure.length; i++) {
            arrayList[i] = (restructure[i]);
        }
        // Max and Min
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] > arrayList[indexMax]) {
                indexMax = i;
            }
            if (arrayList[i] < arrayList[indexMin]) {
                indexMin = i;
            }
        }
        //if arrayList.size = 2
        if (arrayList.length == 2 && indexMax == 0) {
            return result;
        }
        if (arrayList.length == 2) {
            int buf = arrayList[indexMax];
            arrayList[indexMax] = arrayList [0];
            arrayList[0] = buf;
        }
        for (int i = 0; i < restructure.length && arrayList.length == 2; i++) {
            change = arrayList[i];
            structure [i] = ((char) change);
        }
        if (arrayList.length == 2) {
            result = String.valueOf(structure);
            return result;
        }
        //if symbols of strings is equals
        for (int i = 0; i < arrayList.length - 2; i++) {
            if (arrayList[i] != arrayList [i+1]) {
                flagEquals = true;
                break;
            }
        }
        if (!flagEquals) {
            return result;
        }
        //if indexMax is last
        if (indexMax == (arrayList.length - 1)) {
            int buf = arrayList [indexMax];
            arrayList[indexMax] = arrayList [indexMax - 1];
            arrayList [indexMax - 1] = buf;
        }
        for (int i = 0; i < restructure.length && indexMax == (arrayList.length - 1); i++) {
            change = arrayList[i];
            structure [i] = ((char) change);
        }
        if (indexMax == (arrayList.length - 1)) {
            result = String.valueOf(structure);
            return result;
        }
        // if indexMax is 0
        int jumpB = 1;
        int jumpC = 1;
        int a = 0; // manage loop
        for (; a < arrayList.length; a ++) {
            if (a == 0) {
                continue;
            }
            for (int i = 1; i < arrayList.length; i++) {
                if (arrayList[i] > arrayList[jumpB]) {
                    jumpB = i;
                }
            }
            for (int i = 1; i < arrayList.length; i ++) {
                if (i == jumpB) {
                    continue;
                }
                if (arrayList[i] > arrayList[jumpC]) {
                    jumpC = i;
                }
            }
                int buf = arrayList [jumpB];
                arrayList[jumpB] = arrayList [jumpC];
                arrayList [jumpC] = buf;
                a = arrayList.length - 1;
        }
        for (int i = 0; i < restructure.length && indexMax == 0; i++) {
            change = arrayList[i];
            structure [i] = ((char) change);
        }
        if (indexMax == 0) {
            result = String.valueOf(structure);
            return result;
        }
        //if indexMax isn't 0
        //copy
        int [] declineArray = new int[arrayList.length];
        System.arraycopy(arrayList, 0, declineArray, 0, arrayList.length);
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
        int start = arrayList [0];
        int indexStartInSortArray = 0;
        //search entry point
        for (int b = 0; b < arrayList.length; b ++) {
            if (declineArray[b] == start) {
                indexStartInSortArray = b;
            }
        }
        //entry point
        int indexNumberLet = indexStartInSortArray - 1;
        int buffer = declineArray[indexNumberLet];
        int indexChangeNumber = 0;
        for (int d = 0; d < arrayList.length; d++){
            if (arrayList[d] == buffer) {
                indexChangeNumber = d;
            }
        }
        buffer = arrayList [0];
        arrayList [0] = arrayList [indexChangeNumber];
        arrayList [indexChangeNumber] = buffer;
        //end change
        buffer = arrayList[indexMax];
        arrayList[indexMax] = arrayList[indexMin];
        arrayList[indexMin] = buffer;
        //coding output
        for (int i = 0; i < restructure.length; i++) {
            change = arrayList[i];
            structure [i] = ((char) change);
        }
        result = String.valueOf(structure);
        return result;
    }
}










