package com.Recursion.Questions.Strings;

import java.util.ArrayList;

public class SubSequenceWithAsciiValue {
    public static void main(String[] args) {
//        printSubSequence("", "abc");
        System.out.println(printSubSequenceInArr("", "abc"));
        ArrayList<String> list = new ArrayList<>();
        System.out.println(printSubStringWithAscii("abcd", list));
    }

    static void printSubSequence(String newString, String givenString) {
        if (givenString.isEmpty()) {
            System.out.println(newString);
            return;
        }
        char ch = givenString.charAt(0);
        printSubSequence(ch + newString, givenString.substring(1));
        printSubSequence(newString, givenString.substring(1));
        printSubSequence(newString + (ch + 0), givenString.substring(1));
    }

    static ArrayList<String> printSubSequenceInArr(String newString, String givenString) {
        if (givenString.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(newString);
            return list;
        }
        char ch = givenString.charAt(0);
        ArrayList<String> left = printSubSequenceInArr(ch + newString, givenString.substring(1));
        ArrayList<String> right = printSubSequenceInArr(newString, givenString.substring(1));
        ArrayList<String> ascii = printSubSequenceInArr(newString + (ch + 0), givenString.substring(1));

        left.addAll(right);
        left.addAll(ascii);
        return left;
    }

    static ArrayList<String>  printSubStringWithAscii(String givenString, ArrayList<String> list){
        if (givenString.isEmpty()) {
            list.add("");
            return list;
        }
        char ch = givenString.charAt(0);
        ArrayList<String> left = printSubSequenceInArr(ch + "", givenString.substring(1));
        ArrayList<String> right = printSubSequenceInArr("", givenString.substring(1));
        ArrayList<String> ascii = printSubSequenceInArr("" + (ch + 0), givenString.substring(1));

        left.addAll(right);
        left.addAll(ascii);
        return left;
    }
}
