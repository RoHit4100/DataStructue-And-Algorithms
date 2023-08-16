package com.Arrays.Questions.SortQuestions.CyclicSort;
public class FirstMissingNumber {
    public static void main(String[] args) {
        int[] arr = {3, 4, 0, 1};
        System.out.println(sortAndCheck(arr));
    }
    static int sortAndCheck(int[] arr) {
        int i = 0;
        int length = arr.length;
        while (i < length) {
            int correct = arr[i];
            if (arr[i] < length && arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }else{
                i++;
            }
        }
        return checkMissingNumber(arr);
    }

    static int checkMissingNumber(int[] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            if (arr[i] == i) {
                continue;
            }
            return i;
        }
        return arr.length;
    }
}

