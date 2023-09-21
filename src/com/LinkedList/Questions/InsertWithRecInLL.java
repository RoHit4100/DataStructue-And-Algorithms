package com.LinkedList.Questions;

public class InsertWithRecInLL {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(434);
        list.insertFirst( 34);
        list.insertFirst(934);
        list.insertFirst(404);
        list.display();
        list.insertWithRec(2,59);
        list.display();
    }
}
