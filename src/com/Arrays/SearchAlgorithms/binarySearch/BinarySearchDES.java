package com.Arrays.SearchAlgorithms.binarySearch;

public class BinarySearchDES {
    public static void main(String[] args) {
        int[] arr = {234, 123, 122, 112, 100, 99, 78, 64, 34, 12, 1, -2, -34};
        int target = -34;
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
            if(target > arr[mid]){
                end = mid - 1;
            } else if (target < arr[mid]) {
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
