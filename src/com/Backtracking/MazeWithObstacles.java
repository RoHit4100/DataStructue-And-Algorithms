package com.Backtracking;

import java.util.ArrayList;

public class MazeWithObstacles {
    public static void main(String[] args) {
        boolean[][] obstacles = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        findPath("", obstacles, 0, 0);
    }

    static void findPath(String p, boolean[][] obstacles, int row, int col) {
        if (row == obstacles.length - 1 && col == obstacles[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!obstacles[row][col]) {
            return;
        }
        if (row < obstacles.length - 1) {
            findPath(p + "right ", obstacles, row + 1, col);
        }
        if (col < obstacles[0].length - 1) {
            findPath(p + "down ", obstacles, row, col + 1);
        }
    }
}
