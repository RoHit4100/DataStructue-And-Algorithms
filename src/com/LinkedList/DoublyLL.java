package com.LinkedList;

public class DoublyLL {

    private Node head;
    private Node tail;
    private int size;

    DoublyLL() {
        this.size = 0;
    }

    // insert first
    public void insertFirst(int value) {
        // create a new node having the given value
        Node node = new Node(value);
        // check if head null or not, i.e. list is empty or not.
        // if list is empty the then only set head.prev = node.
        // if not then skip to avoid null pointer exception.
        if(head != null){
            head.prev = node;
        }
        // set node.next is head.
        node.next = head;
        // set node.prev as null, because first nodes previous element is null, and last element next element is null
        node.prev = null;

        // assign node as head
        head = node;
        // increment the size.
        size++;
    }

    // to display
    public void display() {
        Node temp = head;
        tail = null;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            // update the tail pointer as well with every node.
            tail = temp;
            temp = temp.next;
        }
        System.out.println("End");
    }

    // display reverse
    public void displayRev() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.value + " <- ");
            temp = temp.prev;
        }
        System.out.println("Start");
    }

    // insert element at last without tail pointer
    public void insertLast(int value) {
        // if list is empty then call insertFirst method.
        if (head == null) {
            insertFirst(value);
            return;
        }
        // create a temp node for traversing till last node.
        Node temp = head;
        // traverse with temp node till temp.next != null
        while (temp.next != null) {
            // up temp node with next node
            temp = temp.next;
        }
        // create new node
        Node node = new Node(value);
        // assign temp.next = new created node.
        temp.next = node;
        // now node have become last node so make node.next last.
        node.next = null;
        // make node.prev as previous last node, which is temp.
        node.prev = temp;
        // increment the size.
        size++;
    }

    // insert at particular index
    public void insert(int index, int value) {
        // check whether index is 0 or not
        if (index == 0) {
            insertFirst(value);
            return;
        }

        // check whether index is last or not
        if (index == size) {
            insertLast(value);
            return;
        }

        // create new temp node
        Node temp = head;
        // iterate link list till index
        for (int i = 1; i < index; i++) {
             temp = temp.next;
        }

        // save next node of given index node
        Node nxtNode = temp.next;
        // create new node with constructor
        // value, next node is going to be temp.next, previous node is going to be temp
        Node node = new Node(value, nxtNode, temp);

        // now next node's previous node is going to be new created node
        nxtNode.prev = node;
        // and temp's next is going to be newly created node.
        temp.next = node;

        // increment size
        size++;
    }


    // find the node which have given value
    private Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    // insert after value, which is given as an argument
    public void insertAfter(int value, int insertingValue) {
        Node temp = find(value);
        if(temp == null){
            System.out.println("Item do not exist");
            return;
        }

        Node node = new Node(insertingValue, temp.next, temp);
        if (temp.next != null) {
            temp.next.prev = node;
        }
        temp.next = node;
        size++;
    }


    // delete item by its value
    public int delete(int value) {
        if (head == null) {
            System.out.println("Please enter new elements first!");
            return -1;
        }
        if (head.value == value) {
            head = head.next;
            head.prev = null;
        }

        Node node = find(value);
        assert node != null;
        if(node.prev != null) {
            node.prev.next = node.next;
        }
        if(node.prev == null)
            node.next.prev = node.prev;
        return node.value;
    }
    private static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
