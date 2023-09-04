package com.Simple;

import java.util.Arrays;

public class RemoveZeros {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 13};
        remove(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void remove(int[] arr) {
        int lastIndex = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                swap(arr, i, lastIndex);
                lastIndex--;
            }
        }
    }

    static void swap(int[] arr, int start, int second) {
        int temp = arr[start];
        arr[start] = arr[second];
        arr[second] = temp;
    }
}
