package com.Recursion.Questions;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 6, 8, 32, 34, 334, 554, 5344, 5345, 353535 };
        System.out.println(search(arr, 80989, 0, arr.length - 1));
    }

    static int search(int[] arr, int target, int start, int end) {
        int mid = start + (end - start) / 2;
        if(arr.length == 0 || start > end)
            return -1;
        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] < target){
            return search(arr, target, mid + 1, end);
        }else{
            return search(arr, target, 0, mid - 1);
        }
    }
}
