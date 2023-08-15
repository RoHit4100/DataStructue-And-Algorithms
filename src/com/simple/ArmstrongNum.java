package com.simple;

import java.util.Scanner;

public class ArmstrongNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to check: ");
        int n = sc.nextInt();
        System.out.println(checkArmstrong(n));
    }
    static boolean checkArmstrong(int n){
        int original = n;
        int sum = 0;
        while(n > 0){
            int rem = n % 10;
//            sum = sum + (rem*rem*rem);
            sum += (int)(Math.pow(rem, 3));
            n /= 10;
        }
        return sum == original;
    }
}
