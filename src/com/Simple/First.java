package com.Simple;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        System.out.println("First Program!");
        Scanner sc = new Scanner(System.in);
        char c = sc.next().trim().charAt(0);
        if(c >= 'a' && c <= 'z'){
            System.out.println("Lowercase");
        }else{
            System.out.println("Uppercase");
        }
    }
}
