package com.Patterns;

public class NumPatternOriginalTriangle {
    public static void main(String[] args) {
        printPattern(6);
    }

    static void printPattern(int n) {
        for (int row = 0; row < n; row++) {
            // For adding spaces
            for (int space = 0; space < n - row; space++) {
                System.out.print("  ");
            }
            // For adding number till 1
            for (int col = row; col >= 1; col--) {
                System.out.print(col+" ");
            }
            // For adding numbers from 2 till row
            for (int col = 2; col <= row; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
}
