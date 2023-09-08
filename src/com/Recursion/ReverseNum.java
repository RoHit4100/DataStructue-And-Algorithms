package com.Recursion;

public class ReverseNum {
    public static void main(String[] args) {
        reverse(1234);
//        System.out.println(sum);
        System.out.println(revers2(1234566));
    }

    static int sum = 0;
    static void reverse(int n) {
        if (n == 0) {
            return;
        }
        sum = sum * 10 + (n % 10);
        reverse(n / 10);
    }

    static int revers2(int n) {
        if (n % 10 == n) {
            return n;
        }
        int digits = (int)(Math.log10(n) + 1);
        return helper(n, digits);
    }
    // In reverse 2 we are using different method to reverse number, without using external variable.
    // We are using formula,
    //    remainder * 10^n - 1 + n / 10, n - 1;
    static int helper(int n, int digits) {
        if (n % 10 == n) {
            return n;
        }
        return (n % 10) * (int)(Math.pow(10, digits - 1)) + helper(n / 10, digits - 1);
    }
}
