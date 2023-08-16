package com.arrays.Questions.SortQuestions.CyclicSort;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(firstMissingNum(arr));;
    }

    static int firstMissingNum(int[] arr) {
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] > 0 && arr[i] >= arr.length && arr[i] != arr[correct]){
                swap(arr, i, correct);
            }else{
                i++;
            }
        }
        // After sorting the array I will check whether the element is in its right location or not.
        for(int j = 0; j < arr.length; j++){
            if(arr[j] != j + 1 && arr.length > 1){
                return j + 1;
            }else if(arr.length == 1){
                return arr.length + 1;
            }
        }
        return arr.length;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
