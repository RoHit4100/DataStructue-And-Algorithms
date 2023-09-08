package com.Recursion;

public class CheckNoOfZeros {
    public static void main(String[] args) {
        System.out.println(countZeros(100, 0));
    }

    static int countZeros(int n, int count) {
        int rem = n % 10;
        if (n == 0) {
            return count;
        }
        if (rem == 0) {
            return countZeros(n / 10, count + 1);
        }
        return countZeros(n / 10, count);
    }
}
