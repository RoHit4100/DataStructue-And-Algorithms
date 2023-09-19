package com.OOPS;

public class ExceptionHandling {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
            System.out.println(ans(a, b));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("This msg is going to execute by any means");
        }
    }

    static int ans(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("do not divide any number by 0");
        }
        return a / b;
    }
}
