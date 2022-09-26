import java.lang.reflect.Array;
import java.util.*;

public class Deque<T>
{
    public Stack onePart;
    public DynArray secondPart;
    public int count;

    public Deque()
    {
        onePart = new Stack<>();
        secondPart = new DynArray<>(Integer.class);
        // activation inside storage
    }

    public void addFront(T item)
    {
        onePart.push(item);
        secondPart.append(item);
        count ++;

        // add to head
    }

    public void addTail(T item)
    {
        onePart.push(item);
        secondPart.append(item);
        count ++;
        // add to tail
    }

    public T removeFront()
    {
        if (count == 0) {
            return null;
        }
        T temp;
        temp = (T) onePart.pop();
        secondPart.remove(count - 1);
        count --;
        // deleting out head
        return temp;
    }

    public T removeTail()
    {
        if (count == 0) {
            return null;
        }
        T temp2;
        temp2 = (T) onePart.popTail();
        secondPart.remove(0);
        count --;
        // deleting out tail
        return temp2;
    }

    public int size()
    {
        return count;
    }
}

class Stack<T>
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

    public T popTail() { //my insert
        if (count == 0) {
            return null;
        }
        if (count == 1) {
            T temp = (T) tail.value;
            head = null;
            tail = null;
            count --;
            return temp;
        }
        T temp = (T) tail.value;
        tail.prev.next = null;
        tail = tail.prev;
        count --;
        return temp;
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

class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;
    public T [] oldArray;

    public DynArray(Class clz)
    {
        clazz = clz;
        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        array = (T[]) Array.newInstance(this.clazz, new_capacity);
        this.capacity = new_capacity;
    }

    public T[] copyArray () {
        oldArray = this.array;
        //System.arraycopy(array, 0, oldArray, 0, array.length);
        return oldArray;
    }

    public void append(T itm)
    {
        boolean flagEmpty = count + 1 <= capacity;
        if (flagEmpty) {
            array [count] = itm;
            count ++;
            return;
        }
        copyArray();
        makeArray(capacity * 2);
        System.arraycopy(oldArray, 0, array, 0, oldArray.length);
        array [count] = itm;
        count ++;
    }

    public void remove(int index) throws IndexOutOfBoundsException
    {
        boolean reSize = false;
        boolean cutSize = false;
        if (index < 0 || index > (count - 1)) {
            throw new IndexOutOfBoundsException(index);
        }
        int currentCapacity = (int) (capacity / 1.5);
        if (currentCapacity < 16) {
            currentCapacity = 16;
        }
        if ((count - 1 <= currentCapacity) && capacity > 16 && (count - 1 < capacity/2)) {
            reSize = true;
        }

        if ((index == 0)) { //head
            copyArray();
            makeArray(capacity);
            System.arraycopy(oldArray, index + 1, array, 0, oldArray.length - 1);
            count --;
            cutSize = true;

        }
        if ((index == (count - 1)) && !cutSize) { // tail
            copyArray();
            makeArray(capacity);
            System.arraycopy(oldArray, 0, array, 0, (index));
            count --;
            cutSize = true;

        }
        if ((index < count && index > 0) && !cutSize) { // any place
            copyArray();
            makeArray(capacity);
            System.arraycopy(oldArray, 0, array, 0, index);
            System.arraycopy(oldArray, index + 1, array, index, oldArray.length - (index + 1));
            count --;

        }
        if (reSize) {
            copyArray();
            makeArray(currentCapacity);
            System.arraycopy(oldArray, 0, array, 0, count);
            this.capacity = currentCapacity;
        }
    }
}