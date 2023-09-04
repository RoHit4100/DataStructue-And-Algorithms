package com.BitwiseOperators;

public class FindPowerOfNumber {
    public static void main(String[] args) {
        System.out.println(findPow(3, 6));
    }

    static int findPow(int n, int pow) {
        int ans = 1;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                ans *= n;
            }
            n *= n;
            pow = pow >> 1;
        }
        return ans;
    }
}
