import java.util.*;
public class Stack<T>
{
    public class Node
    {
        public T value;
        public Node next;
        public Node(T  valueIn, Node next)
        {
            this.value = valueIn;
            this.next = next;
        }
        public Node()
        {
        }
    }
    private Node head;

    public Stack()
    {
        super();
    }

    public int size()
    {
        int size = 0;
        while (head != null) {
            head = head.next;
            size ++;
        }

        return size;
    }

    public T pop()
    {
        if (head != null) {
            T result = head.value;
            head = head.next;
            return result;
        }

        return null;
    }

    public void push(T val)
    {
        Node newNode =  new Node(val, head);
        head = newNode;

    }

    public T peek()
    {
        if (head != null) {
            T result = head.value;
            return result;
        }

        return null;
    }
}

