package com.BitwiseOperators;

public class MagicNumber {
    public static void main(String[] args) {
        System.out.println(nthMagicalNumber(6, 5));
    }
    static int nthMagicalNumber(int n, int base) {
        int ans = 0;
        int power = base;
        while (n > 0) {
            int last = n & 1;
            ans += last * base;
            n = n >> 1;
            base *= power;
        }
        return ans;
    }
}
