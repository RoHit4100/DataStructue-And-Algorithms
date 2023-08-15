package com.arrays.Questions.SearchQuestions.binarySearch;

public class CeilingProblem {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 6;
        System.out.println(search(arr, target));
    }

    static int search(int[] arr, int target) {
        //ceiling number means the smallest number which is greater or equal to the target number.
        int start = 0;
        int end = arr.length - 1;
        if (target > arr[end]) {
            return -1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return arr[start];
    }
}
