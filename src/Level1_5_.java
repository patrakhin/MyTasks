import java.util.*;
public class Level1 {
    public static int [] SynchronizingTables(int N, int [] ids, int [] salary) {
        //copy to new array and organize the list of employees
        int [] newIds = new int[ids.length];
        for (int i = 0; i < N; i++) {
            newIds [i] = ids [i];
        }
        int buffer;
        for (int j = 0; j < N; j ++) {
            int min = j;
            for (int i  = j + 1; i < N; i ++) {
                if (newIds[min] > newIds[i]) {
                    min = i;
                }
            }
            buffer = newIds [j];
            newIds [j] = newIds [min];
            newIds [min] = buffer;
        }
        //copy to new array and organize the salary list
        int [] newSalary = new int[salary.length];
        for (int i = 0; i < N; i++) {
            newSalary [i] = salary [i];
        }
        int bufferTwo;
        for (int j = 0; j < N; j ++) {
            int min = j;
            for (int i  = j + 1; i < N; i ++) {
                if (newSalary[min] > newSalary[i]) {
                    min = i;
                }
            }
            bufferTwo = newSalary [j];
            newSalary [j] = newSalary [min];
            newSalary [min] = bufferTwo;
        }
        //We will enter into the map of orderly employees and salaries
        HashMap <Integer, Integer> myHashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            myHashMap.put(newIds[i],newSalary[i]);
        }
        //Let’s unload our salary in the array according to the list of employees (which is given to us at the zadacha)
        int [] newZarplata = new int[newSalary.length];
        for (int j = 0; j < N; j++) {
            newZarplata [j] = myHashMap.get(ids[j]);
        }
        return newZarplata;
    }
}
