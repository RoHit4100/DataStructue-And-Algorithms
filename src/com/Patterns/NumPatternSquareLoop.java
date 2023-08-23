package com.Patterns;

public class NumPatternSquareLoop {
    public static void main(String[] args) {
        printPattern(6);
    }

    static void printPattern(int n) {
        int original = n;
        n = 2 * n;
        System.out.println();
        for (int i = 1; i < n; i++) {
            // Now we have to find out the content in the columns
            System.out.print("          ");
            for (int j = 1; j < n; j++) {
                int atEveryIndex = original - Math.min(Math.min(j, i), Math.min(n - j, n - i)) + 1;
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }

    }
}
