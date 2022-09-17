import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class LinkedList2Test {

    @org.junit.jupiter.api.Test
    void find() { // list is empty  check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        int count = doublyLink.count();
        int expected = 0;
        assertNull(doublyLink.find(3)); //check head  res is null - list is empty
        assertEquals(expected, count); // count =  0
        assertNull(doublyLink.tail); // tail - null
    }

    @org.junit.jupiter.api.Test
    void find2() { // list contains a many elements   check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        int aa = 5;
        int ba = 0;
        int ca = 1;
        int da = 1;
        int ea = 1;
        int fa = 1;
        int ga = 2;
        Node a = new Node(aa);
        Node b = new Node(ba);
        Node c = new Node(ca);
        Node d = new Node(da);
        Node e = new Node(ea);
        Node f = new Node(fa);
        Node g = new Node(ga);
        doublyLink.addInTail(a);
        doublyLink.addInTail(b);
        doublyLink.addInTail(c);
        doublyLink.addInTail(d);
        doublyLink.addInTail(e);
        doublyLink.addInTail(f);
        doublyLink.addInTail(g);
        assertNull(doublyLink.find(3)); //check head  res is null - list haven't 3
        assertEquals(a, doublyLink.find(5)); // node a
        assertEquals(a, doublyLink.head); // node a
        assertEquals(g, doublyLink.tail); // node g
        assertNull(doublyLink.head.prev); // null
        int expected = 7;
        assertEquals(expected, doublyLink.count); // count =  7
    }

    @org.junit.jupiter.api.Test
    void find3() { // list contains a one element   check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        int aa = 5;
        Node a = new Node(aa);
        doublyLink.addInTail(a);
        assertNull(doublyLink.find(3)); //check head  res is null - list haven't 3
        assertEquals(a, doublyLink.find(5)); // node a
        assertEquals(a, doublyLink.head); // node a
        assertEquals(a, doublyLink.tail); // node a
        assertNull(doublyLink.head.prev); // null
        assertEquals(aa, doublyLink.head.value); // node a
        int expected = 1;
        assertEquals(expected, doublyLink.count); // count =  1
    }

    @org.junit.jupiter.api.Test
    void findAll() { // list is empty  check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        ArrayList<Node> expected = new ArrayList<>();
        assertEquals(expected, doublyLink.findAll(3)); //check head  res is null - list haven't 3
        assertNull(doublyLink.head); // null
        assertNull(doublyLink.tail); // null
        assertEquals(0,doublyLink.count); // count =  0
    }
    @org.junit.jupiter.api.Test
    void findAll2() { // list contains a many elements   check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        int aa = 5;
        int ba = 0;
        int ca = 1;
        int da = 1;
        int ea = 1;
        int fa = 1;
        int ga = 2;
        Node a = new Node(aa);
        Node b = new Node(ba);
        Node c = new Node(ca);
        Node d = new Node(da);
        Node e = new Node(ea);
        Node f = new Node(fa);
        Node g = new Node(ga);
        doublyLink.addInTail(a);
        doublyLink.addInTail(b);
        doublyLink.addInTail(c);
        doublyLink.addInTail(d);
        doublyLink.addInTail(e);
        doublyLink.addInTail(f);
        doublyLink.addInTail(g);
        ArrayList<Node> expected = new ArrayList<>();
        assertEquals(expected, doublyLink.findAll(3)); //check head  res is null - list haven't 3
        assertEquals(4, doublyLink.findAll(1).size()); // at list have 4 element equals 1
        assertEquals(1, doublyLink.findAll(0).size()); // at list have 4 element equals 1
        assertEquals(a, doublyLink.head); // node a
        assertEquals(g, doublyLink.tail); // node g
        assertEquals(7,doublyLink.count); // count =  7
    }

    @org.junit.jupiter.api.Test
    void findAll3() { // list contains a one element   check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        int aa = 5;
        Node a = new Node(aa);
        doublyLink.addInTail(a);
        ArrayList<Node> expected = new ArrayList<>();
        assertEquals(expected, doublyLink.findAll(3)); //check head  res is null - list haven't 3
        assertEquals(1, doublyLink.findAll(aa).size()); // at list have 1 element equals 5
        assertEquals(aa, doublyLink.head.value); // 5
        assertEquals(a, doublyLink.head); // node a
        assertEquals(a, doublyLink.tail); // node a
        assertEquals(1,doublyLink.count); // count =  1
    }

    @org.junit.jupiter.api.Test
    void remove() { // list is empty  check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        assertFalse(doublyLink.remove(3)); //check head  res is false - list haven't 3
        assertNull(doublyLink.head); //check head  res is null - list haven't 3
        assertNull(doublyLink.tail); // null
        assertEquals(0,doublyLink.count); // count =  0
    }
    @org.junit.jupiter.api.Test
    void remove2() { // list contains a many elements   check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        int aa = 5;
        int ba = 0;
        int ca = 1;
        int da = 3;
        int ea = 1;
        int fa = 1;
        int ga = 2;
        Node a = new Node(aa);
        Node b = new Node(ba);
        Node c = new Node(ca);
        Node d = new Node(da);
        Node e = new Node(ea);
        Node f = new Node(fa);
        Node g = new Node(ga);
        doublyLink.addInTail(a);
        doublyLink.addInTail(b);
        doublyLink.addInTail(c);
        doublyLink.addInTail(d);
        doublyLink.addInTail(e);
        doublyLink.addInTail(f);
        doublyLink.addInTail(g);
        assertTrue(doublyLink.remove(5)); // true - list have a value 5, and it is head
        assertTrue(doublyLink.remove(2)); // true - list have a value 2, and it is tail
        assertEquals(f,doublyLink.tail); //tail f - 1
        assertTrue(doublyLink.remove(3)); // true - list have a value 1, and it is the middle
        assertEquals(f, doublyLink.tail); // node f - 1
        assertEquals(4,doublyLink.count); // count =  4
    }
    @org.junit.jupiter.api.Test
    void remove3() { // list contains a one element   check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        int aa = 5;
        Node a = new Node(aa);
        doublyLink.addInTail(a);
        assertFalse(doublyLink.remove(10)); // false
        assertTrue(doublyLink.remove(5)); // true - list have a value 5
        assertNull(doublyLink.tail); //tail
        assertFalse(doublyLink.remove(2)); // false - list haven't a value 2
        assertEquals(0,doublyLink.count); // count =  0
    }

    @org.junit.jupiter.api.Test
    void removeAll() { // list is empty  check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        doublyLink.removeAll(3);
        LinkedList2 expected = new LinkedList2();
        assertEquals(expected.count, doublyLink.count);
        assertNull(doublyLink.head); //check head  res is null - list haven't 3
        assertNull(doublyLink.tail); // null
        assertEquals(0,doublyLink.count); // count =  0
    }
    @org.junit.jupiter.api.Test
    void removeAll2() { // list contains a many elements   check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        int aa = 5;
        int ba = 1;
        int ca = 1;
        int da = 5;
        int ea = 1;
        int fa = 1;
        int ga = 5;
        Node a = new Node(aa);
        Node b = new Node(ba);
        Node c = new Node(ca);
        Node d = new Node(da);
        Node e = new Node(ea);
        Node f = new Node(fa);
        Node g = new Node(ga);
        doublyLink.addInTail(a);
        doublyLink.addInTail(b);
        doublyLink.addInTail(c);
        doublyLink.addInTail(d);
        doublyLink.addInTail(e);
        doublyLink.addInTail(f);
        doublyLink.addInTail(g);
        doublyLink.removeAll(5);
        int expected = 4;
        assertEquals(expected, doublyLink.count);
        assertEquals(b, doublyLink.head); //check head
        assertEquals(f, doublyLink.tail); //check tail
        assertNull(doublyLink.head.prev); // null;
    }

    @org.junit.jupiter.api.Test
    void removeAll2_1() { // list contains a many elements   check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        int aa = 1;
        int ba = 1;
        int ca = 1;
        int da = 5;
        int ea = 1;
        int fa = 1;
        int ga = 1;
        Node a = new Node(aa);
        Node b = new Node(ba);
        Node c = new Node(ca);
        Node d = new Node(da);
        Node e = new Node(ea);
        Node f = new Node(fa);
        Node g = new Node(ga);
        doublyLink.addInTail(a);
        doublyLink.addInTail(b);
        doublyLink.addInTail(c);
        doublyLink.addInTail(d);
        doublyLink.addInTail(e);
        doublyLink.addInTail(f);
        doublyLink.addInTail(g);
        doublyLink.removeAll(5);
        int expected = 6;
        assertEquals(expected, doublyLink.count);
        assertEquals(a, doublyLink.head); //check head
        assertEquals(g, doublyLink.tail); //check tail
        assertNull(doublyLink.head.prev); // null;
    }

    @org.junit.jupiter.api.Test
    void removeAll3() { // list contains a one element   check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        int aa = 5;
        Node a = new Node(aa);
        doublyLink.addInTail(a);
        doublyLink.removeAll(3);
        int expected = 1;
        assertEquals(expected, doublyLink.count);
        assertEquals(a, doublyLink.head); //check head
        assertEquals(a, doublyLink.tail); //check tail
        assertNull(doublyLink.head.prev); // null;
        doublyLink.removeAll(5);
        int expected2 = 0;
        assertEquals(expected2, doublyLink.count);
        assertNull(doublyLink.head); // null
        assertNull(doublyLink.tail); // null
    }

    @org.junit.jupiter.api.Test
    void clear() {  // list is empty  check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        doublyLink.clear();
        LinkedList2 expected = new LinkedList2();
        assertEquals(expected.count, doublyLink.count);
        assertNull(doublyLink.head); //null
        assertNull(doublyLink.tail); // null
    }
    @org.junit.jupiter.api.Test
    void clear2() { // list contains a many elements   check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        int aa = 1;
        int ba = 1;
        int ca = 1;
        int da = 5;
        int ea = 1;
        int fa = 1;
        int ga = 1;
        Node a = new Node(aa);
        Node b = new Node(ba);
        Node c = new Node(ca);
        Node d = new Node(da);
        Node e = new Node(ea);
        Node f = new Node(fa);
        Node g = new Node(ga);
        doublyLink.addInTail(a);
        doublyLink.addInTail(b);
        doublyLink.addInTail(c);
        doublyLink.addInTail(d);
        doublyLink.addInTail(e);
        doublyLink.addInTail(f);
        doublyLink.addInTail(g);
        doublyLink.clear();
        int expected = 0;
        assertEquals(expected, doublyLink.count);
        assertNull(doublyLink.head); //null;
        assertNull(doublyLink.tail); //null;
    }
    @org.junit.jupiter.api.Test
    void clear3() { // list contains a one element   check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        int aa = 5;
        Node a = new Node(aa);
        doublyLink.addInTail(a);
        doublyLink.clear();
        int expected = 0;
        assertEquals(expected, doublyLink.count);
        assertNull(doublyLink.head); //null;
        assertNull(doublyLink.tail); //null;
    }

    @org.junit.jupiter.api.Test
    void insertAfter() { // list is empty  check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        int aa = 5;
        Node a = new Node(aa);
        doublyLink.insertAfter(null,a);
        int count = 1;
        assertEquals(count, doublyLink.count);
        assertEquals(a, doublyLink.head);
        assertEquals(a, doublyLink.tail);
    }
    @org.junit.jupiter.api.Test
    void insertAfter2() { // list contains a many elements   check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        int aa = 1;
        int ba = 2;
        int ca = 3;
        int da = 4;
        int ea = 5;
        int fa = 6;
        int ga = 7;
        int sa = 9;
        Node a = new Node(aa);
        Node b = new Node(ba);
        Node c = new Node(ca);
        Node d = new Node(da);
        Node e = new Node(ea);
        Node f = new Node(fa);
        Node g = new Node(ga);
        Node s = new Node(sa);
        doublyLink.addInTail(a);
        doublyLink.addInTail(b);
        doublyLink.addInTail(c);
        doublyLink.addInTail(d);
        doublyLink.addInTail(e);
        doublyLink.addInTail(f);
        doublyLink.addInTail(g);
        doublyLink.insertAfter(a,s); // insert after head
        int count = 8;
        assertEquals(count, doublyLink.count);
        assertEquals(a, doublyLink.head);
        assertEquals(g, doublyLink.tail);
        assertEquals(a, s.prev);
    }
    @org.junit.jupiter.api.Test
    void insertAfter2_1() { // list contains a many elements   check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        int aa = 1;
        int ba = 2;
        int ga = 7;
        int sa = 9;
        Node a = new Node(aa);
        Node b = new Node(ba);
        Node g = new Node(ga);
        Node s = new Node(sa);
        doublyLink.addInTail(a);
        doublyLink.addInTail(b);
        doublyLink.addInTail(g);
        doublyLink.insertAfter(g,s); // insert after tail
        int count = 4;
        assertEquals(count, doublyLink.count);
        assertEquals(a, doublyLink.head);
        assertEquals(s, doublyLink.tail);
        assertEquals(g, s.prev);
    }

    @org.junit.jupiter.api.Test
    void insertAfter2_2() { // list contains a many elements   check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        int aa = 1;
        int ba = 2;
        int ga = 7;
        int sa = 9;
        Node a = new Node(aa);
        Node b = new Node(ba);
        Node g = new Node(ga);
        Node nodeInsert = new Node(sa);
        doublyLink.addInTail(a);
        doublyLink.addInTail(b);
        doublyLink.addInTail(g);
        doublyLink.insertAfter(b, nodeInsert); // insert any place
        int count = 4;
        assertEquals(count, doublyLink.count);
        assertEquals(b, nodeInsert.prev);
        assertEquals(nodeInsert, g.prev);
        assertEquals(a, b.prev);
    }
    @org.junit.jupiter.api.Test
    void insertAfter3() { // list contains a one element   check head, tail, prev, value, count
        LinkedList2 doublyLink = new LinkedList2();
        int aa = 5;
        Node a = new Node(aa);
        doublyLink.addInTail(a);
        int ba = 7;
        Node b = new Node(ba);
        doublyLink.insertAfter(a,b);
        int count = 2;
        assertEquals(count, doublyLink.count);
        assertEquals(a, doublyLink.head);
        assertEquals(b, doublyLink.tail);
        assertEquals(a, b.prev);
    }
}