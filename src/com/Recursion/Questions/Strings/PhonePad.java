package com.Recursion.Questions.Strings;

import java.util.ArrayList;
import java.util.List;

public class PhonePad {
    public static void main(String[] args) {
        String str = "23";
        System.out.println(letterCombinations(str));
    }

    // This function will take the given string which is the keystroke of the user.
    static List<String> letterCombinations(String up) {
        // check whether the given string is empty or not.
        if(up.isEmpty())
            // if empty then return the empty arraylist
            return new ArrayList<>();
        // take the help of the helper function.
        return helper("", up);
    }
    static List<String> helper(String p, String up) {
        // this will be the breaking condition of the recursion.
        if (up.isEmpty()) {
            // it will create a new list.
            List<String> list = new ArrayList<>();
            // add the process string to the list
            list.add(p);
            // return the list, as every function will have its own list and to send current to list to previous function call
            // we have to return that list.
            return list;
        }
        // create new arraylist which will contain all the list of each and every call, as it will update after each call.
        ArrayList<String> ans = new ArrayList<>();
        // This will convert something like '2' into 2
        int digit = up.charAt(0) - '0';
        // according to the question we have to start checking from digit 2.
        // 1st digit is assign to the infinity.
        // we will check whether the digit is greater than 2 or less than 6
        // as letters assign to these digits are 3.
        if(digit >= 2 && digit <= 6){
            // run for loop from (digit - 2) * 3
            // e.g. digit == 3
            //     3 - 2 == 1 * 3 == 3
            //     therefore index will start from 3.
            // run loop till (digit - 1) * 3
            //     3 - 1 == 2 * 3 == 6
            //     therefore index should be less than 6.
            for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
                // get the character as we know by adding integer with character we will perform addition with the ascii value of that character.
                // by adding the index with the 'a' we will get the next character by type casting that ascii value.
                // 'a' + 1 == ascii value of b
                // then type caste that value to character.
                char ch = (char)('a' + i);
                // call the recursive function with process string + ch means add the first character to the process string and remove that character from the
                // given string.
                // add all the return list to the ans list.
                ans.addAll(helper(p + ch, up.substring(1)));
            }
        }else if(digit == 7){// if digit is 7 then start from (digit - 2) * 3
                                // e.g. 7 - 2 == 5 * 3 == 15
                                // run loop till (digit - 1) * 3
                                // 7 - 1 == 6 * 3 == 18
            for (int i = (digit - 2) * 3; i <= (digit - 1) * 3; i++) {
                char ch = (char)('a' + i);
                ans.addAll(helper(p + ch, up.substring(1)));
            }
        }else if(digit == 8){// if digit is 8 then start from (digit - 2) * 3
                                // e.g. 8 - 2 == 6 * 3 == 18 + 1 == 19
                                // run loop till (8 - 1) == 7 * 3 = 21
            for (int i = ((digit - 2) * 3) + 1; i <= (digit - 1) * 3; i++) {
                char ch = (char)('a' + i);
                ans.addAll(helper(p + ch, up.substring(1)));
            }
        }else if(digit == 9){// if digit is 8 then start from (digit - 2) * 3
                                // e.g. 9 - 2 == 7 * 3 == 21 + 1 == 22
                                // run loop till (9 - 1) == 8 * 3 = 24 + 1 == 25
            for (int i = ((digit - 2) * 3) + 1; i <= ((digit - 1) * 3) + 1; i++) {
                char ch = (char)('a' + i);
                ans.addAll(helper(p + ch, up.substring(1)));
            }
        }
        // In the end just return the list which consist all the strings.
        return ans;
    }
}
