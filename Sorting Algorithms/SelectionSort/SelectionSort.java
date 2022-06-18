
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 23, 4, 55, 6, 67678, 78, 87, 8645, 45, 5 };
        int choice = 0;
        sort(arr, choice);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int choice) {
        // By taking the max element placing to the end of the array
        if (choice == 1) {
            sortWithMax(arr);
        } else {
            sortWithMin(arr);
        }
    }

    static void sortWithMin(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int smallNoIndex = giveTheIndexSml(arr, i, arr.length);
            swap(arr, i, smallNoIndex);
        }
    }

    static int giveTheIndexSml(int[] arr, int start, int end) {
        int min = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        return min;
    }

    static void sortWithMax(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - 1;
            int maxNoIndex = giveTheIndex(arr, 0, last, i);
            swap(arr, maxNoIndex, last - i);
        }
    }

    static void swap(int[] arr, int first, int sec) {
        int temp = arr[first];
        arr[first] = arr[sec];
        arr[sec] = temp;
    }

    static int giveTheIndex(int[] arr, int start, int end, int pos) {
        end = end - pos;
        int max = start;
        for (int i = 0; i < end; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }
}