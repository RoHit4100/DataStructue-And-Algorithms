package com.Recursion;

public class FactorialOfN {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    static int factorial(int n) {
        if(n <= 1)
            return 1;
        return n * factorial(n - 1);
    }
}
