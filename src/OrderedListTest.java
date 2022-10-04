import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OrderedListTest<T> {

    @org.junit.jupiter.api.Test
    void compare() {
        OrderedList orderedList = new OrderedList<T>(true);
        assertEquals(-1,orderedList.compare(2, 3));
        assertEquals(1,orderedList.compare(5000, -580));
        assertEquals(0,orderedList.compare(5000, 5000));
        assertEquals(-1,orderedList.compare(null, -580));
        assertEquals( 1,orderedList.compare(580, null));
        assertEquals( 0,orderedList.compare(null, null));
    }

    @org.junit.jupiter.api.Test
    void add() {
        OrderedList orderedList = new OrderedList<T>(false); //descending
        for (int i = -1000; i < 1001; i ++) {
            orderedList.add(i);
        }
        ArrayList<Node<T>> listNode = orderedList.getAll();
        for (int i = 0; i < listNode.size(); i++) {
            System.out.println(listNode.get(i).value);
        }
        assertEquals(2001, orderedList.count());

    }

    @org.junit.jupiter.api.Test
    void add1() {
        OrderedList orderedList = new OrderedList<T>(true); //ascending
        for (int i = -1000; i < 1001; i ++) {
            orderedList.add(i);
        }
        ArrayList<Node<T>> listNode = orderedList.getAll();
        for (int i = 0; i < listNode.size(); i++) {
            System.out.println(listNode.get(i).value);
        }
        assertEquals(2001, orderedList.count());

    }


    @org.junit.jupiter.api.Test
    void add2() {
        OrderedList orderedList = new OrderedList<T>(true); //ascending
        for (int i = -1000; i < 1001; i ++) {
            orderedList.add(i);
        }
        for (int i = -1000; i < 1001; i ++) {
            orderedList.add(i);
        }
        ArrayList<Node<T>> listNode = orderedList.getAll();
        for (int i = 0; i < listNode.size(); i++) {
            System.out.println(listNode.get(i).value);
        }
        assertEquals(4002, orderedList.count());

    }

    @org.junit.jupiter.api.Test
    void add3() { //add string
        OrderedList orderedList = new OrderedList<T>(false); //ascending
        String stringStart = "aaaa";
        String stringFinish = "aaab";
        orderedList.add(stringStart);
        orderedList.add(stringFinish);
        ArrayList<Node<T>> listNode = orderedList.getAll();
        for (int i = 0; i < listNode.size(); i++) {
            System.out.println(listNode.get(i).value);
        }
        assertEquals(2, orderedList.count());
    }

    @org.junit.jupiter.api.Test
    void add4() { //string
        OrderedList orderedList = new OrderedList<T>(true);
        String stringStart = " abba ";
        for (int j = 0; j < 25; j++) {
            for (char i = 'a'; i < 'z'; i++) {
                char[] ca = stringStart.toCharArray();
                ca[1] = i;
                stringStart = new String(ca);
                orderedList.add(stringStart);
            }
        }
        for (int j = 0; j < 25; j++) {
            for (char i = 'a'; i < 'y'; i++) {
                char[] ca = stringStart.toCharArray();
                ca[1] = i;
                stringStart = new String(ca);
                orderedList.delete(stringStart);
            }
        }
        for (int j = 0; j < 25; j++) {
            for (char i = 'a'; i < 'z'; i++) {
                char[] ca = stringStart.toCharArray();
                ca[3] = i;
                stringStart = new String(ca);
                orderedList.add(stringStart);
            }
        }
        ArrayList<Node<T>> listNode = orderedList.getAll();
        for (int i = 0; i < listNode.size(); i ++) {
            assertEquals(orderedList.getAll().get(i),(listNode.get(i)));
        }
        assertEquals(listNode.size(), orderedList.count());
        assertEquals(1250, orderedList.count());
    }

    @org.junit.jupiter.api.Test
    void add5() { //string
        OrderedList orderedList = new OrderedList<T>(true);
        orderedList.add("I am catching error");
        ArrayList<Node<T>> listNode = orderedList.getAll();
        for (int i = 0; i < listNode.size(); i++) {
            System.out.println(listNode.get(i).value);
        }
        assertEquals(1250, orderedList.count());
    }

    @org.junit.jupiter.api.Test
    void find2() {
        OrderedList orderedList = new OrderedList<T>(false);
        int a = 4;
        orderedList.add(1);
        orderedList.add(a);
        orderedList.add(6);
        orderedList.add(8);
        orderedList.add(2);
        orderedList.add(3);
        orderedList.add(7);
        orderedList.add(5);
        assertEquals(orderedList.getAll().get(4),orderedList.find(a));
        assertEquals(8, orderedList.count());
    }

    @org.junit.jupiter.api.Test
    void delete1() {
        OrderedList orderedList = new OrderedList<T>(true);
        for (int i = 0; i < 10000; i++) {
            orderedList.add(i);
        }
        for (int j = 0; j < 5000; j++) {
            orderedList.delete(j);
        }
        assertEquals(5000, orderedList.count());
        assertEquals(5000, orderedList.getAll().size());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        OrderedList orderedList = new OrderedList<T>(true);
        for (int i = 0; i < 10000; i++) {
            orderedList.add(i);
        }
        orderedList.clear(true);
        assertEquals(0, orderedList.count());
        assertEquals(0, orderedList.getAll().size());
    }

    @org.junit.jupiter.api.Test
    void count() {
        OrderedList orderedList = new OrderedList<T>(true);
        for (int i = 0; i < 10000; i++) {
            orderedList.add(i);
        }
        assertEquals(10000, orderedList.count());
        assertEquals(10000, orderedList.getAll().size());
    }

    @org.junit.jupiter.api.Test
    void getAll() {
        OrderedList orderedList = new OrderedList<T>(true);
        for (int i = 0; i < 10000; i++) {
            orderedList.add(i);
        }
        assertEquals(10000, orderedList.count());
        assertEquals(10000, orderedList.getAll().size());
        for (int j = 0; j < 5000; j++) {
            orderedList.delete(j);
        }
        assertEquals(5000, orderedList.count());
        assertEquals(5000, orderedList.getAll().size());
    }
}