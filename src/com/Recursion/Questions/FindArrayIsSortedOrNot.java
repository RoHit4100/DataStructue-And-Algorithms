package com.Recursion.Questions;

public class FindArrayIsSortedOrNot {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 69 , 9};
        System.out.println(sortedOrNot(arr, 0));
        System.out.println(check(arr));
    }

    static boolean check(int[] arr) {
        return helper(arr, 0,arr.length - 1);
    }

    static boolean helper(int[] arr, int start, int length) {
        if (start == length) {
            return true;
        }
        if (arr[start] <= arr[start + 1]) {
            return helper(arr,  start + 1, length);
        }
        return false;
    }

    // kunal's answer,
    static boolean sortedOrNot(int[] arr, int start) {
        if (start == arr.length - 1) {
            return true;
        }
        return (arr[start] <= arr[start + 1]) && sortedOrNot(arr, start + 1);
    }
}
