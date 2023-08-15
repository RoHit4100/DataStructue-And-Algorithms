package com.simple;

import java.util.Scanner;

public class CountingRepeatingNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        System.out.print("Enter the number that you want to check: ");
        int find = sc.nextInt();
        int count = 0;
        while(n > 0){
            int rem = n % 10;
            if(rem == find){
                count++;
            }
            n = n / 10;
        }
        System.out.println("The number has been repeated "+ count +" times");
    }
}

