package com.Recursion.Questions.Strings;

public class Permutations {
    public static void main(String[] args) {
        String str = "abc";
        findThePermutations("", str);
    }

    static void findThePermutations(String p, String up) {
        // we will checker whether the unprocessed string is empty or not if it is empty we will just print the process string and return to
        // the location where we were call previously.
        if (up.isEmpty()) {
            // we will print the process string.
            System.out.println(p);
            return;
        }
        // take the first character from the first string.
        char ch = up.charAt(0);
        // Run the loop till the length of the process string as it determines the number of the calls need to make for the level.
        // e.g. "ab"==>will have the 3 calls.
        for (int i = 0; i <= p.length() ; i++) {
            // Crop the first part of the string which will be from 0 till i th location.
            String firstPartOfString = p.substring(0, i);
            // Crop the second part of the string which will be from i till end of the string.
            String secondPartOfString = p.substring(i);
            // call the recursive function with new processed string which will be,
            // firstPartOfTheString + first character of the string + secondPartOfTheString.
            findThePermutations(firstPartOfString + ch + secondPartOfString, up.substring(1));
        }
    }
}
