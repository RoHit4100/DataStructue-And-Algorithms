package com.BitwiseOperators;

public class FindNIsPowerOfTwoOrNot {
    public static void main(String[] args) {
        System.out.println(find(4));
    }

    static boolean find(int n) {
        if (n == 0) {
            return false;
        }
        return (n & (n-1)) == 0;
    }
}
