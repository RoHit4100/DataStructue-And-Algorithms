package com.Arrays.Questions.SearchQuestions.linearSearch;

public class FindEvenDigits {
    public static void main(String[] args) {
        int[] arr = {1232, 34, 5, 45, 653, 4, 45, 5, 563, 489072};
        System.out.println(search(arr));
    }
    static int search(int[] arr){
        if (arr.length == 0){
            return -1;
        }
        int count = 0;
        for (int i : arr){
            if (countDigit(i)) {
                count++;
            }
        }
        return count;
    }
    static boolean countDigit(int n){
        int count = 0;
        while(n > 0){
            n /= 10;
            count++;
        }
        return even(count);
    }
    static boolean even(int count){
        return count % 2 == 0;
    }
}
