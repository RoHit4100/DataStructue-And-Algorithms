package com.Patterns;

public class StarPatternRevTriangle {
    public static void main(String[] args) {
        printPattern(7);
    }

    static void printPattern(int n) {
        // we will run outer loop for N number of line
        for (int i = 0; i < n; i++) {
            // now we have to figure out what number of columns are present in each row.
            for (int j = n - i; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
