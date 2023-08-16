package com.Arrays.SearchAlgorithms.binarySearch;

public class BinarySearchASC {
    public static void main(String[] args) {
        int[] arr = {12, 14, 15, 23, 25, 28, 35, 3566, 345455};
        int target = 35;
        System.out.println(search(arr, target));
    }
    static int search(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] > target){
                end = mid - 1;
            }else if (arr[mid] < target){
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
