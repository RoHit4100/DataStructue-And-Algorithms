package com.LinkedList;

public class CircularLL {
    private Node head;
    private Node tail;

    // insert at last value
    public void insert(int value) {
        // first create new node with given value
        Node node = new Node(value);
        // check whether list is empty or not, means head is null or not
        if (head == null) {
            // assign head as node
            head = node;
            // assign tail as node
            tail = node;
            // return
            return;
        }
        // if list is not empty
        // assign head to node.next, means insert that element at last
        node.next = head;
        // when new node is inserted at the last then tail.next will be the newly created node
        tail.next = node;
        // now tail will be new node.
        tail = node;
    }

    public void display() {
        // create temp node to traverse in list
        Node temp = head;
        // check whether head is null or not means list is empty or not
        if (head != null) {
            // we are using do while loop because we are running these loop until the temp pointer is not equal to again head.
            // if we use other loops then first element will not print
            // So, we have to at-least print temp one time
            do {
                // print the temp value
                System.out.print(temp.value + " -> ");
                // update temp
                temp = temp.next;
            } while (temp != head); // run till temp again not became head
        }
        // print head at the end of the list.
        System.out.println("Head");
    }


    // find the node which have given value.
    private Node find(int value) {
        Node temp = head;
        if (head != null) {
            do {
                if (temp.next.value == value) {
                    return temp;
                }
                temp = temp.next;
            } while (temp != head);
        }
        return null;
    }
    public int delete(int value) {
        // check whether list is empty or not
        if (head == null) {
            return -1;
        }
        // check whether head.value == value
        if (head.value == value) {
            // then make next element of the list as head
            head = head.next;
            // now make tail = the newly created head.
            tail.next = head;
        }
        // get the previous node of node which have given value.
        Node node = find(value); // node.next is target value
        // check whether node.next value is exist in the list or not
        if (node == null) {
            System.out.println("Item doesn't exist");
        }
        assert node != null;
        // assign the target node as node.next which is our target node.
        Node target = node.next;
        // now make previous node's next as target.next
        node.next = target.next;
        // return the target value.
        return target.value;
    }
    private static class Node{
        private final int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }

        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
