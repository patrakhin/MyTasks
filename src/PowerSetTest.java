import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PowerSetTest {

    @org.junit.jupiter.api.Test
    void size() {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        assertEquals(20000, powerSet.size());
    }

    @org.junit.jupiter.api.Test
    void put() {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        assertTrue(powerSet.get(String.valueOf(10000)));
    }

    @org.junit.jupiter.api.Test
    void get() {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        assertTrue(powerSet.get("10000"));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        powerSet.remove("10000");
        assertFalse(powerSet.get("10000"));
    }

    @org.junit.jupiter.api.Test
    void intersection() { //pSet is full
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        PowerSet powerSet1 = new PowerSet();
        for (int i = 15000; i < 35000; i++) {
            powerSet1.put(String.valueOf(i));
        }
        long startTime = System.currentTimeMillis (); // get the time start
        PowerSet pw3 = powerSet.intersection(powerSet1);
        long endTime = System.currentTimeMillis (); // get the time finish
        //System.out.println ("Время выполнения программы:" + (endTime-startTime) / 1000 + "с"  );
        assertFalse(pw3.get("14999"));
        assertFalse(pw3.get("20000"));
        assertTrue(pw3.get("15000"));
        assertTrue(pw3.get("19999"));
        assertEquals(2,((endTime-startTime) / 1000));
        assertEquals(5000, pw3.size());
    }

    @org.junit.jupiter.api.Test
    void intersection2() { //pSet is empty
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        PowerSet powerSet1 = new PowerSet();
        for (int i = 21000; i < 35000; i++) {
            powerSet1.put(String.valueOf(i));
        }
        long startTime = System.currentTimeMillis (); // get the time start
        PowerSet pw3 = powerSet.intersection(powerSet1);
        long endTime = System.currentTimeMillis (); // get the time finish
        //System.out.println ("Время выполнения программы:" + (endTime-startTime) / 1000 + "с"  );
        assertFalse(pw3.get("19999"));
        assertFalse(pw3.get("21000"));
        assertEquals(2,((endTime-startTime) / 1000));
        assertEquals(0, pw3.size());
    }

    @org.junit.jupiter.api.Test
    void union() { // B and A are don't empty
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        PowerSet powerSet2 = new PowerSet();
        for (int i = 5000; i < 25000; i++) {
            powerSet2.put(String.valueOf(i));
        }
        long startTime = System.currentTimeMillis (); // get the time start
        PowerSet pw3 = powerSet.union(powerSet2);
        long endTime = System.currentTimeMillis (); // get the time finish
        //System.out.println ("Время выполнения программы:" + (endTime-startTime) / 1000 + "с"  );
        assertEquals(1,((endTime-startTime) / 1000));
        assertEquals(25000, pw3.size());
    }

    @org.junit.jupiter.api.Test
    void union1() { // B is doesn't empty
        PowerSet powerSet = new PowerSet();
        PowerSet powerSet2 = new PowerSet();
        for (int i = 5000; i < 25000; i++) {
            powerSet2.put(String.valueOf(i));
        }
        long startTime = System.currentTimeMillis (); // get the time start
        PowerSet pw3 = powerSet.union(powerSet2);
        long endTime = System.currentTimeMillis (); // get the time finish
        //System.out.println ("Время выполнения программы:" + (endTime-startTime) / 1000 + "с"  );
        assertEquals(0,((endTime-startTime) / 1000));
        assertEquals(20000, pw3.size());
    }

    @org.junit.jupiter.api.Test
    void union2() { // A doesn't empty
        PowerSet powerSet = new PowerSet();
        for (int i = 5000; i < 25000; i++) {
            powerSet.put(String.valueOf(i));
        }
        PowerSet powerSet2 = new PowerSet();
        long startTime = System.currentTimeMillis (); // get the time start
        PowerSet pw3 = powerSet.union(powerSet2);
        long endTime = System.currentTimeMillis (); // get the time finish
        //System.out.println ("Время выполнения программы:" + (endTime-startTime) / 1000 + "с"  );
        assertEquals(0,((endTime-startTime) / 1000));
        assertEquals(20000, pw3.size());
    }

    @org.junit.jupiter.api.Test
    void difference() { //powerSet is doesn't full
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        PowerSet powerSet2 = new PowerSet();
        for (int i = 10000; i < 25000; i++) {
            powerSet2.put(String.valueOf(i));
        }
        long startTime = System.currentTimeMillis (); // get the time start
        PowerSet pw3 = powerSet.difference(powerSet2);
        long endTime = System.currentTimeMillis (); // get the time finish
        //System.out.println ("Время выполнения программы:" + (endTime-startTime) / 1000 + "с"  );
        assertEquals(1,((endTime-startTime) / 1000));
        assertEquals(10000, pw3.size());
    }

    @org.junit.jupiter.api.Test
    void difference2() { //powerSet is full
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        PowerSet powerSet2 = new PowerSet();
        for (int i = 0; i < 25000; i++) {
            powerSet2.put(String.valueOf(i));
        }
        long startTime = System.currentTimeMillis (); // get the time start
        PowerSet pw3 = powerSet.difference(powerSet2);
        long endTime = System.currentTimeMillis (); // get the time finish
        //System.out.println ("Время выполнения программы:" + (endTime-startTime) / 1000 + "с"  );
        assertEquals(1,((endTime-startTime) / 1000));
        assertEquals(0, pw3.size());
    }

    @org.junit.jupiter.api.Test
    void isSubset() { // B in A
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 25000; i++) {
            powerSet.put(String.valueOf(i));
        }
        PowerSet powerSet2 = new PowerSet();
        for (int i = 5000; i < 25000; i++) {
            powerSet2.put(String.valueOf(i));
        }
        long startTime = System.currentTimeMillis (); // get the time start
        boolean flagIsSubSet = powerSet.isSubset(powerSet2);
        long endTime = System.currentTimeMillis (); // get the time finish
        //System.out.println ("Время выполнения программы:" + (endTime-startTime) / 1000 + "с"  );
        assertEquals(2,((endTime-startTime) / 1000));
        assertTrue(flagIsSubSet);
    }

    @org.junit.jupiter.api.Test
    void isSubset2() { //B == A
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 25000; i++) {
            powerSet.put(String.valueOf(i));
        }
        PowerSet powerSet2 = new PowerSet();
        for (int i = 0; i < 25000; i++) {
            powerSet2.put(String.valueOf(i));
        }
        long startTime = System.currentTimeMillis (); // get the time start
        boolean flagIsSubSet = powerSet.isSubset(powerSet2);
        long endTime = System.currentTimeMillis (); // get the time finish
        //System.out.println ("During program execution:" + (endTime-startTime) / 1000 + "с"  );
        assertEquals(2,((endTime-startTime) / 1000));
        assertTrue(flagIsSubSet);
    }

    @org.junit.jupiter.api.Test
    void isSubset3() { //B A
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 25000; i++) {
            powerSet.put(String.valueOf(i));
        }
        PowerSet powerSet2 = new PowerSet();
        for (int i = 15000; i < 35000; i++) {
            powerSet2.put(String.valueOf(i));
        }
        long startTime = System.currentTimeMillis (); // get the time start
        boolean flagIsSubSet = powerSet.isSubset(powerSet2);
        long endTime = System.currentTimeMillis (); // get the time finish
        //System.out.println ("During program execution:" + (endTime-startTime) / 1000 + "с"  );
        assertEquals(2,((endTime-startTime) / 1000));
        assertFalse(flagIsSubSet);
    }
}