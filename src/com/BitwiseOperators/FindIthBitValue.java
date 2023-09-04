package com.BitwiseOperators;

public class FindIthBitValue {
    public static void main(String[] args) {
        System.out.println(find(14, 3));
    }
    static int find(int n, int k) {
        return ((n & (1 << (k - 1)))  >> (k - 1));
    }
}
