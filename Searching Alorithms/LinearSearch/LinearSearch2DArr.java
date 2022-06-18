import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch2DArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = {
                { 34, 56, 34 },
                { 1, 2, 3, 4 },
                { 22, 44, 66 }
        };

        System.out.print("Enter 1 to print the array and 0 to not : ");
        int inp = sc.nextInt();
        if (inp == 1) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.print("Enter the number which you want to search in this array : ");
        int target = sc.nextInt();
        System.out.println();
        int[] ans = search(arr, target);
        System.out.println("The answer is " + Arrays.toString(ans));
        sc.close();
    }

    static int[] search(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    return new int[] { i + 1, j + 1 };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}
