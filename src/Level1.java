import java.util.*;
public class Level1 {
    public static boolean white_walkers (String village) {
        // my new marks
        int walkersBeforePeasant = 0;
        int walkersLikeBetweenPeasant = 0;
        int walkersBeenBetweenPeasant = 0;
        int walkersBetweenPeasant = 0;
        int countCatch = 0;
        int markI = 0;
        int peasant1 = 0;
        int peasant2 = -1;
        boolean flagPeasant1 = false;
        boolean flagForest = false;

        for (int i = 0; i < village.length(); i++) {
            if (village.charAt(i) != '=' && !Character.isDigit(village.charAt(i)) && !flagForest) {
                flagForest = true;
            }
            if (village.charAt(i) == '=' && !flagPeasant1) {
                walkersBeforePeasant += 1;
                flagForest = false;
            }
            if (village.charAt(i) == '=' && flagPeasant1) {
                walkersLikeBetweenPeasant += 1;
                flagForest = false;
            }
            if (Character.isDigit(village.charAt(i)) && !flagPeasant1) {
                peasant1 = Integer.parseInt(Character.toString(village.charAt(i)));
                flagPeasant1 = true;
                markI = i;
            }
            if (Character.isDigit(village.charAt(i)) && i != markI && flagPeasant1) {
                peasant2 = Integer.parseInt(Character.toString(village.charAt(i)));
                walkersBetweenPeasant = walkersLikeBetweenPeasant;
                walkersLikeBetweenPeasant = 0;
            }
            if (flagPeasant1 && peasant2 > -1 && flagForest && walkersBetweenPeasant == 0) {
                flagForest = false;
                peasant1 = peasant2;
                peasant2 = -1;
                markI = i;
            }
            if (((peasant1 + peasant2) != 10) && peasant2 > -1) {
                walkersBeenBetweenPeasant += 1;
                walkersBetweenPeasant = 0;
                peasant1 = peasant2;
                peasant2 = -1;
                markI = i;
            }
            if (((peasant1 + peasant2) == 10) && (walkersBetweenPeasant == 3) && peasant2 > -1) {
                countCatch += 1;
                walkersBetweenPeasant = 0;
                walkersBeenBetweenPeasant = 0;
                peasant1 = peasant2;
                peasant2 = -1;
                markI = i;
            }
            if (((peasant1 + peasant2) == 10) && (walkersBetweenPeasant != 3) && peasant2 > -1) {
                walkersBeenBetweenPeasant += 1;
                walkersBetweenPeasant = 0;
                peasant1 = peasant2;
                peasant2 = -1;
                markI = i;
            }

        }
        // result
        if (countCatch != 0 && walkersBeforePeasant == 0 && walkersLikeBetweenPeasant == 0 && walkersBeenBetweenPeasant == 0 && walkersBetweenPeasant == 0) {
            return true;
        }
        if (countCatch != 0 && walkersBeenBetweenPeasant != 0 && walkersBeforePeasant == 0 && walkersLikeBetweenPeasant == 0 && walkersBetweenPeasant == 0) {
            return false;
        }

        if (countCatch != 0 && walkersBeforePeasant != 0 && walkersBeenBetweenPeasant != 0 && walkersLikeBetweenPeasant == 0 && walkersBetweenPeasant == 0) {
            return true;
        }
        if (walkersBeforePeasant != 0 && walkersLikeBetweenPeasant == 0 && walkersBeenBetweenPeasant == 0 && walkersBetweenPeasant == 0) {
            return false;
        }
        return flagPeasant1;
    }
}
