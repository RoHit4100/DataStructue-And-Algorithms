package com.Recursion.Questions.Strings;

import java.util.ArrayList;

public class PermutationsWithArrayList {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(getThePermutations("", str));
    }

    static ArrayList<String> getThePermutations(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        // This ArrayList will be local to every function call
        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String firstPartOfP = p.substring(0, i);
            String secondPartOfP = p.substring(i);
            ans.addAll(getThePermutations(firstPartOfP + ch + secondPartOfP, up.substring(1)));
        }
        return ans;
    }
}
