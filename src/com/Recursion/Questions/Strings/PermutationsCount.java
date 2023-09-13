package com.Recursion.Questions.Strings;

public class PermutationsCount {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(getTheCountOfPermutations("", str));
    }

    static int getTheCountOfPermutations(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        char ch = up.charAt(0);
        int count = 0;
        for (int i = 0; i <= p.length(); i++) {
            String firstPart = p.substring(0, i);
            String secondPart = p.substring(i);
            count = count + getTheCountOfPermutations(firstPart + ch + secondPart, up.substring(1));
        }
        return count;
    }
}
