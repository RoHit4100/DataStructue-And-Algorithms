package com.LinkedList;

public class MainForCLL {
    public static void main(String[] args) {
        CircularLL list = new CircularLL();
        list.insert(45);
        list.insert(78);
        list.insert(90);
        list.insert(23);
        list.insert(45900);
        list.display();
        System.out.println(list.delete(459000));
        list.display();
    }
}
