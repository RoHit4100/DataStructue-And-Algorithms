package com.BitwiseOperators;

public class NoOfDigitsInBaseB {
    public static void main(String[] args) {
        System.out.println(find(10, 2));
    }

    static int find(int n, int base) {
        return (int)(Math.log(n) / Math.log(base)) + 1;
    }
}
