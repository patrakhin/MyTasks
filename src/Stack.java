import java.util.*;

public class Stack<T>
{
    public Node head;
    public Node tail;
    public int count;

    public Stack()
    {
        head = null;
        tail = null;
        count = 0;
    }
    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
            this.tail = _item;
        } else {
            this.head.prev = _item;
            _item.next = head;
            this.head = _item;
            //_item.next = tail;
        }
        count ++;

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
        Node current = head;
        //if list is empty - return null

        //if value into head and list have more value
        if (count > 1) {
            T temp = (T)head.value;
            count --;
            current.next.prev = null;
            head = current.next;
            return temp;
        }
        //if value into head and list size 1
        if (count == 1) {
            T temp = (T)head.value;
            count --;
            head = null;
            tail = null;
            return temp;
        }
        return null;
    }

    public void push(T val)
    {
        addInTail(new Node<>(val));
    }

    public T peek()
    {
        if (head != null) {
            return (T) head.value;
        }
        return null; // if stack is empty
    }
}

class Node<T>
{
    public T value;
    public Node next;
    public Node prev;

    public Node(T val)
    {
        value = val;
        next = null;
        prev = null;
    }
}