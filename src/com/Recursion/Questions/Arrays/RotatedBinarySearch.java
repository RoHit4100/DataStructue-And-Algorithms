package com.Recursion.Questions.Arrays;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 1, 2, 3, 4};
        System.out.println(binarySearchForRotatedArr(arr, 3, 0, arr.length - 1));
    }

    /*
        What are the cases that we are going to encounter while searching element in the rotated array.
        [ 6, 7, 8, 1, 2, 3, 4]

        1. If the middle element is greater than the first element,
           i.e. arr[start] < arr[mid]:
             then we have to check whether the element is in first half,
                i.e. arr[start] < target && target < arr[mid]
                --> if target is present in first half then,
                --> end = mid - 1
             if not in first half then search in the second half,
                i.e. arr[mid] < target && arr[end] > target
                --> if target is present in the second half then,
                --> start = mid + 1
         2. If the middle element is smaller than the first element,
            i.e. arr[mid] < arr[start] && target > arr[mid] && target <= arr[mid]
            --> start = mid + 1
         3. If the target element is greater than the middle element
            --> end = mid - 1
     */
    static int binarySearchForRotatedArr(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }
        int mid = s + (e - s)/ 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[s] < arr[mid]) {
            if (target >= arr[s] && target <= arr[mid]) {
                return binarySearchForRotatedArr(arr, target, s, mid - 1);
            }else {
                return binarySearchForRotatedArr(arr, target, mid + 1, e);
            }
        }
        if (target >= arr[mid] && target <= arr[e]) {
            return binarySearchForRotatedArr(arr, target, mid + 1, e);
        }
        return binarySearchForRotatedArr(arr, target, s, mid - 1);
    }
}
