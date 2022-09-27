
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DequeTest <T> {

    @org.junit.jupiter.api.Test
    void addFront() { //list addFront/remTail
        Deque deque = new Deque<>();
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);
        assertEquals(1, deque.removeTail());
        assertEquals(2, deque.removeTail());
        assertEquals(3, deque.removeTail());
        assertEquals(0, deque.onePart.count); // count list
        assertEquals(0, deque.secondPart.count); // count array
        assertEquals(0, deque.size());
    }

    @org.junit.jupiter.api.Test
    void addFront1() { //list addFront/remTail
        Deque deque = new Deque<>();
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);
        assertEquals(1, deque.removeTail());
        assertEquals(2, deque.removeTail());
        deque.addFront(4);
        assertEquals(4,(int) deque.onePart.tail.value);
        assertEquals(3,(int) deque.onePart.head.value);
        deque.addFront(5);
        assertEquals(3, deque.removeTail());
        // as stack
        assertEquals(5, deque.removeFront());
        assertEquals(4, deque.removeFront());

    }

    @org.junit.jupiter.api.Test
    void addFront2() { //list addTail/remFront
        Deque deque = new Deque<>();
        deque.addTail(1);
        deque.addTail(2);
        deque.addTail(3);
        assertEquals(1, deque.removeFront());
        assertEquals(2, deque.removeFront());
        deque.addTail(4);
        deque.addFront(9);
        assertEquals(9, deque.removeFront());
        assertEquals(3, deque.removeFront());
        assertEquals(4, deque.removeFront());
    }

    @org.junit.jupiter.api.Test
    void addFront3() { //list addTail/remFront
        Deque deque = new Deque<>();
        deque.addTail(1);
        deque.addTail(2);
        deque.addTail(3);
        deque.addFront(9);
        deque.addFront(8);
        deque.addFront(7);
        assertEquals(3, deque.removeTail());
        assertEquals(2, deque.removeTail());
        deque.addFront(4);
        assertEquals(4,(int) deque.onePart.tail.value);
        assertEquals(1,(int) deque.onePart.head.value);
        deque.addFront(5);
        assertEquals(1, deque.removeTail());
        // as stack
        assertEquals(5, deque.removeFront());
        assertEquals(4, deque.removeFront());
        assertEquals(3, deque.onePart.count); // count list
        assertEquals(3, deque.secondPart.count); // count array

    }

}

