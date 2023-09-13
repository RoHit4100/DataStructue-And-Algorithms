package com.Backtracking;

public class MazeAllPaths {
    public static void main(String[] args) {
        boolean[][] obstacles = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        getAllPaths("", obstacles, 0, 0);
    }

    static void getAllPaths(String p, boolean[][] board,int row, int col) {
        if (row == board.length - 1 && col == board[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!board[row][col]) {
            return;
        }
        // we are assigning visited paths as false, to not get caught in infinite recursive call.
        board[row][col] = false;
        if (row < board.length - 1) {
            getAllPaths(p + "down ", board, row + 1, col);
        }
        if (col < board[0].length - 1) {
            getAllPaths(p + "right ", board, row, col + 1);
        }
        if (row > 0) {
            getAllPaths(p + "up ", board, row - 1, col);
        }
        if (col > 0) {
            getAllPaths(p + "left ", board, row, col - 1);
        }
        // now we will undo the changes made for the paths, because if the changes we made remain same for every call,
        // the paths will not be able to visit by other function calls
        board[row][col] = true;
    }
}
