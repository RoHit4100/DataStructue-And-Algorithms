import java.util.*;

/*
I             1
V             5
X             10
L             50
C             100
D             500
M             1000 
*/
public class CalculatingRomanNo {

    public static void main(String[] args) {
        // https://leetcode.com/problems/roman-to-integer
        // Scanner sc = new Scanner(System.in);

        // System.out.print("Enter the Roman Number : ");
        // String s = sc.nextLine();
        String s = "VI";
        System.out.println(getTheValueOfRomanNo(s));
        // sc.close();
    }

    static int getTheValueOfRomanNo(String s) {
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char current_char = s.charAt(i);

            if (i > 0 && dict.get(current_char) > dict.get(s.charAt(i - 1))) {
                ans += dict.get(current_char) - 2 * dict.get(s.charAt(i - 1));
            } else {
                ans += dict.get(current_char);
            }

        }
        return ans;
    }
}