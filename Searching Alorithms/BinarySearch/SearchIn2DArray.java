import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 5, 7, 9 },
                { 12, 31, 37, 49 },
                { 21, 45, 57, 69 },
                { 31, 45, 67, 99 }
        };
        int target = 37;
        System.out.println(Arrays.toString(search(arr, target)));
    }

    static int[] search(int[][] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {

                    return new int[] { i, j };
                }

            }
        }

        return new int[] { -1, -1 };
    }
}
