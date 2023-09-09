package com.Recursion.Questions.Strings;

public class SkipEntireString {
    public static void main(String[] args) {
        System.out.println(skipApple("I like to eat apple"));
        System.out.println(skipAppNotApple("I like to eat apples but I dont like other app"));

    }

    static String skipApple(String string) {
        if (string.isEmpty()) {
            return "";
        }
        char ch = string.charAt(0);
        if (string.startsWith("apple")) {
            return skipApple(string.substring(5));
        } else if (string.startsWith("Apple")) {
            return skipApple(string.substring(5));
        }else {
            return ch + skipApple(string.substring(1));
        }
    }

    static String skipAppNotApple(String string) {
        if (string.isEmpty()) {
            return "";
        }
        if (string.startsWith("app") && !string.startsWith("apple")) {
            return skipAppNotApple(string.substring(3));
        }else{
            return string.charAt(0) + skipAppNotApple(string.substring(1));
        }
    }
}
