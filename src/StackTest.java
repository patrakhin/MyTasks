import static org.junit.jupiter.api.Assertions.*;

class StackTest<T> {
    @org.junit.jupiter.api.Test
    void size() {
        Stack stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        int actual = stack.size();
        int expected= 3;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void pop() {
        Stack stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        T actual = (T) stack.pop();
        int expected= 3;
        assertEquals(expected, actual);
        T actual2 = (T) stack.pop();
        int expected2= 2;
        assertEquals(expected2, actual2);
        T actual3 = (T) stack.pop();
        int expected3= 1;
        assertEquals(expected3, actual3);
        assertNull(stack.pop());
    }

    @org.junit.jupiter.api.Test
    void push() {
        Stack stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int actual = stack.size();
        int expected = 3;
        assertEquals(expected, actual);
        T act = (T) stack.tail.value;
        int exp= 1;
        assertEquals(exp, act);
    }

    @org.junit.jupiter.api.Test
    void push_1() {
        Stack stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int actual = stack.size();
        int expected = 3;
        assertEquals(expected, actual);
        T act = (T) stack.head.value;
        int exp= 3;
        assertEquals(exp, act);
    }

    @org.junit.jupiter.api.Test
    void peek() {
        Stack stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        T actual = (T) stack.peek();
        int expected = 3;
        assertEquals(expected, actual);

    }
}