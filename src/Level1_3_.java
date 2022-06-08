import java.util.*;
public class Level1 {
    public static int ConquestCampaign(int N, int M, int L, int [] battalion) {
        int [] [] square = new int[N][M]; //подготовили поле для десантирования
        for (int i = 0; i < (L*2); i++){ //Mark point's on map
            if (i %2 == 0){
                square [battalion[i]-1][battalion[i+1]-1]= 1;
            }
        }
        int countOfDays = 1; //счетчик дней
        boolean flag = true; // флаг проверки матрицы
        int [] [] squareEtalon = new int[N][M];
        for (int[] ints : squareEtalon) { // создаем эталонную матрицу (поле которое все захвачено)
            Arrays.fill(ints, 1); // чтобы сравнивать полученные матрицы с эталонной
        }

        // is comparing squaretalon and  square
        if (Arrays.deepEquals(squareEtalon,square)) { // сравниваем матрицы эталон и подготовл для захвата (вдруг она уже захвачена в момент десанитрования)
            return countOfDays;
        }
        while (flag) { // пока флаг истина (т.е. матрицы не совпадают) делаем
            int[][] squareOne = new int[N][M]; // копируем из исходной матрицы в первую.. т.к. действия по горизонт и по вертикали
            for (int y = 0; y < squareOne.length; y++) { // будут на разных матрицах, а потом эти две сольються в одну
                System.arraycopy(square[y], 0, squareOne[y], 0, squareOne[0].length); // и уже матрица слияния будет сравниваться с эталоном
            }
            for (int y = 0; y < squareOne.length; y++) { // делаем захват по х
                for (int x = 0; x < squareOne[0].length; x++) {
                    if (x == 0 && squareOne[y][x + 1] != 1 ) {
                        squareOne[y][x + 1] = 1;
                        break;
                    }
                    if (x == 0 && squareOne[y][x + 1] == 1 ) {
                        squareOne[y][x + 1] = 1;
                        continue;
                    }
                    if (x > 0 && x != (squareOne[0].length - 1) && squareOne[y][x + 1] != 1 && (squareOne[y][x - 1] != 1)) {
                        squareOne[y][x + 1] = 1;
                        squareOne[y][x - 1] = 1;
                        break;
                    }
                    if (x > 0 && x != (squareOne[0].length - 1) && squareOne[y][x - 1] == 1 && (squareOne[y][x + 1] != 1)) {
                        squareOne[y][x + 1] = 1;
                        break;
                    }
                    if (x > 0 && x != (squareOne[0].length - 1) && squareOne[y][x - 1] != 1 && (squareOne[y][x + 1] == 1)) {
                        squareOne[y][x - 1] = 1;
                        break;
                    }
                    if (x == (squareOne[0].length - 1) && squareOne[y][x - 1] != 1) {
                        squareOne[y][x - 1] = 1;
                        break;
                    }
                }
            }
            int[][] squareTwo = new int[N][M]; // теперь копируем исходную матрицу во вторую
            for (int y = 0; y < squareOne.length; y++) {
                System.arraycopy(square[y], 0, squareTwo[y], 0, squareOne[0].length);
            }
            for (int x = 0; x < squareTwo[0].length; x++) { // и на второй матрице делаем захват по у
                for (int y = 0; y < squareTwo.length; y++) {
                    if (y == 0 && squareTwo[y + 1][x] != 1) {
                        squareTwo [y + 1] [x] = 1;
                        break;
                    }
                    if (y == 0 && squareTwo [y + 1] [x] == 1) {
                        continue;
                    }

                    if (y > 0 && y != squareTwo.length - 1 && squareTwo [y + 1] [x] != 1 && squareTwo [y - 1] [x] != 1  ) {
                        squareTwo[y + 1][x] = 1;
                        squareTwo[y - 1][x] = 1;
                        break;
                    }
                    if (y > 0 && y != squareTwo.length - 1 && squareTwo[y - 1][x] == 1 && squareTwo [y + 1] [x] != 1 ) {
                        squareTwo[y + 1][x] = 1;
                        break;
                    }
                    if (y > 0 && y != squareTwo.length - 1 && squareTwo[y - 1][x] != 1 && squareTwo [y + 1] [x] == 1 ) {
                        squareTwo[y - 1][x] = 1;
                        break;
                    }
                    if (y == squareTwo.length - 1 && squareTwo[y - 1][x] != 1) {
                        squareTwo[y - 1][x] = 1;
                        break;
                    }
                }
            };
            int[][] squareAllMatrix = new int[N][M]; // сливаем две матрицы в одну - единую
            for (int y = 0; y < squareAllMatrix.length; y++) { //сначала сливаем матрицу захвата по х
                System.arraycopy(squareOne[y], 0, squareAllMatrix[y], 0, squareAllMatrix[0].length);
            }
            for (int y = 0; y < squareAllMatrix.length; y++) { // а затем доливаем матрицу захвата по у
                for (int x = 0; x < squareAllMatrix[0].length; x++) {
                    squareAllMatrix[y][x] = squareOne[y][x];
                    if (squareAllMatrix[y][x] != 1) { // с условием, если встречаются 0, то эти "пустые" ячейки заменяем данными из матрицы по у
                        squareAllMatrix[y][x] = squareTwo[y][x];
                    }
                }
            }
            for (int y = 0; y < square.length; y++) { // и матрицу слияния копируем в исходную (для продолжения цикла)
                System.arraycopy(squareAllMatrix[y], 0, square[y], 0, square[0].length);
            }
            countOfDays = countOfDays + 1; // день прошел :)
            if (Arrays.deepEquals(squareEtalon,squareAllMatrix)) { // если матрица слияния и эталонная равны - значит плацдарм захвачен полностью
                flag = false; // флаг в ложь и выходим по условию
            }
        }
        return countOfDays;
    }
}
