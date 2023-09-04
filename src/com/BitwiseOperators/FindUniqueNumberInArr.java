package com.BitwiseOperators;

public class FindUniqueNumberInArr {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 3, 5, 5, 4, 7, 1};
        System.out.println(find(arr));
    }
    /*
        In these question we are using the XOR operator because if we XOR a number with its same number we will get 0.
        and the unique number will not get converted into 0.
        example of this same kind of problem is,
        e.g. To find unique number from this array we will add every element of the array with each other, at last we will just get
        the unique number because it will not get converted into the 0.
            arr = {-1, 1, 4, 3, -4}

     */
    static int find(int[] arr){
        int unique = 0;
        for (int n : arr) {
            unique ^= n;
        }
        return unique;
    }
}
