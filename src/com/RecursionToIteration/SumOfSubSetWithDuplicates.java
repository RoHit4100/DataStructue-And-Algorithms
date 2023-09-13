package com.RecursionToIteration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfSubSetWithDuplicates {
    public static void main(String[] args) {
       int[] arr = {1, 2, 2};
       List<List<Integer>> ans = getTheSubsetWithDuplicates(arr);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }

    static List<List<Integer>> getTheSubsetWithDuplicates(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        // First we will add an empty string into the list,
        outer.add(new ArrayList<>());
        // We will initialize the pointer to update the start and end, start and end will help to keep track for previous end index.
        int start = 0;
        int end = 0;
        // Now we will run a for loop for every element in the arr.
        for (int i = 0; i < arr.length; i++) {
            // now we have to check if the previous element same as current element or not.
            if (i > 0 && arr[i] == arr[i - 1]) {
                // If the previous element is same as the current element we will then consider start from the end + 1
                // e.g. [[], [1], [2], [1, 2]] now if we take 2 then we don't have to the add 2 from the start of the list as,
                //      it will get repeat, so instead of 0 we can start from the end, which is going to be 1 index of the list.
                start = end + 1;
            }
            // we will assign previous length of the outer list to the end.
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
