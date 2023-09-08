package com.Recursion;

public class ProductOfDigit {
    public static void main(String[] args) {
        System.out.println(productDigit(1423));
    }

    static int productDigit(int n) {
        if (n % 10 == n) {
            return n;
        }
        return (n % 10) * productDigit(n / 10);
    }
}
