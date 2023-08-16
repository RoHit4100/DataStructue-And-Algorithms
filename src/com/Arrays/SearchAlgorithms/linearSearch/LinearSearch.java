package com.Arrays.SearchAlgorithms.linearSearch;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int n;
        System.out.println("Enter the number of elements you want to enter in the array.");
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.print("Enter the number that you want to search: ");
        int target = sc.nextInt();
        int ans = search(arr, target);
        if (ans > 0){
            System.out.println("The number is present at " + (ans+1) + " location");
        }else {
            System.out.println("The element is not present in");
        }
    }
    static int search(int[] arr, int target){
        if (arr.length == 0){
            return -1;
        }
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
