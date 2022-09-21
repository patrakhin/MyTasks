import static org.junit.jupiter.api.Assertions.*;
class DynArrayTest {

    @org.junit.jupiter.api.Test
    <T>
    void makeArray() {
    }

    @org.junit.jupiter.api.Test
    void getItem() {
        DynArray <Integer> prototype = new DynArray<>(Integer.class);
        prototype.append(1);
        assertEquals(prototype.getItem(0),1);
        assertNull(prototype.getItem(1));
    }

    @org.junit.jupiter.api.Test
    void append() {
        DynArray <Integer> prototype = new DynArray<>(Integer.class);
        prototype.append(1);
        prototype.append(2);
        prototype.append(3);
        prototype.append(4);
        prototype.append(5);
        prototype.append(6);
        prototype.append(7);
        prototype.append(8);
        prototype.append(9);
        prototype.append(10);
        prototype.append(11);
        prototype.append(12);
        prototype.append(13);
        prototype.append(14);
        prototype.append(15);
        prototype.append(16);
        prototype.append(17);
        prototype.append(18);

    }

    @org.junit.jupiter.api.Test
    void insert() { // size buf don't exceed
        DynArray <Integer> prototype = new DynArray<>(Integer.class);
        prototype.append(1);
        prototype.append(2);
        prototype.append(3);
        prototype.append(4);
        prototype.append(5);
        prototype.append(6);
        prototype.append(7);
        prototype.append(8);
        prototype.append(9);
        prototype.append(10);
        prototype.append(11);
        prototype.append(12);
        prototype.append(13);
        prototype.append(14);
        prototype.append(15);
        prototype.insert(20, 15);
        assertEquals(20,prototype.getItem(15));
        int actual = prototype.array.length;
        assertEquals(16,actual);
    }


    @org.junit.jupiter.api.Test
    void insert2() { // size buf has exceeded
        DynArray <Integer> prototype = new DynArray<>(Integer.class);
        prototype.append(1);
        prototype.append(2);
        prototype.append(3);
        prototype.append(4);
        prototype.append(5);
        prototype.append(6);
        prototype.append(7);
        prototype.append(8);
        prototype.append(9);
        prototype.append(10);
        prototype.append(11);
        prototype.append(12);
        prototype.append(13);
        prototype.append(14);
        prototype.append(15);
        prototype.append(16);
        prototype.append(17);
        prototype.insert(20, 18);
        assertNull(prototype.getItem(18));
        int actual = prototype.array.length;
        assertEquals(32,actual);

    }

    @org.junit.jupiter.api.Test
    void insert3() {  // insert item into invalid place
        DynArray <Integer> prototype = new DynArray<>(Integer.class);
        prototype.append(1);
        prototype.insert(20, 18);
        int actual = prototype.count;
        assertEquals(1,actual);

    }

    @org.junit.jupiter.api.Test
    void insert4() {  // insert item into tail
        DynArray <Integer> prototype = new DynArray<>(Integer.class);
        prototype.append(1);
        prototype.append(2);
        prototype.append(3);
        prototype.append(4);
        prototype.append(5);
        prototype.append(6);
        prototype.append(7);
        prototype.append(8);
        prototype.append(9);
        prototype.append(10);
        prototype.append(11);
        prototype.append(12);
        prototype.append(13);
        prototype.append(14);
        prototype.append(15);
        prototype.append(16);
        prototype.insert(20, 16);
        assertEquals(20,prototype.getItem(16));
        int actual = prototype.array.length;
        assertEquals(32,actual);

    }

    @org.junit.jupiter.api.Test
    void remove() { //remove 1 of 1 block of memory = 16
        DynArray <Integer> prototype = new DynArray<>(Integer.class);
        prototype.append(1);
        prototype.remove(0);
        int actual = prototype.array.length;
        assertEquals(16,actual);
    }

    @org.junit.jupiter.api.Test
    void remove2() { //remove 1 of 16 block of memory = 16
        DynArray <Integer> prototype = new DynArray<>(Integer.class);
        prototype.append(1);
        prototype.append(2);
        prototype.append(3);
        prototype.append(4);
        prototype.append(5);
        prototype.append(6);
        prototype.append(7);
        prototype.append(8);
        prototype.append(9);
        prototype.append(10);
        prototype.append(11);
        prototype.append(12);
        prototype.append(13);
        prototype.append(14);
        prototype.append(15);
        prototype.append(16);
        prototype.remove(11);
        int actual = prototype.count;
        assertEquals(15,actual);
        int sizeArray = prototype.array.length;
        assertEquals(16,sizeArray);
    }

    @org.junit.jupiter.api.Test
    void remove3() { //remove 1 of 17 block of memory = 32
        DynArray <Integer> prototype = new DynArray<>(Integer.class);
        prototype.append(1);
        prototype.append(2);
        prototype.append(3);
        prototype.append(4);
        prototype.append(5);
        prototype.append(6);
        prototype.append(7);
        prototype.append(8);
        prototype.append(9);
        prototype.append(10);
        prototype.append(11);
        prototype.append(12);
        prototype.append(13);
        prototype.append(14);
        prototype.append(15);
        prototype.append(16);
        prototype.append(17);
        prototype.remove(9);
        int actual = prototype.count;
        assertEquals(16,actual);
        int sizeArray = prototype.array.length;
        assertEquals(21,sizeArray);

    }

