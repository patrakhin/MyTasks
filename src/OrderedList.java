import java.util.*;

class Node<T>
{
    public T value;
    public String valueString;
    public int valueInt;
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
    private boolean itsString;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        int end = 100;
        if (itsString) {
            end = v1.toString().compareTo(v2.toString());
            return end;
        }
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

        T valueObject = null;
        int buff;
        boolean valueInteger = false;
        String valueString = value.toString().trim();

        for (int i = 0; i < valueString.length(); i++) {
            if (valueString.charAt(i) == '-') {
                continue;
            }
            if (Character.isDigit(valueString.charAt(i))) {
                valueObject = value;
                valueInteger = true;
                continue;
            }
            if (!Character.isDigit(valueString.charAt(i))) {
                valueObject = (T) valueString;
                valueInteger = false;
                break;
            }
        }

        Node currentNode = head;
        Node previousNode = head;
        Node nodeTwo = new Node<>(valueObject);
        if (valueInteger) {
            buff = Integer.parseInt(valueString);
            nodeTwo = new Node<Integer>(buff);
        }

        Node nodeString = new Node<>(valueObject);
        if (!valueInteger) {
            nodeString = new Node<String>((String) valueObject);
        }
        if (count == 0 && valueInteger) {
            addInHead(nodeTwo);
            return;
        }
        if (count == 0) {
            addInHead(nodeString);
            itsString = true;
            return;
        }

        if (count == 1 && (compare((T) currentNode.value, (T) nodeTwo.value) <= -1 && _ascending)) { //v1 < v2 and ascending
            //add the after v1
            insertAfter(currentNode, nodeTwo);
            return;
        }
        if (count == 1 && (compare((T) currentNode.value, (T) nodeTwo.value) >= 1 && _ascending)) { //v1 > v2 and ascending
            //add the before v1
            addInHead(nodeTwo);
            return;
        }
        if (count == 1 && (compare((T) currentNode.value, (T) nodeTwo.value) == 0 && _ascending)) { //v1 = v2 and ascending
            //add the before v1
            addInHead(nodeTwo);
            return;
        }

        if (count == 1 && (compare((T) currentNode.value, (T) nodeTwo.value) <= -1 && !_ascending)) { //v1 < v2 and descending
            //add the before v1
            addInHead(nodeTwo);
            return;
        }
        if (count == 1 && (compare((T) currentNode.value, (T) nodeTwo.value) >= 1 && !_ascending)) { //v1 > v2 and descending
            //add the after v1
            insertAfter(currentNode, nodeTwo);
            return;
        }
        if (count == 1 && (compare((T) currentNode.value, (T) nodeTwo.value) == 0 && !_ascending)) { //v1 = v2 and descending
            //add the before v1
            insertAfter(currentNode, nodeTwo);
            return;
        }

        while (previousNode.next != null && _ascending) {
            if (compare((T) previousNode.value, (T) nodeTwo.value) <= -1 && compare((T) currentNode.value, (T) nodeTwo.value) == 1) {
                insertAfter(previousNode, nodeTwo);
                return;
            }
            if (compare((T) currentNode.value, (T) nodeTwo.value) <= -1 && currentNode.next == null) {
                insertAfter(currentNode, nodeTwo);
                return;
            }
            if (compare((T) currentNode.value, (T) nodeTwo.value) == 0) {
                insertAfter(currentNode, nodeTwo);
                return;
            }
            if (compare((T) currentNode.value, (T) nodeTwo.value) >= 1) {
                addInHead(nodeTwo);
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        while (previousNode.next != null && !_ascending) {
            if (compare((T) previousNode.value, (T) nodeTwo.value) >= 1 && compare((T) currentNode.value, (T) nodeTwo.value) <= -1) {
                insertAfter(previousNode, nodeTwo);
                return;
            }
            if (compare((T) currentNode.value, (T) nodeTwo.value) >= 1 && currentNode.next == null) {
                insertAfter(currentNode, nodeTwo);
                return;
            }
            if (compare((T) currentNode.value, (T) nodeTwo.value) == 0) {
                insertAfter(currentNode, nodeTwo);
                return;
            }
            if (compare((T) currentNode.value, (T) nodeTwo.value) <= -1) {
                addInHead(nodeTwo);
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }


        // auto insert  value
        // in need place
    }

    public Node<T> find(T val)
    {
        Node node = this.head;
        Node nodeFour = new Node<>(val);
        while (node != null) {
            if (compare( (T) node.value, (T) nodeFour.value) == 0)
                return node;
            node = node.next;
        }
        return null; //
    }

    public void delete(T val)
    {
        int buff;
        boolean flagIntefer = false;
        T valueObject = null;
        String valueString = val.toString();
        valueString = valueString.trim();

        for (int i = 0; i < valueString.length(); i++) {
            if (valueString.charAt(i) == '-') {
                continue;
            }
            if (Character.isDigit(valueString.charAt(i))) {
                valueObject = val;
                flagIntefer = true;
                continue;
            }
            if (!Character.isDigit(valueString.charAt(i))){
                valueObject = (T) valueString;
                break;
            }
        }

        Node current = head;
        Node previous = head;
        Node nodeThree = new Node<>(valueObject);
        if (flagIntefer) {
            buff = Integer.parseInt(valueString);
            nodeThree = new Node<>(buff);
        }

        //if list is empty
        if (current == null) {
            return;
        }
        //if value into head and list have more value
        if (compare((T) current.value, (T) nodeThree.value) == 0 && count > 1) {
            current.next.prev = null;
            head = current.next;
            count --;
            return;
        }
        //if value into head and list size 1
        if (compare((T) current.value, (T) nodeThree.value) == 0 && count == 1) {
            head = null;
            tail = null;
            count --;
            return;
        }
        //if value into tail
        if (compare((T) tail.value, (T) nodeThree.value) == 0  ) { // it is tail!
            tail.prev.next = null;
            tail = tail.prev;
            count --;
            return;
        }
        // if value into the middle
        while (previous.next != null) { // delete in middle
            if (compare((T) previous.value, (T) nodeThree.value) == 0)  {
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