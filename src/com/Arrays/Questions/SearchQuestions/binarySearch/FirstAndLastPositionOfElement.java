package com.Arrays.Questions.SearchQuestions.binarySearch;

import java.util.Arrays;

public class FirstAndLastPositionOfElement {
    public static void main(String[] args) {
        int[] arr ={5, 7, 7, 7, 7, 8, 8, 9};
        int target = 8;
        System.out.println(Arrays.toString(searchByPosition(arr, target)));
    }

    /*
    In this problem we have to find the first and last appearance of the target number
    eg, [1, 3, 3, 3, 8]
    answer should be arr of first and last repetition of that number means [1, 3]
     */
    static int[] searchByPosition(int[] arr, int target) {
        int firstRepLoc = search(arr, target, true);
        int endRepLoc = search(arr, target, false);

        return new int[]{firstRepLoc, endRepLoc};
    }
    static int search(int[] arr, int target, boolean isFirstRep) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                if(isFirstRep){
                    end = mid - 1;
                }else
                    start = mid + 1;
            }
        }

        return ans;
    }
}
