public class FindTheMaxWealth {
    public static void main(String[] args) {
        int[][] arr = {
                { 34, 6 },
                { 4, 6 },
                { 3, 6 },
                { 34, 56 },
                { 36, 26 }

        };

        int given_max = 60;
        int max_sum = findMaxSum(arr, given_max);
        System.out.println("The maximum sum is " + max_sum);
    }

    static int findMaxSum(int[][] arr, int given_max) {
        int new_max = given_max;
        int max_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max_sum < arr[i][j]) {
                    max_sum = max_sum + arr[i][j];
                }
            }
        }

        if (new_max < max_sum) {
            new_max = max_sum;
        }
        return new_max;

    }
}
