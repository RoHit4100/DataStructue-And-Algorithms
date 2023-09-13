package com.Backtracking;

public class MazeWithDiagonalMoment {
    public static void main(String[] args) {
        getThePath("", 3, 3);
    }
    static void getThePath(String p, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.println(p);
            return;
        }
        if (row > 1 && col > 1) {
            getThePath(p + "Diagonal ", row - 1, col - 1);
        }
        if (col > 1) {
            getThePath(p + "Right ", row, col - 1);
        }
        if(row > 1){
            getThePath(p + "Down ", row - 1, col);
        }
    }
}
