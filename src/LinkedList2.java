import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;
    public int count;

    public LinkedList2()
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
            count ++;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
            count ++;
        }
        this.tail = _item;
    }

    public Node find(int _value)
    {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node current = head;
        Node previous = head;
        //if list is empty
        if (current == null) {
            return false;
        }
        //if value into head and list have more value
        if (current.value == _value && count > 1) {
            current.next.prev = null;
            head = current.next;
            count --;
            return true;
        }
        //if value into head and list size 1
        if (current.value == _value && count == 1) {
            head = null;
            tail = null;
            count --;
            return true;
        }
        //if value into tail
        if (tail.value == _value) { // it is tail!
            tail.prev.next = null;
            tail = tail.prev;
            count --;
            return true;
        }
        // if value into the middle
        while (previous.next != null) { // delete in middle
            if (current.value == _value) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                count --;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public void removeAll(int _value)
    {
        Node current = head;
        Node previousNode = head;
        if (head == null) { //if list empty
            return;
        }
        if (count == 1 && current.value == _value) { //if single
            head = null;
            tail = null;
            count --;
            return;
        }
        while (previousNode.next != null) {
            if (current.value == _value && current == head) { // it is head
                current.next.prev = null;
                head = current.next;
                count --;
                current = head;
            }
            if (tail.value == _value) { // it is tail!
                tail.prev.next = null;
                tail = tail.prev;
                count --;
                continue;
            }
            if (current.value == _value && current != head) { // any place
                current.prev.next = current.next;
                current.next.prev = current.prev;
                count --;
            }
            previousNode = current;
            current = current.next;
        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public int count()
    {
        return count;
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


    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder("[");
        String sep = "";
        Node temp = this.head;
        while (temp != null) {
            sb.append(sep).append(temp.value);
            temp = temp.next;
            sep = ", ";
        }
        return sb.append(']').toString();
    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}