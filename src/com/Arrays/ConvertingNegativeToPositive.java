package com.Arrays;

import java.util.Arrays;

public class ConvertingNegativeToPositive {
    public static void main(String[] args) {
        int[] arr = {3, -4, -2, 23, 3, 1};
        convert(arr);
        System.out.printf(Arrays.toString(arr));
        System.out.println(Math.abs(-1));
    }

    static void convert(int[] arr) {
        int length = arr.length;
        int sum;
        sum = length * (length + 1) / 2;
        for(double i : arr){
            if(i < 0){
                i = Math.sqrt(Math.pow(i, 2));
            }
        }
    }
}
