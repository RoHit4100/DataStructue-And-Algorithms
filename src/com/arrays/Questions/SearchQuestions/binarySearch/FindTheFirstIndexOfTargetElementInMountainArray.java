package com.arrays.Questions.SearchQuestions.binarySearch;

public class FindTheFirstIndexOfTargetElementInMountainArray {
    public static void main(String[] args) {
        int[] mountainArr = {1, 5, 3, 1};
        int target = 3;
        System.out.println(findPeakIndex(mountainArr, target));
    }
    /*
    In this question the mountainArr = [1, 2, 3, 4, 5, 3, 1] and target is = 3;
    The answer should be the first appearance of that number, means we have to return the first time this number appear
    in the mountainArray.
    solution: We have given that mountainArray is mountain mountainArray means sorted in both format.
    To solve this question we first need to find the max number of this mountainArray and make that index the end and find the
    target element in that block, if that target is not present in that block then just find in left block by making
    that index start.
     */
    static int findPeakIndex(int[] mountainArr, int target) {
        int start = 0;
        int end = mountainArr.length - 1;
        while(start < end){
            int mid = start + (end - start)/2;
            if (mountainArr[mid] < mountainArr[mid + 1]) {
                start = mid + 1;
            } else if (mountainArr[mid] > mountainArr[mid + 1]) {
                end = mid;
            }
        }
        if(binarySearch(mountainArr,target, 0, end) == -1){
            return binarySearch(mountainArr,target, start, mountainArr.length - 1);
        } else {
            return binarySearch(mountainArr,target, 0, end);
        }
    }
    static int binarySearch(int[] arr, int target, int start, int end){
        boolean isAsc = arr[start] < arr[end];
        while (start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(isAsc){
                if(arr[mid] > target){
                    end = mid - 1;
                }else if (arr[mid] < target){
                    start = mid + 1;
                }
            }else{
                if(arr[mid] < target){
                    end = mid - 1;
                }else if (arr[mid] > target){
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}

