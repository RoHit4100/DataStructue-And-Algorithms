package com.LinkedList;

public class MainForDLL {
    public static void main(String[] args) {
        DoublyLL list = new DoublyLL();
        list.insertFirst(78);
        list.insertFirst(56);
        list.insertFirst(90);
        list.insertFirst(65543);
        list.display();
//        list.displayRev();
//        list.insertLast(100);
//        list.display();
//        list.insert(2, 444);
//        list.display();
//        list.displayRev();
//        list.insertAfter(56, 67);
        list.insertAfter(78, 33);
        list.display();
        list.displayRev();
    }
}
