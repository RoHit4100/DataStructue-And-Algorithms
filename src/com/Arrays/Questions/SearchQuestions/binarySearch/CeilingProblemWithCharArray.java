package com.Arrays.Questions.SearchQuestions.binarySearch;

public class CeilingProblemWithCharArray {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'e', 'j'};
        char target = 'z';
        System.out.println(ceiling(arr, target));
    }
    // In this problem we are just replacing int array with character array and the condition little bit which is
    // here we are going to find only the element which is smallest greater element than target not equal element.
    // And one more condition is that array is wrap around means
    // let's say ['a', 'b', 'e', 'j'] and target is 'k' then there no element present which is greater than target
    // in this case the ans will be the first index.
    // we can achieve this by using %
    // when condition is violated means start becomes the length of the array then we can just simply say
    // 4 % arr.length = 4 % 4 = 0

    static char ceiling(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (letters[mid] < target) {
                start = mid + 1;
            } else if (letters[mid] > target) {
                end = mid - 1;
            }
        }
//        if (start == letters.length) {
//            return letters[0];
//        }
//        return letters[start];
//        or
        return letters[start % letters.length];
    }
}
