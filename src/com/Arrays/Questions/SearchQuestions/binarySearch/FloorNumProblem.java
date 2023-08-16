package com.Arrays.Questions.SearchQuestions.binarySearch;

public class FloorNumProblem {
    public static void main(String[] args) {
        int[] arr = {3, 5, 9, 14, 16, 18};
        int target = 1;
        System.out.println(search(arr, target));
    }
    static int search(int[] arr, int target){
        //floor number means the greatest element that is smaller or equal to the target.
        int start = 0;
        int end = arr.length - 1;
        if (target < arr[start]) {
            return -1;
        }
        while(start <= end){
            int mid = start + (end - start)/2;
            if (arr[mid] < target)
                start = mid + 1;
            else if(arr[mid] > target)
                end = mid - 1;
            else
                return mid;
        }
        return arr[end];
    }
}
