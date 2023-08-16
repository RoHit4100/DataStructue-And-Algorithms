package com.Arrays.SearchAlgorithms.linearSearch;

public class LinearSearchString {
    public static void main(String[] args) {
        String str = "rohit";
        char target = 'q';
        System.out.println(search(str, target));

    }
    static boolean search(String str, char target){
        if (str.length() == 0){
            return false;
        }
        for (int i= 0 ; i < str.length(); i++) {   //we can use String method known as str.toCharArray() which converts the string into the character array
            if (target == str.charAt(i)){
                return true;
            }
        }
        return false;
    }
}
