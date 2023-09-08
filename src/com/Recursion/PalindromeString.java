package com.Recursion;

public class PalindromeString {
    public static void main(String[] args) {
        System.out.println(isPal("raman"));
    }

    static boolean check(String str, int s, int e) {
        if(s == e)
            return true;
        if(str.charAt(s) != str.charAt(e))
            return false;
        if(s < e + 1)
            return check(str, s + 1, e - 1);
        return true;
    }

    static boolean isPal(String str) {
        int n = str.length();
        if(n == 0)
            return false;
        return check(str, 0, n - 1);
    }
}
