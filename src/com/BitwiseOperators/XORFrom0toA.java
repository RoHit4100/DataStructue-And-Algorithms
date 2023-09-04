package com.BitwiseOperators;

public class XORFrom0toA {
    public static void main(String[] args) {
        int a = 3;
        int b = 9;
        int ans = findXOR(b) ^  findXOR(a - 1);
        System.out.println(ans);
    }

    /*
        if we find the XOR from 1 to 4, we will find a pattern like,
            a % 4 = 0 then a ----------> a == 1
            a % 4 = 1 then 1 ----------> a == 2
            a % 4 = 3 then a + 1  ----------> a == 3
            a % 4 = 0 then 0  ----------> a == 4
     */
    static int findXOR(int n) {
        if (n % 4 == 0) {
            return n;
        } else if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 2) {
            return n + 1;
        }else{
            return 0;
        }
    }
}
