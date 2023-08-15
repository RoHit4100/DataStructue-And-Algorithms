package com.simple;

import java.util.Scanner;

public class ReverseNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number that you want to reverse: ");
        int n = sc.nextInt();
        int ans = 0;
        while(n > 0){
            int rem = n % 10;
			ans = ans * 10 + rem;
            n = n / 10;
        }
        System.out.println("The answer is the "+ans);
    }
}
