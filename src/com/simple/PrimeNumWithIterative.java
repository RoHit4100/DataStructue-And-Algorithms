package com.simple;

import java.util.Scanner;

public class PrimeNumWithIterative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 2;
        if (n <= 1) {
            System.out.println("Not prime Nor composit");
        }
        while(i * i < n){
            if (n % i == 0){
                System.out.println("Not prime number");
                break;
            }else
                i++;
        }
        System.out.println("Prime number");
    }
}
