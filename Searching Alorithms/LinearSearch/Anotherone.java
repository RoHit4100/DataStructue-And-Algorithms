public class Anotherone {
    public static void main(String[] args) {
        int[] arr = { 12, 345, 6, 2, 7896 };

        System.out.println(findEvenNos(arr));
    }

    static int findEvenNos(int[] arr) {
        int no_Evens = 0;
        for (int i : arr) {
            if (even(i)) {
                no_Evens++;
            }
        }
        return no_Evens;
    }

    static boolean even(int n) {
        int n_digit = digit(n);
        return n_digit % 2 == 0;
    }

    static int digit(int n) {
        // int count = 0;
        if (n < 0) {
            n = n * -1;
        }

        if (n == 0) {
            return 1;
        }

        return (int) (Math.log10(n)) + 1;
        // while (n > 0) {
        // count++;
        // n = n / 10;
        // }
        // return count;
    }

}
