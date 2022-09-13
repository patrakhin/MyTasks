import java.util.*;
public class LinkedList
{
    public Node head;
    public Node tail;
    public int count;

    public LinkedList()
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

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        // seek all node
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
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

    public boolean remove(int _value)
    {
        //  delete node at value
        boolean flagLast = false;
        Node currentNode = head;
        Node previousNode = currentNode;
        if (find(_value) == null) {
            return false;
        }
        if (find(_value) != null && head == find(_value)) { // 1st
            head = find(_value).next;
            count --;
        }
        if (find(_value) != null && head != find(_value) && find(_value).next != null) { // not 1st
            flagLast = true;
        }
        while (currentNode.next != find(_value) && flagLast) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        if (flagLast) {
            previousNode.next = find(_value).next;
            flagLast = false;
            count --;
        }
        if (find(_value) != null && head != find(_value) && find(_value).next == null) { // is last
            flagLast = true;
        }
        while (currentNode.next != null && flagLast) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        if (flagLast) {
            previousNode.next = null;
            count --;
        }
        return true;
    }

    public void removeAll(int _value)
    {
        //delete all node at value
        Node currentNode = head;
        Node previousNode = currentNode;
        while (currentNode.next != null) {
            if (currentNode.value == _value && currentNode == head) {
                head = currentNode.next;
            }
            if (currentNode.value == _value && currentNode != head) {
                previousNode.next = currentNode.next;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        Node node = this.head;
        if (node.value == _value) {
            node = null;
            this.head = null;
            this.tail = null;
        }
        this.count = 0;
        while (node != null) {
            count ++;
            node = node.next;
        }
    }

    public void clear()
    {
        //clear all list
        this.head = null;
        this.tail = null;
    }


    public int count()
    {
        return count; // count item
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        boolean flagHead = false;
        boolean flagNull = false;
        boolean flagNew = false;
        Node currentNode = head;
        Node previousNode = currentNode.next;
        if (_nodeAfter == head) {
            flagNew = true;
        }
        // insert after
        while (currentNode != _nodeAfter && !flagHead && !flagNull) {
            currentNode = currentNode.next;
            previousNode = currentNode.next;
            flagHead = true;
        }
        if (!flagHead && !flagNull && !flagNew) {
            _nodeToInsert.next = previousNode;
            currentNode.next = _nodeToInsert;
        }
        if (flagHead) {
            _nodeToInsert.next = previousNode;
            currentNode.next = _nodeToInsert;
        }
        // if_nodeAfter = null
        if (Objects.isNull(_nodeAfter)) {
            currentNode = tail;
            _nodeToInsert.next = null;
            currentNode.next = _nodeToInsert;
            flagNull = true;
        }
        // add new item the first in list
        if (_nodeAfter == head  && !flagNull && !flagHead) {
            _nodeToInsert.next = head;
            head = _nodeToInsert;
        }
        Node node = this.head;
        this.count = 0;
        while (node != null) {
            count ++;
            node = node.next;
        }
    }
}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}
