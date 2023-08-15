package com.arrays.sortingAlgorithms.selectionSort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 534,4, 444,32,42, 532, 7777};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*
        In selection sort we select the maximum or minimum element from the array and swap that element with
        its correct index.
     */
    static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            // for swapping with its correct index i.e its last index.
            int last = arr.length - 1 - i;
            // for finding the max no index
            int maxIndex = findMaxIndex(arr, last);
            swap(arr, maxIndex, last);
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int findMaxIndex(int[] arr, int end){
        int max = 0;
        for (int i = 0; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
}
