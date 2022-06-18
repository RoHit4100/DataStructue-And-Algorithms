public class FindDigitsREvenOROdd {
    public static void main(String[] args) {

        int[] arr = { 12, 345, 6, 2, 7896 };
        System.out.println("The even numbers in the arrray are " + findEven(arr));
    }

    static int findEven(int[] arr) {
        int n_digit = 0;
        for (int i = 0; i < arr.length; i++) {
            n_digit = digit(arr[i]);
            if (n_digit % 2 == 0) {
                n_digit++;
                continue;
            }
        }
        return n_digit;
    }

    static int digit(int n) {
        int count = 0;
        while (count > 0) {
            count++;
            n = n / 10;
        }
        return count;
    }
}
