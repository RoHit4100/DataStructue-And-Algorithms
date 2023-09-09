package com.Recursion.Questions.Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSequence {
    public static void main(String[] args) {
        findSubSequence("", "abc");
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

    static ArrayList<String> findSubSequence2(String newString, String givenString, ArrayList<String> list) {
        if (givenString.isEmpty()) {
            list.add(newString);
        }
        return list;
    }
}
