package com.Recursion.Questions.Arrays;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /*
        What is quicksort?
            In quick sort we select a pivot element, which can be any element which lies in the array.
            In our example we are taking middle element as the pivot element.
            [5, 4, 3, 2, 1]
            pivot = 3
            In this solution we will take 4 pointer 2 for the high and low, and 2 for start and end.
            high and low are the initial index which are fixed which shows the first element and the last element of the array.
            start and end are the pointer which are going to use for the comparing and swapping.
     */
    static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = arr[mid];
        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        // When this loop is violated start > end
        // e.g 4 > 3
        // So we will sort first part which low till end
        // And for the second part which is start till high
        // For recursive calls
        sort(arr, low, end);
        sort(arr, start, high);
    }
}
