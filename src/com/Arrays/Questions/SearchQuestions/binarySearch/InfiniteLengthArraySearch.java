package com.Arrays.Questions.SearchQuestions.binarySearch;

public class InfiniteLengthArraySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7 ,8, 10, 15, 23, 33, 453};
        int target = 453;
//        System.out.println(searchKunalSol(arr, target));
        System.out.println(search(arr, target));
    }
    /*
    In this question we have to find the target element in the infinite length array, means we can't use arr.length method
    So to solve this problem we have to just search the target element in chunks, for that we have to first find the
        start and end location.
     */
    static int search(int[] arr, int target){
        int start = 0;
        int end = 1;
        while(start <= end){
            if(arr[end] < target){
                int temp = end + 1;
                end = end + (end - start + 1) * 2; //(end - start + 1) == size of the current box
                start = temp;
            }else{
                int mid = start + (end - start)/2;
                if (mid < end && arr[mid] < target) {
                    start = mid + 1;
                } else if (arr[mid] > target) {
                    end = mid - 1;
                }else{
                    return mid;
                }
            }
        }
        return -1;
    }
    static int searchKunalSol(int[] arr, int target){
        int start = 0;
        int end = 1;
        while (target > arr[end]) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
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
