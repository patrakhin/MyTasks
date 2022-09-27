
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DequeTest <T> {

    @org.junit.jupiter.api.Test
    void addFront() {
        Deque deque = new Deque<>();
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);
        assertEquals(3, deque.size());
        assertEquals(3, deque.removeFront());
        assertEquals(1, deque.removeTail());
        deque.addTail(7);
        assertEquals(7, deque.removeFront());
        assertEquals(1, deque.size());
        assertEquals(2,deque.removeFront());
        assertNull(deque.removeTail());
        assertNull(deque.removeFront());

    }

    @org.junit.jupiter.api.Test
    void addTail() {  // add front and remove front
        Deque deque = new Deque<>();
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);
        assertEquals(3, deque.removeFront());
        assertEquals(2, deque.removeFront());
        assertEquals(1, deque.removeFront());
    }

    @org.junit.jupiter.api.Test
    void addTail2() {  //
        Deque deque = new Deque<>();
        deque.addTail(1);
        deque.addTail(2);
        deque.addTail(3);
        assertEquals(1, deque.removeTail());
        assertEquals(2, deque.removeTail());
        assertEquals(3, deque.removeTail());
    }


    @org.junit.jupiter.api.Test
    void removeFront() { // add front and remove tail
        Deque deque = new Deque<>();
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);
        assertEquals(1, deque.removeTail());
        assertEquals(2, deque.removeTail());
        deque.addFront(5);
        deque.addFront(4);
        assertEquals(3, deque.removeTail());
    }

    @org.junit.jupiter.api.Test
    void removeTail() {
        Deque deque = new Deque<>();
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);
        assertEquals(1, deque.removeTail());
        assertEquals(2, deque.removeTail());
        deque.addFront(5);
        deque.addFront(4);
        assertEquals(3, deque.removeTail());
    }

    @org.junit.jupiter.api.Test
    void removeTail2() {
        Deque deque = new Deque<>();
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);
        deque.addFront(4);
        deque.addFront(5);
        deque.addFront(6);
        deque.addFront(7);
        deque.addFront(8);
        deque.addFront(9);
        deque.addFront(10);
        deque.addFront(11);
        deque.addFront(12);
        deque.addFront(13);
        deque.addFront(14);
        deque.addFront(15);
        deque.addFront(16);
        deque.addFront(17);
        assertEquals(1, deque.removeTail());
        assertEquals(17, (int) deque.onePart.head.value);
        assertEquals(2, (int)  deque.onePart.tail.value);
        assertNull(deque.onePart.tail.next);
        assertNull(deque.onePart.head.prev);
        assertEquals(2, deque.removeTail());
        deque.addFront(100);
        deque.addFront(200);
        assertEquals(3, deque.removeTail());
    }

    @org.junit.jupiter.api.Test
    void size() {
    }
}
