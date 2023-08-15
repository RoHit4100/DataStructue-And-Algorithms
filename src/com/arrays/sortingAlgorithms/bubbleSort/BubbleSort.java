package com.arrays.sortingAlgorithms.bubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 23, 3, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*
        In bubble sort we compare previous element with current element and if the current element is less
        than the previous element we swap them.
     */
    static void sort(int[] arr) {
        // Time complexity for this algorithm is O(n^2)
        // Two values will be maintained by this algo, which are I, J
        // I is for the number of iterations to sort the array.
        // In this algorithm at each step means at each iteration of I, the max number will go at the last.
        // J is for the number of times items are going swap and compare.

        // run n - 1 times
        for (int i = 0; i < arr.length; i++) {
            // run n - 1 - i times
            boolean isSwap = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }
}
