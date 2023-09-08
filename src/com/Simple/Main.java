package com.Simple;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        testRecursion(5);
    }

    static void testRecursion(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        testRecursion(--n);
    }
}