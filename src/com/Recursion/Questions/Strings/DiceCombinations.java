package com.Recursion.Questions.Strings;

import javax.naming.PartialResultException;
import java.util.ArrayList;
public class DiceCombinations {
    public static void main(String[] args) {
        getTheCombinations("", 5);
        System.out.println(getTheCombinationsWithFace("", 7, 9));
    }

    static void getTheCombinations(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            getTheCombinations(p + i, target - i);
        }
    }

    static ArrayList<String> getTheCombinationsWithFace(String p, int target, int face) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= face && i <= target; i++) {
            ans.addAll(getTheCombinationsWithFace(p + i, target - i, face));
        }
        return ans;
    }
}
