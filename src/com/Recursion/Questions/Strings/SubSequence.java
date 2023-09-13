package com.Recursion.Questions.Strings;

import java.util.ArrayList;

public class SubSequence {
    public static void main(String[] args) {
        findSubSequence2("abc", new ArrayList<>());
    }

    static void findSubSequence(String newString, String givenString) {
        if (givenString.isEmpty()) {
            System.out.println(newString);
            return;
        }
        char ch = givenString.charAt(0);
        findSubSequence(ch + newString, givenString.substring(1));
        findSubSequence(newString, givenString.substring(1));
    }

    static ArrayList<String> findSubSequence2(String givenString, ArrayList<String> list) {
        if (givenString.isEmpty()) {
            list.add("");
        }

        char ch = givenString.charAt(0);
        findSubSequence(ch + "", givenString.substring(1));
        findSubSequence("", givenString.substring(1));
        return list;
    }
}
