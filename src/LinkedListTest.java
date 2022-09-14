import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @org.junit.jupiter.api.Test
    void addInTail1 () { //
        int a = 128;
        int b = 128;
        int c = 128;
        int d = 128;
        int e = 128;
        int f = 128;
        int g = 12;
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(a));
        s_list.addInTail(new Node(b));
        s_list.addInTail(new Node(c));
        s_list.addInTail(new Node(d));
        s_list.addInTail(new Node(e));
        s_list.addInTail(new Node(f));
        s_list.addInTail(new Node(g));
        s_list.removeAll(12);
        String expected = "[128, 128, 128, 128, 128, 128]";
        assertEquals(expected, s_list.toString());
    }

    @org.junit.jupiter.api.Test
    void addInTail2 () { //
        int a = 128;
        int b = 128;
        int c = 128;
        int d = 12;
        int e = 12;
        int f = 12;
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(a));
        s_list.addInTail(new Node(b));
        s_list.addInTail(new Node(c));
        s_list.addInTail(new Node(d));
        s_list.addInTail(new Node(e));
        s_list.addInTail(new Node(f));
        s_list.removeAll(12);
        String expected = "[128, 128, 128]";
        assertEquals(expected, s_list.toString());
    }

    @org.junit.jupiter.api.Test
    void addInTail3 () { //
        int a = 128;
        int b = 128;
        int c = 128;
        int d = 128;
        int e = 128;
        int f = 12;
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(a));
        s_list.addInTail(new Node(b));
        s_list.addInTail(new Node(c));
        s_list.addInTail(new Node(d));
        s_list.addInTail(new Node(e));
        s_list.addInTail(new Node(f));
        s_list.removeAll(12);
        String expected = "[128, 128, 128, 128, 128]";
        assertEquals(expected, s_list.toString());
    }

    @org.junit.jupiter.api.Test
    void addInTail4 () { //
        int a = 12;
        int b = 128;
        int c = 128;
        int d = 128;
        int e = 128;
        int f = 128;
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(a));
        s_list.addInTail(new Node(b));
        s_list.addInTail(new Node(c));
        s_list.addInTail(new Node(d));
        s_list.addInTail(new Node(e));
        s_list.addInTail(new Node(f));
        s_list.removeAll(12);
        String expected = "[128, 128, 128, 128, 128]";
        assertEquals(expected, s_list.toString());
    }

    @org.junit.jupiter.api.Test
    void addInTail5 () { //
        int a = 12;
        int b = 12;
        int c = 128;
        int d = 12;
        int e = 128;
        int f = 128;
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(a));
        s_list.addInTail(new Node(b));
        s_list.addInTail(new Node(c));
        s_list.addInTail(new Node(d));
        s_list.addInTail(new Node(e));
        s_list.addInTail(new Node(f));
        s_list.removeAll(12);
        String expected = "[128, 128, 128]";
        assertEquals(expected, s_list.toString());
    }

    @org.junit.jupiter.api.Test
    void addInTail6 () { //
        int a = 128;
        int b = 128;
        int c = 128;
        int d = 12;
        int e = 128;
        int f = 128;
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(a));
        s_list.addInTail(new Node(b));
        s_list.addInTail(new Node(c));
        s_list.addInTail(new Node(d));
        s_list.addInTail(new Node(e));
        s_list.addInTail(new Node(f));
        s_list.removeAll(12);
        String expected = "[128, 128, 128, 128, 128]";
        assertEquals(expected, s_list.toString());
    }

    @org.junit.jupiter.api.Test
    void addInTail7 () { //
        int a = 128;
        int b = 128;
        int c = 128;
        int d = 128;
        int e = 128;
        int f = 128;
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(a));
        s_list.addInTail(new Node(b));
        s_list.addInTail(new Node(c));
        s_list.addInTail(new Node(d));
        s_list.addInTail(new Node(e));
        s_list.addInTail(new Node(f));
        s_list.removeAll(12);
        String expected = "[128, 128, 128, 128, 128, 128]";
        assertEquals(expected, s_list.toString());
    }

    @org.junit.jupiter.api.Test
    void addInTail8 () { // lis is empty
        LinkedList s_list = new LinkedList();
        s_list.removeAll(12);
        String expected = "[]";
        assertEquals(expected, s_list.toString());
    }

    @org.junit.jupiter.api.Test
    void addInTail9 () { // lis is one
        int a = 12;
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(a));
        s_list.removeAll(12);
        String expected = "[]";
        assertEquals(expected, s_list.toString());
    }
}