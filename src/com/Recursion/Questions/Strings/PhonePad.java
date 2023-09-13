package com.Recursion.Questions.Strings;

import java.util.ArrayList;
import java.util.List;

public class PhonePad {
    public static void main(String[] args) {
        String str = "23";
        System.out.println(letterCombinations(str));
    }

    static List<String> letterCombinations(String up) {
        if(up.isEmpty())
            return new ArrayList<>();
        return helper("", up);
    }
    static List<String> helper(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        // This will convert something like '2' into 2
        ArrayList<String> ans = new ArrayList<>();
        int digit = up.charAt(0) - '0';
        if(digit >= 2 && digit <= 6){
            for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
                char ch = (char)('a' + i);
                ans.addAll(helper(p + ch, up.substring(1)));
            }
        }else if(digit == 7){
            for (int i = (digit - 2) * 3; i <= (digit - 1) * 3; i++) {
                char ch = (char)('a' + i);
                ans.addAll(helper(p + ch, up.substring(1)));
            }
        }else if(digit == 8){
            for (int i = ((digit - 2) * 3) + 1; i <= (digit- 1) * 3; i++) {
                char ch = (char)('a' + i);
                ans.addAll(helper(p + ch, up.substring(1)));
            }
        }else if(digit == 9){
            for (int i = ((digit - 2) * 3) + 1; i <= ((digit - 1) * 3) + 1; i++) {
                char ch = (char)('a' + i);
                ans.addAll(helper(p + ch, up.substring(1)));
            }
        }
        return ans;
    }
}
