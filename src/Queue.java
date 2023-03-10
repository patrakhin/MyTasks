import java.util.*;

public class Queue<T>
{
    public Node head;
    public Node tail;
    public int count;

    public Queue()
    {
        head = null;
        tail = null;
        count = 0;
        // activation inside story queue
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
        }
        count ++;

    }
    public void enqueue(T item)
    {
        addInHead(new Node<>(item));
        // insert to tail
    }

    public T dequeue()
    {
        Node current = head;
        //if list is empty - return null

        //if value into tail (ever delete tail!!!) and list have more value
        if (count > 1) {
            T temp = (T)tail.value;
            count --;
            tail.prev.next = null;
            tail = tail.prev;
            return temp;
        }
        //if value is one and list size 1
        if (count == 1) {
            T temp = (T)head.value;
            count --;
            head = null;
            tail = null;
            return temp;
        }
        // out head queue
        return null; // null if queue is empty
    }

    public int size()
    {
        int size = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            size ++;
        }
        return size;// size queue
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