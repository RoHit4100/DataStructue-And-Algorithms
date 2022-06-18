public class OrderAgnosticBS {
    public static void main(String[] args) {
        // This is the example of binary search in which we dont know whether the given
        // array is sorted or not...
        // we start compare the start and last element from the array and then perform
        // on the algo on that basis...
        int[] arr = { 160, 99, 45, 34, 22, 12, 10, 7, 5, 1 };

        if (check(arr)) {
            System.out.print("This array is in Ascending order");
            int target = 45;
            System.out.print("And the element " + target + " Is at " + (binarySearchAsc(arr, target) + 1));
        } else {
            System.out.print("This array is in Descending order");
            int target = 45;
            System.out.print("And the element " + target + " Is at " + (binarySearchDesc(arr, target) + 1));
        }
    }

    static boolean check(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        if (arr[start] > arr[end]) {
            return false;
        }
        return true;
    }

    static int binarySearchAsc(int[] arr, int target) {
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

    static int binarySearchDesc(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[start] == target) {
                return start;
            } else if (arr[end] == target) {
                return end;
            } else if (arr[mid] > target) {
                start = mid + 1;
            } else if (arr[mid] < target) {
                end = mid - 1;
            } else if (arr[mid] == target) {
                return mid;
            }
        }
        return -1;
    }
}
