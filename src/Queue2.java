import java.util.*;
public class Queue2 <T> {
    public Stack_2 stack1;
    public Stack_2 stack2;
    public int count;

    public Queue2 () {
        stack1 = new Stack_2<>();
        stack2 = new Stack_2<>();
    }
    public void enqueue (T val) { //push(enqueue) into stack1
        this.stack1.push(val);
        count ++;
    }
    public T dequeue () {
        T temp;
        int sizeStack1 = stack1.size();
        for (int i = 0; i < sizeStack1; i++) {
            stack2.push(stack1.pop());
        }
        temp = (T) stack2.pop();
        count --;
        return temp;
    }
    public int size () {
        return count;
    }
}

class Stack_2<T>
{
    public Node head;
    public Node tail;
    public int count;

    public Stack_2()
    {
        head = null;
        tail = null;
        count = 0;
    }
    public void addInHead(Node _item)
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
        Node current = head;
        while (current != null) {
            current = current.next;
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
        addInHead(new Node<>(val));
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
