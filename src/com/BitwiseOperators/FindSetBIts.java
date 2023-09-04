package com.BitwiseOperators;

public class FindSetBIts {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(3));
        System.out.println(findTotalSetBits(3));
    }

    static int findTotalSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n -= (n & -n);
        }
        return count;
    }
}
