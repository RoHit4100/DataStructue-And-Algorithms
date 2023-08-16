package com.Simple;

public class PalindromeString {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }
    static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        s = s.toLowerCase();
        s = s.replaceAll(
                "[^a-zA-Z0-9]", "");
        System.out.println(s);
        for (int i = 0; i < s.length() / 2; i++) {
            char start = s.charAt(i);
            char end = s.charAt(s.length() - 1 - i);
            if (start != end) {
                return false;
            }
        }
        return true;
    }
}
