package com.Arrays.SortingAlgorithms.insertionSort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 23, 3, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*
        This algo have the time complexity of O(n^2)
        This algo sort the arr in chunks we can say means,
            lets take two values,
            I => for the number of steps
            J => it is the pointer which compares the current value with the previous value, but it is checking till
                j > 0; because it is decrementing by one after each comparison.
     */
    static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }else {
                    break;
                }
            }
        }
    }
}
