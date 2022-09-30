import java.util.*;

class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;
    public int count;
    public T memory;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        int end = 100;
        if (v1 == null && v2 != null) {
            end = -1;
            return end;
        }
        if (v2 == null && v1 != null) {
            end = 1;
            return end;
        }
        if (v1 == null && v2 == null) {
            end = 0;
            return end;
        }
        if ((int) v1 < (int) v2) {
            end = -1;
        }
        if ((int) v1 > (int) v2) {
            end = 1;
        }
        if ((int) v1 == (int) v2) {
            end = 0;
        }
        return end;
        // -1 if v1 < v2
        // 0 if v1 == v2
        // +1 if v1 > v2
    }

    //this is my insert
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

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        Node currentNode = head;
        Node previousNode = head;
        boolean flagInsert = false;
        // _nodeAfter = null insert first in list
        if (Objects.isNull(_nodeAfter)) {
            head = _nodeToInsert;
            tail = _nodeToInsert;
            count ++;
            return;
        }
        // add new item after first in list - list size = 1
        if (_nodeAfter == head && count == 1) {
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.prev = _nodeAfter;
            tail = _nodeToInsert;
            count ++;
            flagInsert = true;
        }
        // add new item after first in list - list size > 1
        if (_nodeAfter == head && count > 1 && !flagInsert) {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.prev = _nodeAfter;
            _nodeAfter.next.next.prev = _nodeToInsert;
            count ++;
            flagInsert = true;
        }
        // add new item at last in list - list doesn't empty
        if (_nodeAfter == tail && !flagInsert) {
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.prev = _nodeAfter;
            tail = _nodeToInsert;
            count ++;
            flagInsert = true;
        }
        // add new item  in list - anyplace
        while (previousNode.next != null && !flagInsert) {
            if (currentNode == _nodeAfter) {
                _nodeToInsert.next = _nodeAfter.next;
                _nodeAfter.next = _nodeToInsert;
                _nodeToInsert.prev = _nodeAfter;
                _nodeAfter.next.next.prev = _nodeToInsert;
                count ++;
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }
    // end my insert

    public void add(T value)
    {
        Node currentNode = head;
        Node previousNode = head;
        Node nodeTwo = new Node<>(value);
        if (count == 0) {
            insertAfter(null, nodeTwo);
            return;
        }

        while (previousNode.next != null && _ascending) {
            if (compare( (T) previousNode.value, (T) nodeTwo.value) == -1 && compare( (T) currentNode.value, (T) nodeTwo.value) == 1) {
                insertAfter(previousNode, nodeTwo);
                return;
            }
            if (compare( (T) currentNode.value, (T) nodeTwo.value) == -1 && currentNode.next == null) {
                insertAfter(currentNode, nodeTwo);
                return;
            }
            if (compare( (T) currentNode.value, (T) nodeTwo.value) == 0) {
                insertAfter(currentNode, nodeTwo);
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        while (previousNode.next != null && !_ascending) {
            if (compare( (T) previousNode.value, (T) nodeTwo.value) == 1 && compare( (T) currentNode.value, (T) nodeTwo.value) == -1) {
                insertAfter(previousNode, nodeTwo);
                return;
            }
            if (compare( (T) currentNode.value, (T) nodeTwo.value) == 1 && currentNode.next == null) {
                insertAfter(currentNode, nodeTwo);
                return;
            }
            if (compare( (T) currentNode.value, (T) nodeTwo.value) == 0) {
                insertAfter(currentNode, nodeTwo);
                return;
            }
            if (compare( (T) currentNode.value, (T) nodeTwo.value) == -1) {
                addInHead(nodeTwo);
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if (count == 1 && (compare( (T) currentNode.value, (T) nodeTwo.value) == -1 && _ascending)) { //v1 < v2 and ascending
            //add the after v1
            insertAfter(currentNode, nodeTwo);
        }
        if (count == 1 && (compare( (T) currentNode.value, (T) nodeTwo.value) == 1 && _ascending)) { //v1 > v2 and ascending
            //add the before v1
            addInHead(nodeTwo);
        }
        if (count == 1 && (compare( (T) currentNode.value, (T) nodeTwo.value) == 0 && _ascending)) { //v1 = v2 and ascending
            //add the before v1
            addInHead(nodeTwo);
        }

        if (count == 1 && (compare( (T) currentNode.value, (T) nodeTwo.value) == -1 && !_ascending)) { //v1 < v2 and descending
            //add the before v1
            addInHead(nodeTwo);
        }
        if (count == 1 && (compare( (T) currentNode.value, (T) nodeTwo.value) == 1 && !_ascending)) { //v1 > v2 and descending
            //add the after v1
            insertAfter(currentNode, nodeTwo);
        }
        if (count == 1 && (compare( (T) currentNode.value, (T) nodeTwo.value) == 0 && !_ascending)) { //v1 = v2 and descending
            //add the before v1
            insertAfter(currentNode, nodeTwo);
        }

        // auto insert  value
        // in need place
    }

    public Node<T> find(T val)
    {
        Node node = this.head;
        while (node != null) {
            if (node.value == val)
                return node;
            node = node.next;
        }
        return null; //
    }

    public void delete(T val)
    {
        Node valInt = (Node) val;
        Node current = head;
        Node previous = head;
        //if list is empty
        if (current == null) {
            return;
        }
        //if value into head and list have more value
        if (current.value == valInt.value && count > 1) {
            current.next.prev = null;
            head = current.next;
            count --;
            return;
        }
        //if value into head and list size 1
        if (current.value == valInt.value && count == 1) {
            head = null;
            tail = null;
            count --;
            return;
        }
        //if value into tail
        if (tail.value == valInt.value) { // it is tail!
            tail.prev.next = null;
            tail = tail.prev;
            count --;
            return;
        }
        // if value into the middle
        while (previous.next != null) { // delete in middle
            if (current.value == valInt.value) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                count --;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public void clear(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
        this.count = 0;
    }

    public int count()
    {
        return count;
    }

    ArrayList<Node<T>> getAll()
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}