 import java.util.Arrays;

public class BinarySearch2DsortdedMat {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 8, 9, 10, 11 },
                { 12, 13, 14, 15 }
        };
        int target = 10;
        System.out.println(Arrays.toString(search(arr, target)));
    }

    static int[] simpleBinarySearch(int[][] arr, int row, int cStart, int cEnd, int target) {
        while (cStart < cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (arr[row][mid] == target) {
                return new int[] { row, mid };
            } else if (arr[row][mid] > target) {
                cEnd = mid - 1;
            } else {
                cStart = mid + 1;
            }
        }

        return new int[] { -1, -1 };
    }

    /*
     * static int[] binarySearch(int[][] arr, int rStart, int rEnd, int cMid, int
     * target) {
     * while (rStart < (rEnd - 1)) {
     * int mid = rStart + (rEnd - rStart) / 2;
     * 
     * if (arr[mid][cMid] == target) {
     * return new int[] { mid, cMid };
     * } else if (arr[mid][cMid] > target) {
     * rEnd = mid;
     * } else {
     * rStart = mid;
     * }
     * }
     * return new int[] { -1, -1 };
     * }
     */
    static int[] search(int[][] arr, int target) {
        int row = arr.length;
        int col = arr[0].length;
        int rStart = 0;
        int rEnd = row - 1;
        int cMid = col / 2;

        if (row == 1) {
            return simpleBinarySearch(arr, 0, 0, col - 1, target);
        }

        // to make only two rows from the n*n or n*m array
        while (rStart < (rEnd - 1)) {
            int mid = rStart + (rEnd - rStart) / 2;

            if (arr[mid][cMid] == target) {
                return new int[] { mid, cMid };
            } else if (arr[mid][cMid] > target) {
                rEnd = mid;
            } else {
                rStart = mid;
            }
        }

        // now we have to check in the mid col if there is the target or not
        if (arr[rStart][cMid] == target) {
            return new int[] { rStart, cMid };
        } else if (arr[rStart + 1][cMid] == target) {
            return new int[] { rStart + 1, cMid };
        }

        // now we have to check in betweeen the four parts we made
        // the first will be from the start of the row and end will the the cmid - 1

        if (arr[rStart][cMid - 1] >= target) {
            return simpleBinarySearch(arr, rStart, 0, cMid - 1, target);
        } else if (arr[rStart][cMid + 1] <= target && arr[rStart][col - 1] == target) {
            return simpleBinarySearch(arr, rStart, cMid + 1, col - 1, target);
        } else if (arr[rStart + 1][cMid - 1] <= target) {
            return simpleBinarySearch(arr, rStart + 1, 0, cMid - 1, target);
        } else if (arr[rStart + 1][cMid + 1] <= target && arr[rStart][col - 1] == target) {
            return simpleBinarySearch(arr, rStart + 1, cMid + 1, col - 1, target);
        }
        return new int[] { -1, -1 };
    }
}
