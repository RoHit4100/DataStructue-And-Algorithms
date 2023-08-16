package com.Arrays.SortingAlgorithms.cyclicSort;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*
        In these algo we will check whether the current number at which we are present, is at its correct location or not
        If it is not at its correct location then we will swap that number with its correct location.

        NOTE: if in question, [0, N] is mention at any point then it is clearly suggesting that it is cycling sort question.

        To find solution of this question we are going to sort this unsorted array in just one go, means in only one while or for loop.

        The correct location of the current element will be arr[i] - 1;
        e.g 5, 1, 3, 4, 2
            what will the correct location of 5 = 5 - 1;
            if this is the case we will swap that element with its correct index.

            if not then we will just move ahead. to check another element.
     */
    static void sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }
            i++;
        }
    }
}
