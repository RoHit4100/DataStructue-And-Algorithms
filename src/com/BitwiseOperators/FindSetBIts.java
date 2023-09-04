package com.BitwiseOperators;

public class FindSetBIts {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(4));
        System.out.println(findTotalSetBits(4));
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
