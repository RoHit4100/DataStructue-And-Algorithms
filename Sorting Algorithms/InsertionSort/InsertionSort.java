import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = { 23, 4, 23, 3424, 453445, 34, 645, 3454, 6345, 3456 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                int previous = j - 1;
                if (arr[j] < arr[previous]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    static void swap(int[] arr, int first, int last) {
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = arr[temp];
    }
}