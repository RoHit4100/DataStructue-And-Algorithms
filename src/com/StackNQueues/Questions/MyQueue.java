package com.StackNQueues.Questions;

import java.util.Stack;

// add or push efficient
class MyQueueAddEfficient {
    Stack first;
    Stack second;

    public MyQueueAddEfficient() {
        this.first = new Stack();
        this.second = new Stack();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int removed = (int)second.pop();
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return removed;
    }

    public int peek() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int firstElement = (int)second.peek();
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return firstElement;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}

class MyQueueRemoveEfficient{
    Stack first;
    Stack second;

    public MyQueueRemoveEfficient() {
        this.first = new Stack();
        this.second = new Stack();
    }

    public void push(int x) {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
    }

    public int pop() {
        return (int)first.pop();
    }

    public int peek() {
        return (int)first.peek();
    }

    public boolean empty() {
        return first.isEmpty();
    }
}