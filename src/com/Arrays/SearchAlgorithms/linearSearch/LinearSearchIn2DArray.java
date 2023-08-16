package com.Arrays.SearchAlgorithms.linearSearch;

import java.util.Arrays;

public class LinearSearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {23, 3, 4, 5},
                {34,7,8,89},
                {98, 56}
        };
        int target = 56;
        System.out.println(Arrays.toString(search(arr, target)));
    }
    static int[] search(int[][] arr, int target){
        if (arr.length == 0){
            return new int[]{-1};
        }
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == target){
                    return new int[]{i , j};
                }
            }
        }
        return new int[]{-1};
    }
}
