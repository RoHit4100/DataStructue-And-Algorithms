package com.LinkedList;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    LL() {
        this.size = 0;
    }

    // insert first node
    public void insertFirst(int value) {
        // first we create a new node
        Node newNode = new Node(value);
        // assign the current head of the link list to newNodes next, therefore current head will become the next node of the linked list
        newNode.next = head;
        // now update the head's value, assign head to newNode.
        head = newNode;
        // if it is first element means when tail is null, then assign head and tail to same element
        if (tail == null) {
            tail = head;
        }
        // increase the size of the link list by 1;
        size += 1;
    }

    // insert at the last
    public void insertLast(int value){
        // first create the new node with given value
        Node node = new Node(value);
        // check whether the tail is null or not, means whether list is empty or not
        if (tail == null) {
            // if empty then call the insertFirst method
            insertFirst(value);
            // return after creating new node
            return;
        }
        // assign the next node of with the new created node.
        tail.next = node;
        // update the tail with newly created node.
        tail = node;
        // increase the size by 1
        size += 1;
    }

    // insert with index
    public void insert(int index, int value) throws Exception {
        // throw exception when index is greater than the size of the LL
        if (index > size) {
            throw new Exception("please enter index within valid range");
        }
        // check whether the index is 0 or not
        if (index == 0) {
            // if 0 then call insertFirst function
            insertFirst(value);
            return;
        }
        // check whether index is our size of the link list or not
        if (index == size) {
            // call the insertLast method
            insertLast(value);
            return;
        }
        // check whether is LL is empty or not
        if (tail == null) {
            insertFirst(value);
            return;
        }
        // create a temp node object for traversing in the LL
        Node temp = head;
        for (int i = 1; i < index; i++) {
            // assign the next node in each iteration
            temp = temp.next;
        }
        // another way is using second constructor
        // create a node, which will take input of the value and current node's next value which is going to be next node of the LL.
        Node node = new Node(value, temp.next);
        // assign the next node of current node as new created node.
        temp.next = node;


        // this is my way to insert a value at any particular index
//        Node node = new Node(value);
//        Node previousNextNode = temp.next;
//        temp.next = node;
//        node.next = previousNextNode;

        // increase the size of LL by 1
        size++;
    }

    // display the link list
    public void display() {
        // create a new temp node which will point to the head of the LL
        // NOTE: here we are not changing the temp value we are just assigning next node to the temp
        Node temp  = head;
        // run the while loop until we found a null node
        while (temp != null) {
            // print the value of the node.
            System.out.print(temp.value + " -> ");
            // assign the next node to the temp.
            temp = temp.next;
        }
        // print end at the end of the link list.
        System.out.println("End");
    }

    // delete first
    public int deleteFirst() {
        // store the current value of head means first node.
        int deleteValue = head.value;
        // now assign head with the head.next, means next node.
        head = head.next;
        // decrement the size by 1
        size -= 1;
        // after deleting the node, if head becomes the null then marks tail also as null.
        if (head == null) {
            tail = null;
        }
        // return the deleted value
        return deleteValue;
    }

    // delete last node
    public int deleteLast() {
        // check whether the size is greater than 1 or not.
        if (size <= 1) {
            // if less than 1 then return the deleteFirst method.
            return deleteFirst();
        }
        // store the deleted node's value in variable
        int deleteValue = tail.value;
        // create a temp node which point to head node
        Node temp = head;
        // now traverse till size - 2 to find second last element
        for (int i = 1; i < size - 2; i++) {
            // assign next node to temp in each iteration
            temp = temp.next;
        }
        // now make the temp.next = null, because last node's next element is always null.
        temp.next = null;
        // now update tail with second last node.
        tail = temp;
        // decrement the size by 1
        size -= 1;
        // return the deleted value.
        return deleteValue;
    }

    // get the particular index number
    private Node get(int index) {
        Node temp = head;
        for (int i = 1; i <= index; i++) {
            // Note: here temp is not changing the structure of the object
            // if temp.next = next ---> only this means structure of the object is changing, this also known as reassigning.
            // here this is not case.
            temp = temp.next;
        }
        return temp;
    }

    // delete the particular index
    public int delete(int index) {
        // check whether the index given is 0 or not.
        if (index == 0) {
            // if 0 then delete the first node.
            return deleteFirst();
        }
        // check whether the index is last or not.
        if (index == size - 1) {
            // if last then delete last index.
            return deleteLast();
        }
        // get the previous node which is i - 1;
        Node previosNode = get(index - 1);
//        previousNode.next = get(index + 1);

        // store deleted value in variable.
//        int deletedVal = get(index).value;
        int deletedVal = previosNode.next.value;

        // now update the previous node's next node.
        previosNode.next = previosNode.next.next;
        // decrement the size by 1;
        size -= 1;
        // return the deleted value.
        return deletedVal;
    }


    // find the given value's index
    public int find(int value) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            int currentValue = temp.value;
            if (currentValue == value) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    private static class Node {
        // value of the node.
        private final int value;
        // it is just reference variable which will point to next node.
        // by default value of the next is going to be null
        private Node next;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
