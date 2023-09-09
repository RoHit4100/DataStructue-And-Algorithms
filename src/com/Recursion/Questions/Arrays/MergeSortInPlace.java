package com.Recursion.Questions.Arrays;

import java.util.Arrays;

public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /*
        To sort array without creating new array we are using pointers to manipulate the array.
            We are using start and end to divide the array into small parts until,
            end - start == 1;
            e.g. 5 - 4 == 1, means there is only one element left into the array.

            The mid is going to be,
            (start + end) / 2
            e.g. 0 + 5 / 2 == 2

            we are going to divide the array until there is one element left into the array.
            so we will call our function to divide with parameters,
            mergeSort(arr, start, end)

            if termination condition is not encounter means we have to divide,
            for right part,
                mergeSort(arr, start, mid);
            for left part,
                mergeSort(arr, mid, end);
     */
    static void mergeSort(int[] arr, int start, int end) {
        if (end - start == 1) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    /*
        After dividing the array we have to sort that part of array and store into the another array,
        e.g. lets consider, [4, 5] & [1, 2, 3]
                            s         m      e
             we got this after dividing the array, now we have to compare elements from this array and add those elements into new array.
        So which parameters I need to pass into merge method,
            merge(arr, s, m, e)
        now we have to get pointers for s, m and e
        [4, 5] & [1, 2, 3]
        s        m      e
        i = s
        j = m
        k = 0
        now we have to take 1 new pointer for the new created array.
        l --> for replacing with right value.

        now we will check if element of two parts of the array are smaller than or greater than each other, we will check this until,
            i < m && j < e --->(I is going till m only) (j is going till e only)
                we will check if the elements are on its correct index or not,
                if they are at the correct index we will add those elements into new array,
                mix[] ------> which will have the size of e - s ----> (6 - 3 === 3)
        after finishing one of the array rest of the element will be added into the mix[]

        To enter elements into the original arr we have to do like,
            arr[s + k] = mix[k] -----------> where mix is the new created array.
            e.g. [3, 2]  [2, 3]
                 s = 3 , k = 0
                 arr[3 + 0] = arr[0]
     */
    static void merge(int[] arr, int start, int mid, int end) {
        int[] mix = new int[end - start];
        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else if (arr[i] > arr[j]) {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j < end) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        // To add elements into the original array from the mix.
        System.arraycopy(mix, 0, arr, start, mix.length);
//        for (int l = 0; l < mix.length; l++) {
//          arr[start + l] = mix[l];
//        }
    }
}
