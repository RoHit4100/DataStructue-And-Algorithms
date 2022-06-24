import java.util.Arrays;

public class findTheMissingNoCS {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 5 };
        int ans = sort(arr);
        // sort(arr);
        // System.out.println(Arrays.toString(arr));
        System.out.println(ans);
    }

    static int sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return -1;

    }

    /*
     * static int findMissingELE(int[] arr) {
     * int ans = 0;
     * int i = 0;
     * while (i < arr.length) {
     * if (arr[i] != i + 1) {
     * 
     * ans = arr[i];
     * }
     * }
     * return ans;
     * }
     */
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}