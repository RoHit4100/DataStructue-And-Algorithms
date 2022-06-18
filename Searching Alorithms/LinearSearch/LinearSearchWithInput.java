import java.util.Scanner;

public class LinearSearchWithInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        System.out.print("Enter the number of elements which you want to enter in the array : ");
        int n = sc.nextInt();
        System.out.println();

        System.out.print("Enter the elements that you want to store in array : ");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter 1 if you wanna see the elements you have Enter and 0 to not");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("The elements are : ");
            System.out.print(" [");
            for (int i = 0; i < n; i++) {
                System.out.print(" " + arr[i]);
            }
            System.out.print(" ]");
        }
        if (choice == 0) {
            System.out.println("You dont want to see the elements that u have enter");
        }

        System.out.print("\n\n" + "Enter the element which u want to find in array : ");
        int target = sc.nextInt();

        int loc = search(arr, target);
        if (loc > 0) {
            System.out.println("The number is found at " + loc);
        } else {
            System.out.printf("Number not found in the given array");
        }
        sc.close();
    }

    static int search(int[] arr, int target) {
        if (arr[0] == target) {
            return 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i + 1;
            }
        }
        return -1;
    }
}