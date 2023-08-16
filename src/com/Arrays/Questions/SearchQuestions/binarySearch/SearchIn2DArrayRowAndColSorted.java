package com.Arrays.Questions.SearchQuestions.binarySearch;

import java.util.Arrays;

public class SearchIn2DArrayRowAndColSorted {
    // This is the solution for the 2D array which is sorted by the row and col at the same time.
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };
            int target = 37;
            int[] ans = search(arr, target);
            System.out.println(Arrays.toString(ans));
    }

    static int[] search(int[][] arr, int target) {
        int start = 0;
        int end = arr[0].length - 1;
        while (start < arr.length && end >= 0) {
            if (arr[start][end] > target) {
                end--;
            } else if (arr[start][end] < target) {
                start++;
            } else {
                return new int[]{start, end};
            }
        }
        return new int[]{-1, -1};
    }
}
