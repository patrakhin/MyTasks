import java.util.*;
public class Stack<T>
{
    public Node head;
    public Node tail;
    public int count;
    private Node cur2;

    public Stack()
    {
        head = null;
        tail = null;
        count = 0;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
        this.count += 1;
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
        Node currentNode = head;
        Node previousNode = currentNode;
        if (currentNode == null) {
            return null;// if stack is empty
        }
        while (currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        T temp = (T)tail.value;
        count --;
        if (count == 0) {
            head = null;
            tail = null;
            return temp;
        }
        previousNode.next = null;
        tail = previousNode;
        return temp;
    }

    public void push(T val)
    {
        addInTail(new Node<>(val));
    }

    public T peek()
    {
        if (tail != null) {
            T result = (T) tail.value;
            return result;
        }
        return null; // if stack is empty
    }
}
class Node<T>
{
    public T value;
    public Node next;
    public Node(T  valueIn)
    {
        value = valueIn;
        next = null;
    }
}