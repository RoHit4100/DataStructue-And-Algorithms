public class LinearSearchInRange {

    public static void main(String[] args) {
        int[] arr = { 34, 4, 23, 45, 35 };
        int target = 4;
        int start = 2;
        int end = 4;
        int loc = search(arr, target, start, end);
        if (loc > 0) {
            System.out.println("The number is found at " + loc);
        } else {
            System.out.printf("Number not found in the given array");
        }
    }

    static int search(int[] arr, int target, int start, int end) {
        if (arr[start] == target) {
            return start;
        }
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i + 1;
            }
        }
        return -1;
    }
}