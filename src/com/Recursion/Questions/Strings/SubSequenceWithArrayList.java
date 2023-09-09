package com.Recursion.Questions.Strings;

import java.util.ArrayList;

public class SubSequenceWithArrayList {
    public static void main(String[] args) {
        System.out.println(findSubSequence("", "ab"));
    }

    static ArrayList<String> findSubSequence(String newString, String givenString) {
        if (givenString.isEmpty()) {
            // In this problem we are creating new arraylist and storing all the last values of the recursive tree.
            ArrayList<String> list = new ArrayList<>();
            list.add(newString);
            // After adding the elements we are going to return that list to the location were it was called.
            return list;
        }
        // For left part of the array list
        ArrayList<String> left = findSubSequence(givenString.charAt(0) + newString, givenString.substring(1));
        // For right part of the list
        ArrayList<String> right = findSubSequence(newString, givenString.substring(1));
        // Combining both list.
        left.addAll(right);
        return left;
    }
}
