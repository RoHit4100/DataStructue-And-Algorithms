package com.Arrays.Questions.SearchQuestions.binarySearch;

public class PeakIndexOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3 ,5 ,6, 4, 3, 2};
        System.out.println(findPeak(arr));
    }
    static int findPeak(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid = start + (end - start)/2;
            if (arr[mid] > arr[mid + 1]) {
                /*
                This condition means you are in descending part of the arr, means this may be the ans but still search at the left.
                Because all the elements from mid + 1 are going to be less than the max number.
                 */
                end = mid;
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            }
        }
        /*
        In the end start == end, means they both are pointing to the max number from the arr
         */
        return arr[end];
    }
}
