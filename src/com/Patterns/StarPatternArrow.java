package com.Patterns;

public class StarPatternArrow {
    public static void main(String[] args) {
        printPattern(5);
    }

    /*

     *
     * *
     * * *
     * * * *
     * * * * *
     * * * *
     * * *
     * *
     *

     To print the pattern like this first we have to run for loop till the number of rows.
     After that we have to find out the relationship between the cols, rows and N.
     There is always some formula present in this kind of situation.
     In this case we have found this formula, for the two cases:
        1. If the current row is greater than the total number of the rows:
            Then current row = Total number of rows - the current row
        2. else
            current row = the current row.
     */
    static void printPattern(int n) {

        for (int i = 1; i <= 2 * n; i++) {
            int totalCols = i > n ? 2 * n - i : i;
            for (int j = 0; j < totalCols; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
