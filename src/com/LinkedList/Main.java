package com.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        LL list = new LL();
        list.insertFirst(39);
        list.insertFirst(22);
        list.insertFirst(32);
        list.insertFirst(34433);
        list.insertFirst(89);
        list.display();
        System.out.println(list.delete(1));
        list.display();
        System.out.println(list.find(39));
    }
}
