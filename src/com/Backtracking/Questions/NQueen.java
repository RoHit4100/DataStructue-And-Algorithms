package com.Backtracking.Questions;

public class NQueen {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        int totalPossibleAns = queens(board, 0);
        System.out.println(totalPossibleAns);
    }

    static int queens(boolean[][] board, int row) {
        // if row becomes the board length means we have found one of the possible answers. therefore we will print that ans and return the count.
        if (row == board.length) {
            // display the board.
            displayBoard(board);
            // return 1 for the total count.
            System.out.println();
            return 1;
        }


        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        // a queen is safe if it will not get cancel from its above rows.
        // there are 3 conditions for the queen to be safe,
        //      1. If above any row do not contain any row.
                    // to search this condition we have to search from,
                    // 0th row till that row, and only in that column.
        //      2. If any diagonal element of left side do not contain queen.
                    // first we have to get minimum of the row and col because,
                        // e.g. (2, 3) ===> we have to check till 2 rows only from current row.
                            //   r, c
                        // e.g. (3, 2) ===> we have to check till 2 rows from current row.
                    // to check in left side of the diagonal we have to run for loop till the minimum of the row and col
                    // and for each iteration we have to decrease the col and row by the current number of iteration.
        //      3. If any diagonal element of right side not contain queen.
                    // same as left diagonal search but here we have to run loop till
                    // board.length - col - 1
                    // e.g. 4 - 3 - 1 == 0
                    // means we have to search till 0th row diagonally
                    // to check in right side of the diagonal element we have to run for loop till min of row and board.length - col - 1
                    // and each iteration row is getting reduced by 1 and column is increasing by 1

        // check vertical row
        for(int i = 0;i < row;i++){
            if (board[i][col]) {
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        // If none of the condition return false means queen is safe
        return true;
    }
    static void displayBoard(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                }else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
