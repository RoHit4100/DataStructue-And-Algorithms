public class findTheMaxSum {
    public static void main(String[] args) {
        int[][] arr = {
                { 34, 6 },
                { 4, 6 },
                { 3, 6 },
                { 34, 56 },
                { 36, 26 }

        };
        int max_sum = findMaxSum(arr);
        System.out.println("The maximum sum is " + max_sum);
    }

    static int findMaxSum(int[][] arr) {
        int max_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max_sum < arr[i][j]) {
                    max_sum = max_sum + arr[i][j];
                }
            }
        }


        return max_sum;

    }
}
