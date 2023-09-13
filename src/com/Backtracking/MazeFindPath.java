package com.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class MazeFindPath {
    public static void main(String[] args) {
        getThePath("", 2, 2);
        System.out.println(getThePathWithArrList("",3,3));
    }

    static void getThePath(String p, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.println(p);
            return;
        }
        if (col > 1) {
            getThePath(p + 'R', row, col - 1);
        }
        if(row > 1){
            getThePath(p + 'D', row - 1, col);
        }
    }

    static ArrayList<String> getThePathWithArrList(String p, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();

        if (col > 1) {
            ans.addAll(getThePathWithArrList(p + 'R', row, col - 1));
        }
        if(row > 1){
            ans.addAll(getThePathWithArrList(p + 'D', row - 1, col));
        }
        return ans;
    }
}
