package com.Backtracking;

public class MazeCountPaths {
    public static void main(String[] args) {
        System.out.println(count(3,3));
    }
    /*
        In maze problem we have given a 2D matrix in which we have to find the path to the goal location.
        In this example our staring location is going to be 1, 1 and goal location is going to be 3, 3
        We can go only in right or down direction.
        when we reach at 1 means either row or col is encounter as 1. then it means we have found the path.
     */
    static int count(int row, int col) {
        // if this condition is encounter means we have found the successful path.
        if (row == 1 || col == 1) {
            return 1;
        }
        // when we go in the right direction means we are decrementing the column.
        int right = count(row, col - 1);
        // when we go in the downward direction means we are decrementing row.
        int down = count(row - 1, col);
        // in the end we will just return the sum of right path and down paths.
        return right + down;
    }
}
