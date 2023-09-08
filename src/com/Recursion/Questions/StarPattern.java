package com.Recursion.Questions;

public class StarPattern {
    public static void main(String[] args) {
        printPattern2(4, 0);
    }
    /*
        To solve this pattern we will take 2 variables as we were taking in the iterative method,
        In this problem we will keep running our recursive func until, col < row
            initially we will take col = 0 and row = n,
            i.e. (4, 0)
            we will increment col after each call.
            till row > col
        after row < col
            we will decrement row value by one and start over again.
     */
    static void printPattern(int row, int col) {
        if (row == 0) {
            return;
        }
        if (row > col) {
            System.out.print("* ");
            printPattern(row, col + 1);
        }else{
            System.out.println();
            printPattern(row - 1, 0);
        }
    }
    static void printPattern2(int row, int col) {
        if (row == 0) {
            return;
        }
        if (row > col) {
            printPattern2(row, col + 1);
            System.out.print("* ");
        }else{
            printPattern2(row - 1, 0);
            System.out.println();
        }
    }
}
