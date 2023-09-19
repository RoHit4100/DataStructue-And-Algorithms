package com.OOPS;

import java.util.ArrayList;

interface Arithmetic{
    int operation(int a, int b);
}
public class LambdaFunction{
    private int operate(int a, int b, Arithmetic op) {
        return op.operation(a, b);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Arithmetic mul = (a, b) -> {
            return a * b;
        };
        Arithmetic sub = (a , b) -> (a - b);
        Arithmetic divide = (a, b) -> (a / b);

        for (int i = 0; i < 10; i++) {
            list.add(i + 2);
        }
        list.forEach((item) -> System.out.println(item * 4));
        System.out.println();
        LambdaFunction calculator = new LambdaFunction();
        System.out.println(calculator.operate(8,5, sub));
        System.out.println(calculator.operate(4, 3, mul));
    }
}
