import java.util.Scanner;

import javax.swing.border.EmptyBorder;

public class findingTheMaxInc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total number of Employees in you office : ");
        int Employees = sc.nextInt();
        System.out.println();
        int[][] detail = new int[20][1];
        getTheDeatails(detail, Employees);
        System.out.print("The details you have enter are the: ");
        printDetails(detail, Employees);
        System.out.println();
        int max = findMaxSallary(detail, Employees);
        System.out.println("The maximum sallary is " + max);
        sc.close();
    }

    static void getTheDeatails(int[][] detail, int Employees) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Employees; i++) {
            System.out.println("Enter the sallary of " + (i + 1) + " Employee");
            for (int j = 0; j < detail[Employees].length; j++) {
                detail[i][j] = sc.nextInt();
            }
        }
    }

    static void printDetails(int[][] detail, int Employees) {
        for (int i = 0; i < Employees; i++) {
            for (int j = 0; j < detail[Employees].length; j++) {
                System.out.print("[ " + detail[i][j] + " ]");
            }
        }
    }

    static int findMaxSallary(int[][] detail, int Employee) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < Employee; i++) {
            for (int j = 0; j < detail[Employee].length; j++) {
                if (max < detail[i][j]) {
                    max = detail[i][j];
                }
            }
        }
        return max;
    }
}
