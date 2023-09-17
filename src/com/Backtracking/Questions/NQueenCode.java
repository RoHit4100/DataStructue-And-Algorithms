package com.Backtracking.Questions;

import java.util.ArrayList;
import java.util.List;

public class NQueenCode {
    public static void main(String[] args) {
        List<List<String>> ans = giveThsPossibleAns(4);
        System.out.println(ans);
    }

    static List<List<String>> giveThsPossibleAns(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> outer = new ArrayList<>();
        helper(board, 0, outer);
        return outer;
    }

    static void helper(boolean[][] board, int row, List<List<String>> outer) {

        if (row == board.length) {
            ArrayList<String> solution = new ArrayList<>();
            outer.add(addSolution(board, solution));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                helper(board, row + 1, outer);
                board[row][col] = false;
            }
        }
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        // There are going to be 3 cases to check whether the queen is current safe of not
        // check vertically
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // check into right diagonals
        int maxRight = Math.min(row, col);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // check into left diagonals
        int maxLeft = Math.min(row, board.length - col - 1);
        for (int i = 0; i <= maxLeft; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }
    static List<String> addSolution(boolean[][] board, ArrayList<String> solution) {
        for (boolean[] arr : board) {
            StringBuilder row = new StringBuilder();
            for (boolean element : arr) {
                if (element) {
                    row.append("Q");
                }else {
                    row.append(".");
                }
            }
            solution.add(row.toString());
        }
        return solution;
    }
}
