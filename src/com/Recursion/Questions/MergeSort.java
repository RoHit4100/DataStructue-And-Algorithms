package com.Recursion.Questions;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    /*
        What is merge sort?
            In merge sort we divide array into two parts, same goes till there is 1 element left in the array.
            after that we will compare those elements and merge them into left part and right part respectively.
               e.g. [4, 3, 2, 1]
               [4, 3]   [2, 1]
               [4][3]   [2][1]
     */
    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        // To compare elements from the both array, if element is smaller than the element of other array add that element to new array.
        // We will check and add elements until one array is completed.
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                // If element of first array is smaller than the element of second array then we will add that element into mix and move
                // i --> i + 1;
                mix[k] = first[i];
                i++;
            } else if (first[i] > second[j]) {
                mix[k] = second[j];
                j++;
            }
            // after every step we are adding one element into mix.
            k++;
        }
        // After finishing one of the array all element of remaining array will be added to the new array.
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
}
