import java.util.Arrays;

public class BinarySearch2d {

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 5, 7, 9 },
                { 12, 31, 37, 49 },
                { 21, 45, 57, 69 },
                { 31, 45, 67, 99 }
        };
        int target = 37;
        System.out.println(Arrays.toString(binarySearch(arr, target)));
    }

    static int[] binarySearch(int[][] arr, int target) {
        int r = 0;
        int c = arr.length - 1;
        while (r < arr.length && c >= 0) {
            if (arr[r][c] == target) {
                return new int[] { r, c };
            }
            if (arr[r][c] > target) {
                c--;
            }
            if (arr[r][c] < target) {
                r++;
            }
        }
        return new int[] { -1, -1 };
    }
}