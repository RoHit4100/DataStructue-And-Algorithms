package com.Backtracking.Questions;

public class NKnightsDisplay {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        findSolutions(board, 0, 0, n);
    }

    static void findSolutions(boolean[][] board, int row, int col, int knights) {
        // if knights becomes 0 display the board and return to its previous call
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }

        // if row and col are at the last index then skip recursion call
        if (row == board.length - 1 && col == board.length - 1) {
            return;
        }
        // if it is a last column just shift to next row and start over again
        if (col == board.length) {
            findSolutions(board, row + 1, 0, knights);
            return;
        }

        // if the current place is safe then place the knight there
        if (isSafe(board, row, col)) {
            // place the knight
            board[row][col] = true;
            // after placing the knight move ahead
            findSolutions(board, row, col + 1, knights - 1);
            // do the backtracking
            board[row][col] = false;
        }
        // if current place is not safe then move ahead without changing anything
        findSolutions(board, row, col + 1, knights);
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        // to check whether the knight is safe or not we have to check 4 conditions taking consideration knights moment on the chess board.

        // we will only check above the current row, because knights will only present above the current row.
        if (isValid(board, row , col)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }

        if (isValid(board, row, col)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        if (isValid(board, row, col)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        if (isValid(board, row, col)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }
        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col) {
        // checking whether the current index are within the matrix or not, to avoid the "index out of bound error."
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return false;
        }
        return true;
    }
    static void display(boolean[][] board) {
        // printing the row
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("K ");
                }else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
