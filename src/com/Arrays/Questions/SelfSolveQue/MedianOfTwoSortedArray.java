package com.Arrays.Questions.SelfSolveQue;

import java.util.ArrayList;
import java.util.Arrays;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int newLength = arr1.length + arr2.length;
        int[] arr3 = new int[newLength];
        int start = 0;
        int end = newLength - 1;
        int mid = start + (end - start)/2;
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
        Arrays.sort(arr3);
        if (newLength % 2 == 0) {
            return (double) (arr3[mid] + arr3[mid + 1]) / 2;
        }
        return (double) arr3[mid];
    }
}
