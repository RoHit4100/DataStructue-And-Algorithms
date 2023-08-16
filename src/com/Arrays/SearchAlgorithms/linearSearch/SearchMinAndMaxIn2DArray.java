package com.Arrays.SearchAlgorithms.linearSearch;

public class SearchMinAndMaxIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {23, 3, 4, 5},
                {34,7,8,89},
                {98, 56}
        };
        System.out.println(searchMin(arr));
        System.out.println(searchMax(arr));
    }
    static int searchMin(int[][] arr){
        if (arr.length == 0){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int[] i: arr){
            for (int j: i){
                if(j < min){
                   min = j;
                }
            }
        }
        return min;
    }
    static int searchMax(int[][] arr){
        if (arr.length == 0){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for (int[] i: arr){
            for (int j: i){
                if(j > max){
                   max = j;
                }
            }
        }
        return max;
    }
}
