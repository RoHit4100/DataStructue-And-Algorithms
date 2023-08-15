package com.arrays.Questions.SearchQuestions.binarySearch;

public class FindMinInDuplicateRotatedArr {
    public static void main(String[] args) {
        int[] nums = {3,1,3};
        System.out.println(findMin(nums));
    }
    static int findMin(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        if(arr[0] <= arr[end])
            return arr[0];
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid < end && arr[mid] > arr[mid + 1])
                return arr[mid + 1];
            if(mid > start && arr[mid] < arr[mid - 1])
                return arr[mid];
            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                if(arr[start] > arr[start + 1]){
                    return arr[start + 1];
                }
                start++;
                if(arr[end] < arr[end - 1]){
                    return arr[end];
                }
                end--;
            }
            if(arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]){
                start = mid - 1;
            }else
                end = mid + 1;
        }
        if(arr[start] < arr[start + 1])
            return arr[start];
        return arr[0];
    }
}
