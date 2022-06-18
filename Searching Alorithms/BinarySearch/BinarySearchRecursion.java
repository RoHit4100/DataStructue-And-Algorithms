public class BinarySearchRecursion {
    public static void main(String[] args) {
        int[] sort_arr = { 12, 34, 45, 67, 89, 90, 101 };
        int target = 34;
        int start = 0;
        int end = sort_arr.length - 1;
        System.out.println(binarySearch(sort_arr, target, start, end));
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        // int mid = (start + end) / 2;
        int mid = start + (end - start) / 2; // new formula if start and mid are both are large values
        if (arr[mid] > target) {
            return binarySearch(arr, target, start, mid - 1);
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, end);
        } else if (arr[mid] == target) {
            return mid;
        }

        return -1;
    }
}
