package com.Arrays.SearchAlgorithms.linearSearch;

public class SearchMinAndMaxNumber {
    public static void main(String[] args) {
        int[] arr = {23, 4, 5, 34, 654, 54, 456, 677};
        System.out.println("Your minimum number is " + min(arr));
        System.out.println("Your maximum number is " + max(arr));
    }
    static int min(int[] arr){
        if(arr.length == 0){
            return -1;
        }
        int n = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(n > arr[i]){
                n = arr[i];
            }
        }
        return n;
    }
    static int max(int[] arr){
        if(arr.length == 0){
            return -1;
        }
        int n = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(n < arr[i]){
                n = arr[i];
            }
        }
        return n;
    }
}
