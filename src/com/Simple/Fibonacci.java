package com.Simple;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        //fibonacci number with iteration method
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = 0;
        int i = 1;
        int count = 2;
        if(n == 0){
            System.out.println(0);
        } else if ( n == 1 || n == 2) {
            System.out.println(1);
        } else {
            while (count <= n){
                int temp = i;
                i = i + p;
                p = temp;
				count++;
            }
            System.out.println(i);
        }
    }

}
