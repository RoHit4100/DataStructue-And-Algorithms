package com.RecursionToIteration;

import java.util.ArrayList;
import java.util.List;

public class SumOfSubSet {
    // Time complexity and Space complexity ===> O(n * 2^n)
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> ans = getTheSubSet(arr);
        // System.out.println(ans);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }

    static List<List<Integer>> getTheSubSet(int[] arr) {
        // We are creating list of list, because outer list will contain the list of permutations or combinations.
        List<List<Integer>> outer = new ArrayList<>();
        // first we will add an empty list in our outer list.
        outer.add(new ArrayList<>());
        // we will run for loop for each and every element of the array.
        for (int num : arr) {
            // we will take the size of the outer list because, if n = 2, we will have to add 2 new list into the outer list, and so on.
            // e.g. [[], [1]] ===> [[], [1], [2], [2,3]]
            int n = outer.size();
            // now we will run an internal loop for the internal list till size n.
            for (int i = 0; i < n; i++) {
                // we will fetch the i th list from the outer list.
                List<Integer> internal = new ArrayList<>(outer.get(i));
                // and after that we will add the current number into the new internal list.
                internal.add(num);
                // after that we will add that newly created list into the outer list.
                outer.add(internal);
            }
        }
        // In the end we will return the outer list.
        return outer;
    }
}
