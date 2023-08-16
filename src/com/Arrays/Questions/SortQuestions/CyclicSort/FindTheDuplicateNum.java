package com.Arrays.Questions.SortQuestions.CyclicSort;

public class FindTheDuplicateNum {
    public static void main(String[] args) {
        int[] arr = {3,1,3,4,2};
        System.out.println(findDuplicate(arr));
    }
    static int findDuplicate(int[] arr) {
        int i = 0;
        while(i < arr.length){
            int correct = arr[i];
            if(arr[i] != arr[correct]){
                swap(arr, i, correct);
            }else{
                i++;
            }
        }
        // After sorting the array the duplicate number will come at the first position
        return arr[0];
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
