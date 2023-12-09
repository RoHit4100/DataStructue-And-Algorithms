package com.StackNQueues.Questions;

import java.util.Arrays;

public class SumOfTwoStack {
    public static void main(String[] args) {
        int maxSum = 130;
        int[] a = {60, 90, 120};
        int[] b = {100, 10, 10, 250};
        System.out.println(getTheCountOfSum(maxSum, a, b));
    }

    static int getTheCountOfSum(int maxSum, int[] a, int[] b) {
        return helper(maxSum, a, b, 0, 0) - 1;
    }

    private static int helper(int maxSum, int[] a, int[] b, int sum, int count) {
        if (sum > maxSum) {
            return count;
        }
        if (a.length == 0 || b.length == 0) {
            return count;
        }
        int ans1 = helper(maxSum, Arrays.copyOfRange(a, 1, a.length), b, a[0] + sum, count + 1);
        int ans2 = helper(maxSum, a, Arrays.copyOfRange(b, 1, b.length), b[0] + sum, count + 1);

        return Math.max(ans1, ans2);
    }
}
