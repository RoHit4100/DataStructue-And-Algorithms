import java.io.FileReader;

public class FIndMin {
    public static void main(String[] args) {
        int[] arr = { 23, 3, 65, 74, 28, 33, 67 };
        int first = arr[1];
        System.out.println(min(arr, first));
    }

    static int min(int[] arr, int first) {
        int min = first;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
