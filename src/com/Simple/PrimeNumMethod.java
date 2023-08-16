package com.Simple;

import java.util.Scanner;

public class PrimeNumMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(checkPrime(n));
    }
    static boolean checkPrime(int n){
        if (n <= 1){
            return false;
        }
        int i = 2;
        while(i * i < n){
            if (n % i == 0){
                return false;
            }
            i++;
        }
        return i * i > n;
    }

}
