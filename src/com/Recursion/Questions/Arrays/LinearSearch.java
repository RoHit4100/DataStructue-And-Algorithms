package com.Recursion.Questions.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 6,33, 77};
        System.out.println(search(arr, 77, 0));
        System.out.println(searchTarget(arr, 77, 0));
    }

    static int search(int[] arr, int target, int start) {
        if (start > arr.length - 1) {
            return -1;
        }
        if (arr[start] == target) {
            return start;
        }
        return search(arr, target, start + 1);
    }

    // Kunal's ans
    static boolean searchTarget(int[] arr, int target, int start) {
        if (start > arr.length - 1) {
            return false;
        }
        return arr[start] == target || searchTarget(arr, target, start + 1);
    }
}
