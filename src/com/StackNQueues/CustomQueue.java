package com.StackNQueues;

import java.rmi.dgc.DGC;
import java.util.DuplicateFormatFlagsException;

public class CustomQueue {
    private final int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int pointer = -1;

    CustomQueue() {
        this(DEFAULT_SIZE);
    }

    CustomQueue(int size) {
        this.data = new int[size];
    }


    public void add(int n) {
        if (isFull()) {
            System.out.println("stack is full");
            return;
        }
        data[++pointer] = n;
    }

    private boolean isFull() {
        return pointer == DEFAULT_SIZE;
    }

    public int pop() throws Exception{
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }

        return data[pointer--];
    }

    private boolean isEmpty() {
        return pointer == -1;
    }

    public int peek() throws Exception{
        if (isEmpty()) {
            throw new Exception("stack is empty");
        }
        return data[pointer];
    }
}
