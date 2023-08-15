package com.arrays.Questions.SearchQuestions.binarySearch;

public class RotationCountOfRotatedArr {
    public static void main(String[] args) {
        int[] arr = {15, 22};
        System.out.println(findRotationCount(arr));
    }

    static int findRotationCount(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        if(end == 0)
            return start;
        while(start <= end){
            int mid = start + (end - start)/2;
            if (mid >= start && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            } else if (mid <= end && arr[mid] < arr[mid - 1]) {
                return mid;
            } else if (arr[start] > arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }
}
