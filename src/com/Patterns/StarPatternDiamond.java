package com.Patterns;

public class StarPatternDiamond {
    public static void main(String[] args) {
        printPattern(4);
    }
    /*



     */


    static void printPattern(int n) {

        for (int i = 0; i < 2 * n; i++) {
            int totalCols = i > n ? 2 * n - i : i;
            int totalSpaces = n - totalCols;
            for (int j = 0; j < totalSpaces; j++) {
                System.out.print(" ");
            }
            // Before printing the star we have to print some spaces before it, we can find out by using relation between the
            // current row and the total number of rows.
            for (int k = 0; k < totalCols; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
