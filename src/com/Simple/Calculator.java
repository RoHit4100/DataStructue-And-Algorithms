package com.Simple;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        while(true){
            System.out.print("Enter x to exit OR");
            System.out.println("Enter %, *, -, +, / this symbols to perform the operations OR Enter X to exit!");
            char op = sc.next().trim().charAt(0);
            if(op == '%' || op == '*' || op == '-' || op == '+'|| op == '/'){
                System.out.println("Enter First number");
                int n1 = sc.nextInt();
                System.out.println("Enter Second number");
                int n2 = sc.nextInt();
                if (op == '%'){
                    ans = n1 % n2;
                } if (op == '*'){
                    ans = n1 * n2;
                } if (op == '-'){
                    ans = n1 - n2;
                }if(op == '+') {
                    ans = n1 + n2;
                }if(op == '/') {
                    ans = n1 / n2;
                }
                System.out.println("Your answer is "+ans);
            } else if (op == 'x' || op =='X') {
                break;
            }else {
                System.out.println("Invalid operation!");
            }
        }
        System.out.println("Your whole operation's answer is "+ans);

    }
}
