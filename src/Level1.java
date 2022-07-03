import java.util.*;
public class Level1 {
    public static String MassVote (int N, int [] Votes) {
        int maxNumber;
        int indexNumberMax = 0; //потом добавь 1 т.к. это номера участников а они с нуля не начинаются :) - индекс самого большого числа
        int maxNumberCount = 0; //счетчик количества самых больших чисел
        int sumOfAllNumbers = 0; //сумма всех чисел - голосов - начинаем с самого первого
        double percentOfSum = 0;
        double percentOfSunAfterCut = 0;
        boolean flag = false;
        String majority = "majority";
        String minority = "minority";
        String winner = "winner";
        String nowinner = "no winner";
        String massVote = "";
        //search biggest
        maxNumber = Votes[0];
        for (int i = 0; i < Votes.length; i ++) {
            for (int j = i+1; j < Votes.length; j ++) {
                if (Votes [j] > maxNumber) {
                    maxNumber = Votes[j];
                    indexNumberMax = j;
                }
            }
            sumOfAllNumbers += Votes[i];
        }
        // counting number biggest
        for (int vote : Votes) {
            if (vote == maxNumber) {
                maxNumberCount += 1;
            }
        }
        if (maxNumberCount > 1) {
            massVote = nowinner;
            return massVote; //re-election if max voice > 1
        }
        if (sumOfAllNumbers == 0) {
            flag = true;
            massVote = nowinner;
            return massVote; // re-election if nobody takes of voice
        }
        if (maxNumberCount == 1 && !flag) {
            // search % sum of all numbers
            percentOfSum = (double) (Votes[indexNumberMax]*100)/sumOfAllNumbers; // search per cent
            percentOfSunAfterCut = (double) ((int) (percentOfSum * 1000)) / 1000; //cut for 3 token
            if (percentOfSunAfterCut > 50) {
                massVote = majority + " " + winner + " " + (indexNumberMax + 1);
            }
            if (percentOfSunAfterCut <= 50) {
                massVote = minority + " " + winner + " " + (indexNumberMax + 1);
            }
        }
        return massVote;
    }
}
