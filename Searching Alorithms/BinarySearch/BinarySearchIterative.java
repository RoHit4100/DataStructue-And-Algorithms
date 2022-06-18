public class BinarySearchIterative {
    public static void main(String[] args) {
        int[] sort_arr = { 12, 34, 45, 67, 89, 90, 101 };
        int target = 45;
        System.out.println((binarySearch(sort_arr, target) + 1));
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[start] == target) {
                return start;
            } else if (arr[end] == target) {
                return end;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] == target) {
                return mid;
            }
        }
        return -1;
    }
}
