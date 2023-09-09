package com.Recursion.Questions.Arrays;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        System.out.println(Arrays.toString(sort(arr)));
    }

    static int[] sort(int[] arr) {
        return bubble(arr, arr.length - 1, 0);
    }

    static int[] bubble(int[] arr, int row, int col) {
        if (row == 0) {
            return arr;
        }
        if (row > col) {
            if (arr[row] < arr[col]) {
                swap(arr, row, col);
                return bubble(arr, row, col + 1);
            } else {
                return bubble(arr, row, col + 1);
            }
        }else {
            return bubble(arr, row - 1, 0);
        }
    }

    static void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}
