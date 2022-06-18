import  java.util.*;
public class Level1 {
    public static String PatternUnlock (int N, int [] hits) {
        int bufferConvertedNumber = 0; // buffer for converted numbers
        ArrayList<Integer> arrayConvertedNumber = new ArrayList<>(); //array of converted pairs of numbers
        StringBuilder stringConverted = new StringBuilder();
        //converts an array into a string with a pair of numbers
        for (int i = 0; i < N; i++) {
            stringConverted.append(hits[i]);
            for (int j = i+1; j < N; j++) {
                stringConverted.append(hits[i + 1]);
                bufferConvertedNumber = Integer.parseInt(String.valueOf(stringConverted)); // converted a string with a pair of numbers into a number
                arrayConvertedNumber.add(bufferConvertedNumber); // add sequential numbers to the array
                stringConverted = new StringBuilder();
                if (stringConverted.toString().equals(""))
                    break;
            }
        }
        // create and fill in maps for straight and diagonals
        int [] rowNumbers = new int[] {61, 16, 52, 25, 43, 34, 19, 91, 28, 82, 37, 73, 65, 56, 54, 45, 12, 21, 23, 32, 98, 89, 78, 87};
        int [] diagonalNumbers = new  int[] {62, 26, 51, 15, 42, 24, 35, 53, 29, 92, 18, 81, 38, 83, 27, 72};
        double rowValue = 1.0;
        double diagonalValue = 1.414215;
        HashMap <Integer, Double> rowMap = new HashMap<>();
        for (int rowNumber : rowNumbers) {
            rowMap.put(rowNumber, rowValue);
        }
        HashMap <Integer, Double> diagonalMap = new HashMap<>();
        for (int diagonalNumber : diagonalNumbers) {
            diagonalMap.put(diagonalNumber, diagonalValue);
        }
        //Looking for the values in the mats on the obtained array of pair numbers
        //unload the results of the direct
        ArrayList<Double>  resultRow = new ArrayList<>();
        for (Integer item : arrayConvertedNumber) {
            if (rowMap.containsKey(item)) {
                resultRow.add(rowMap.get(item));
            }
        }
        //Looking for the values in the maps on the obtained array of pair numbers
        //unload diagonal results into an array
        ArrayList<Double> resultDiagonal = new ArrayList<>();
        for (Integer integer : arrayConvertedNumber) {
            if (diagonalMap.containsKey(integer)) {
                resultDiagonal.add(diagonalMap.get(integer));
            }
        }
        //comprising all the direct
        double sumRow = 0.0;
        for (Double value : resultRow) {
            sumRow = sumRow + value;
        }
        //sum diagonals
        double sumDiagonal = 0.0;
        for (Double aDouble : resultDiagonal) {
            sumDiagonal = sumDiagonal + aDouble;
        }
        //sum of straight and diagonal
        double allSum = sumRow + sumDiagonal;
        //set the accuracy of five characters after the point
        int accurateValue = (int)(allSum * 100000);
        //if the number is 0 - remove it
        String cutValue = String.valueOf(accurateValue);
        char [] conversionValue = cutValue.toCharArray();
        StringBuilder bufferValue = new StringBuilder();
        for (char c : conversionValue) {
            if (c != '0') {
                bufferValue.append(c);
            }
        }
        return String.valueOf(bufferValue);
    }
}
