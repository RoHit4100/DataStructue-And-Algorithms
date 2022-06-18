import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = { 23, 5, 5645, 6, 443, 43, 34 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        boolean swapped = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
                if (swapped == false) {
                    break;
                }
            }
        }
    }
}