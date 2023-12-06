package com.StackNQueues;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        CustomStack stack = new CustomStack(10);
        stack.add(19);
        stack.add(99);
        stack.add(8);
        stack.add(1);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
