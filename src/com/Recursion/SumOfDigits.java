package com.Recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumDigit(1402));
    }

    static int sumDigit(int n) {
        if (n == 0) {
            return 0;
        }
        int remainder = n % 10;
        n = n / 10;
        return remainder + sumDigit(n);
    }
}
