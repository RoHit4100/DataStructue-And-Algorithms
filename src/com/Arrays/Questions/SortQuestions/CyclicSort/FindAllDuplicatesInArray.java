package com.Arrays.Questions.SortQuestions.CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr));
    }
    static List<Integer> findDuplicates(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != i + 1) {
                int correct = arr[i] - 1;
                if (arr[correct] != arr[i]) {
                    swap(arr, i, correct);
                }else{
                    if(!list.contains(arr[i])){
                        list.add(arr[i]);
                    }
                    i++;
                }
            }else{
                i++;
            }
        }
        return list;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
