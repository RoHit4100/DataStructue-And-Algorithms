package com.Arrays.SearchAlgorithms.linearSearch;

public class LinearSearchInRange {
    public static void main(String[] args) {
        int[] arr = {2, 4, 253, 3, 45, 23, 232424};
        int target = 45;
        System.out.println(searchInRange(arr, target, 2, 3));
    }

    static boolean searchInRange(int[] arr, int target, int start, int end){
        if(arr.length == 0){
            return false;
        }
        if(start > end){
            return false;
        }
        for(int i = start; i <= end; i++){
            if(arr[i] == target){
                return true;
            }
        }
        return false;
    }
}