    @org.junit.jupiter.api.Test
    void remove4() { //remove 1 array size 16
        DynArray <Integer> prototype = new DynArray<>(Integer.class);
        prototype.append(1);
        prototype.append(2);
        prototype.append(3);
        prototype.append(4);
        prototype.append(5);
        prototype.append(6);
        prototype.append(7);
        prototype.append(8);
        prototype.append(9);
        prototype.append(10);
        prototype.append(11);
        prototype.append(12);
        prototype.append(13);
        prototype.append(14);
        prototype.append(15);
        prototype.append(16);
        prototype.remove(15);
        int actual = prototype.count;
        assertEquals(15,actual);
        int sizeArray = prototype.array.length;
        assertEquals(16,sizeArray);
    }

    @org.junit.jupiter.api.Test
    void remove4_1() { //remove 1 array size 23
        DynArray <Integer> prototype = new DynArray<>(Integer.class);
        prototype.append(1);
        prototype.append(2);
        prototype.append(3);
        prototype.append(4);
        prototype.append(5);
        prototype.append(6);
        prototype.append(7);
        prototype.append(8);
        prototype.append(9);
        prototype.append(10);
        prototype.append(11);
        prototype.append(12);
        prototype.append(13);
        prototype.append(14);
        prototype.append(15);
        prototype.append(16);
        prototype.append(17);
        prototype.append(18);
        prototype.append(19);
        prototype.append(20);
        prototype.append(21);
        prototype.append(22);
        prototype.append(23);
        prototype.remove(22);
        int actual = prototype.count;
        assertEquals(22,actual);
        int sizeArray = prototype.array.length;
        assertEquals(32,sizeArray);
    }

    @org.junit.jupiter.api.Test
    void remove5() { //remove (0) in don't empty array size 16 cut head
        DynArray <Integer> prototype = new DynArray<>(Integer.class);
        prototype.append(1);
        prototype.append(2);
        prototype.append(3);
        prototype.append(4);
        prototype.append(5);
        prototype.append(6);
        prototype.append(7);
        prototype.append(8);
        prototype.append(9);
        prototype.append(10);
        prototype.append(11);
        prototype.append(12);
        prototype.append(13);
        prototype.append(14);
        prototype.append(15);
        prototype.append(16);
        prototype.append(20);
        prototype.remove(0);
        int actual = prototype.count;
        assertEquals(16,actual);
        int sizeArray = prototype.array.length;
        assertEquals(21,sizeArray);
    }

    @org.junit.jupiter.api.Test
    void remove6() { //remove (16) cut tail
        DynArray <Integer> prototype = new DynArray<>(Integer.class);
        prototype.append(1);
        prototype.append(2);
        prototype.append(3);
        prototype.append(4);
        prototype.append(5);
        prototype.append(6);
        prototype.append(7);
        prototype.append(8);
        prototype.append(9);
        prototype.append(10);
        prototype.append(11);
        prototype.append(12);
        prototype.append(13);
        prototype.append(14);
        prototype.append(15);
        prototype.append(16);
        prototype.append(20);
        prototype.remove(16);
        int actual = prototype.count;
        assertEquals(16,actual);
        int sizeArray = prototype.array.length;
        assertEquals(21,sizeArray);
    }

    @org.junit.jupiter.api.Test
    void remove7() { //remove (16) in don't empty array size 16 cut any place
        DynArray <Integer> prototype = new DynArray<>(Integer.class);
        prototype.append(1);
        prototype.append(2);
        prototype.append(3);
        prototype.append(4);
        prototype.append(5);
        prototype.append(6);
        prototype.append(7);
        prototype.append(8);
        prototype.append(9);
        prototype.append(10);
        prototype.append(11);
        prototype.append(12);
        prototype.append(13);
        prototype.append(14);
        prototype.append(15);
        prototype.append(16);
        prototype.append(20);
        prototype.remove(9);
        int actual = prototype.count;
        assertEquals(16,actual);
        int sizeArray = prototype.array.length;
        assertEquals(21,sizeArray);
    }

    @org.junit.jupiter.api.Test
    void remove8() { //remove (22)
        DynArray <Integer> prototype = new DynArray<>(Integer.class);
        prototype.append(1);
        prototype.append(2);
        prototype.append(3);
        prototype.append(4);
        prototype.append(5);
        prototype.append(6);
        prototype.append(7);
        prototype.append(8);
        prototype.append(9);
        prototype.append(10);
        prototype.append(11);
        prototype.append(12);
        prototype.append(13);
        prototype.append(14);
        prototype.append(15);
        prototype.append(16);
        prototype.append(17);
        prototype.append(18);
        prototype.append(19);
        prototype.append(20);
        prototype.append(21);
        prototype.append(22);
        prototype.remove(15);
        int actual = prototype.count;
        assertEquals(21,actual);
        int sizeArray = prototype.array.length;
        assertEquals(21,sizeArray);
    }
}