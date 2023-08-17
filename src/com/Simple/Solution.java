
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] percentages = new int[N];
        for (int i = 0; i < N; i++) {
            percentages[i] = scanner.nextInt();
        }

        int M = scanner.nextInt();
        int[] batches = new int[M];
        for (int i = 0; i < M; i++) {
            batches[i] = scanner.nextInt();
        }

        distributeCandies(N, percentages, M, batches);
    }

    public static void distributeCandies(int N, int[] percentages, int M, int[] batches) {
        for (int batch : batches) {
            int totalCandies = batch;

            for (int i = 0; i < N; i++) {
                float targetCandies = (float) (totalCandies * (percentages[i] / 100.0));
                if (targetCandies == 0 && totalCandies > 0) {
                    targetCandies = 1;
                }

                System.out.print(targetCandies);

                totalCandies -= targetCandies;
                if (i < N - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}