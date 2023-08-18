package com.Patterns;

public class NumPatternRevTriangle {
    public static void main(String[] args) {
        printPatterWithNum(5);
    }

    static void printPatterWithNum(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
