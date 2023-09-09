package com.Recursion.Questions.Strings;

public class RemoveAFromString {
    public static void main(String[] args) {
        String str = "ramAn";
        String ans = "";
        skipOrModify(ans, str);
        System.out.println(skipOrModify(str));
    }
    // In these we are using another string object and at the end of the recursion we are simply printing that ans
    static void skipOrModify(String newString, String givenString) {
        if (givenString.isEmpty()) {
            System.out.println(newString);
            return;
        }
        char ch = givenString.charAt(0);
        if(ch == 'a')
            skipOrModify(newString, givenString.substring(1));
        else if(ch == 'A')
            skipOrModify(newString, givenString.substring(1));
        else
            skipOrModify(newString + ch, givenString.substring(1));
    }

    // With return type and only with one argument.
    // After completing recursion we are adding the current answer with its previous answer and finally returning that answer in the end
    static String skipOrModify(String string) {
        if (string.isEmpty()) {
            return "";
        }
        char ch = string.charAt(0);
        if (ch == 'a') {
            return skipOrModify(string.substring(1));
        }else if (ch == 'A') {
            return skipOrModify(string.substring(1));
        }else{
            return ch + skipOrModify(string.substring(1));
        }
    }
}
