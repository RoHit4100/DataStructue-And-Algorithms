package com.Backtracking;

import java.util.Arrays;

public class MazeAllPathWithTotalCount {
    public static void main(String[] args) {
        boolean[][] obstacles = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[obstacles.length][obstacles[0].length];
        getThePathCountInArr("", obstacles, 0, 0, path, 1);
    }

    static void getThePathCountInArr(String p, boolean[][] board, int row, int col, int[][] paths, int step) {
        if (row == board.length - 1 && col == board[0].length - 1) {
            paths[row][col] = step;
            for (int[] path : paths) {
                System.out.println(Arrays.toString(path));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!board[row][col]) {
            return;
        }
        // set false to visited paths
        paths[row][col] = step;
        board[row][col] = false;
        if (row < board.length - 1) {
            getThePathCountInArr(p + "down ", board, row + 1, col, paths, step + 1);
        }
        if (col < board[0].length - 1) {
            getThePathCountInArr(p + "right ", board, row, col + 1, paths, step + 1);
        }
        if (row > 0) {
            getThePathCountInArr(p + "up ", board, row - 1, col, paths, step + 1);
        }
        if (col > 0) {
            getThePathCountInArr(p + "left", board, row, col - 1, paths, step + 1);
        }
        // now after end of every recursion call we have undo the changes that were made
        board[row][col] = true;
        paths[row][col] = 0;
    }
}
