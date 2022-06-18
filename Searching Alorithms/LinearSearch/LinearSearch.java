public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = { 34, 4, 23, 45, 35 };
        int target = 4;
        int loc = search(arr, target);
        if (loc > 0) {
            System.out.println("The number is found at " + loc);
        } else {
            System.out.printf("Number not found in the given array");
        }
    }

    static int search(int[] arr, int target) {
        if (arr[0] == target) {
            return 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i + 1;
            }
        }
        return -1;
    }
}