import java.lang.reflect.Array;
import java.util.*;

public class Deque<T>
{
    public LinkedList2 onePart;
    public DynArray secondPart;
    public int count;

    public Deque()
    {
        onePart = new LinkedList2();
        secondPart = new DynArray<>(Integer.class);
        // activation inside storage
    }

    public void addFront(T item)
    {
        Node node = new Node<>(item);
        onePart.addInTail(node);
        secondPart.append(item);
        count ++;

        // add to head
    }

    public void addTail(T item)
    {
        Node node = new Node<>(item);
        onePart.addInHead(node);
        secondPart.insert(item, 0);
        count ++;
        // add to tail
    }

    public T removeFront()
    {
        if (count == 0) {
            return null;
        }
        T temp;
        temp = (T) secondPart.getItem(count - 1);
        onePart.remove((Integer) temp);
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
        temp2 = (T) secondPart.getItem(0);
        onePart.remove((Integer) temp2);
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

class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;
    public T [] oldArray;

    public DynArray(Class clz)
    {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);
        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        array = (T[]) Array.newInstance(this.clazz, new_capacity);
        // array = (T[]) Array.newInstance(this.clazz, new_capacity);
        this.capacity = new_capacity;
    }

    public T getItem(int index)
    {
        if (index == 0 || index <= array.length - 1) {
            T t = array[index];
            return t;
        }
        return null;
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

    public void insert(T itm, int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException(index);
        }
        boolean flagDontGrow = false;
        if (index < capacity) {
            copyArray();
            makeArray(capacity);
        }
        if (index == 0) { // insert head
            array [index] = itm;
            System.arraycopy(oldArray, 0, array, index + 1, oldArray.length - 1);
            flagDontGrow = true;
        }
        if (index == capacity -  1 && !flagDontGrow) { // insert tail
            System.arraycopy(oldArray, 0, array, 0, oldArray.length - 1);
            array [index] = itm;
            flagDontGrow = true;
        }
        if ((index > 0 && index < capacity) && !flagDontGrow) { // insert any place
            System.arraycopy(oldArray, 0, array, 0, index);
            array [index] = itm;
            System.arraycopy(oldArray, index , array, index + 1, oldArray.length - 1 - index);
        }

        if (index >= capacity ) {
            copyArray();
            makeArray(capacity * 2);
            System.arraycopy(oldArray, 0, array, 0, index);
            array [index] = itm;
            System.arraycopy(oldArray, index, array, index + 1, oldArray.length - index);
        }
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


class LinkedList2 {
    public Node head;
    public Node tail;
    public int count;

    public LinkedList2() {
        head = null;
        tail = null;
        count = 0;

    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
            count++;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
            count++;
        }
        this.tail = _item;
    }

    public void addInHead(Node _item) {
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
        count++;

    }


    public boolean remove(int _value) {
        Node current = head;
        Node previous = head;
        //if list is empty
        if (current == null) {
            return false;
        }
        //if value into head and list have more value
        if ((int) current.value == _value && count > 1) {
            current.next.prev = null;
            head = current.next;
            count--;
            return true;
        }
        //if value into head and list size 1
        if ((int) current.value == _value && count == 1) {
            head = null;
            tail = null;
            count--;
            return true;
        }
        //if value into tail
        if ((int) tail.value == _value) { // it is tail!
            tail.prev.next = null;
            tail = tail.prev;
            count--;
            return true;
        }
        // if value into the middle
        while (previous.next != null) { // delete in middle
            if ((int) current.value == _value) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                count--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        Node current = head;
        Node previousNode = head;
        if (head == null) { //if list empty
            return;
        }
        if (count == 1 && (int) current.value == _value) { //if single
            head = null;
            tail = null;
            count--;
            return;
        }
        while (previousNode.next != null) {
            if ((int) current.value == _value && current == head) { // it is head
                current.next.prev = null;
                head = current.next;
                count--;
                current = head;
            }
            if ((int) tail.value == _value) { // it is tail!
                tail.prev.next = null;
                tail = tail.prev;
                count--;
                continue;
            }
            if ((int) current.value == _value && current != head) { // any place
                current.prev.next = current.next;
                current.next.prev = current.prev;
                count--;
            }
            previousNode = current;
            current = current.next;
        }
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public int count() {
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        Node currentNode = head;
        Node previousNode = head;
        boolean flagInsert = false;
        // _nodeAfter = null insert first in list
        if (Objects.isNull(_nodeAfter)) {
            head = _nodeToInsert;
            tail = _nodeToInsert;
            count++;
            return;
        }
        // add new item after first in list - list size = 1
        if (_nodeAfter == head && count == 1) {
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.prev = _nodeAfter;
            tail = _nodeToInsert;
            count++;
            flagInsert = true;
        }
        // add new item after first in list - list size > 1
        if (_nodeAfter == head && count > 1 && !flagInsert) {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.prev = _nodeAfter;
            _nodeAfter.next.next.prev = _nodeToInsert;
            count++;
            flagInsert = true;
        }
        // add new item at last in list - list doesn't empty
        if (_nodeAfter == tail && !flagInsert) {
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.prev = _nodeAfter;
            tail = _nodeToInsert;
            count++;
            flagInsert = true;
        }
        // add new item  in list - anyplace
        while (previousNode.next != null && !flagInsert) {
            if (currentNode == _nodeAfter) {
                _nodeToInsert.next = _nodeAfter.next;
                _nodeAfter.next = _nodeToInsert;
                _nodeToInsert.prev = _nodeAfter;
                _nodeAfter.next.next.prev = _nodeToInsert;
                count++;
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }
}

class Node<T> {
    public T value;
    public Node next;
    public Node prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

