package com.arrays.Questions.SearchQuestions.binarySearch;

import java.util.Arrays;

public class SearchInStrictlySorted2DArray {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(Arrays.toString(search(matrix, 15)));
    }
    /*
    In this solution we have to apply binary search on the 2D array, For applying binary search we will eliminate columns first and after that
    we will eliminate rows also, by understanding the solution.

    First Step:
        In these step we have to select the middle column and apply binary search on it.
            To do so we will need the 3 variables,
                rStart = 0;
                rEnd = arr.length - 1;
                cMid = cols / 2;      ......(where cols = matrix[0].length - 1;)
            And the case for the while loop will be,
                rStart < (rEnd - 1),
                    means 2 < 3;
                This loop will give us 2 rows and will eliminate all the extra rows.
                This loop will contain 3 conditions, We are checking the target element is whether =, < or > than the current element present in the
                middle column.
                First we will take the middle element of the row to apply binary search, by using the formula,
                    rMid = rStart + (rEnd - rStart) / 2;
                    1. if the element of matrix[rMid][cMid] == target
                          then, return new int[]{rMid, cMid};
                    2. if the element of matrix[rMid][cMid] < target
                          then, rStart = mid;
                    3. if the element of matrix[rMid][cMid] > target
                          then, rEnd = mid;

            After this the while loop will give us the 2 rows.
                Now we have to first check whether the element lies in the middle column or not.
                1. if matrix[rStart][cMid] == target
                    then we will return the rStart & cMid;
                2. if matrix[rStart + 1][cMid] == target
                    then we will return the rStart + 1 & cMid;
            If element is not present in the columns that means we have to make 4 parts of the remaining rows.
            Now we have to check in between those 4 parts, for that we will just call simple binary search giving that function new parameters.
            To call the binary search function we have to first identify the remaining 4 parts before doing the search.
                1. To search in the first half,
                    (*) target < matrix[rStart][cMid - 1]
                        then binarySearch(matrix, rStart, 0, cMid - 1, target);
                    (*) target < matrix[rStart + 1][mid - 1]
                        then binarySearch(matrix, rStart + 1, 0 , cMid - 1, target);
                    (*) target > matrix[rStart][mid + 1] && target <= matrix[rStart][cols - 1]  ......(We are checking whether the element is smaller than the target and last element of that column is smaller than the target.
                        then binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
                    (*) target > matrix[rStart + 1][mid + 1] && target <= matrix[rStart + 1][cols - 1]
                        then binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);


            Binary search Function will have 5 parameters,
                int[][] matrix, int row, int rStart, int rEnd, int target.


     */

    static int[] binarySearch(int[][] matrix, int row, int rStart, int rEnd, int target) {
        while (rStart <= rEnd) {
            int mid = rStart + (rEnd - rStart) / 2;
            if (matrix[row][mid] < target) {
                rStart = mid + 1;
            } else if (matrix[row][mid] > target) {
                rEnd = mid - 1;
            }else {
                return new int[]{row, mid};
            }
        }
        return new int[]{-1, -1};
    }

    static int[] search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows == 1) {
            binarySearch(matrix, 0, 0, cols - 1, target);
        }

        int rStart = 0;
        int rEnd = matrix.length - 1;
        int cMid = cols / 2;
        while (rStart < (rEnd - 1)) {
            int rMid = rStart + (rEnd - rStart) / 2;
            if (matrix[rMid][cMid] < target) {
                rStart = rMid;
            } else if (matrix[rMid][cMid] > target) {
                rEnd = rMid;
            } else {
                return new int[]{rMid, cMid};
            }
        }

        if (matrix[rStart][cMid] == target) {
            return new int[]{rStart, cMid};
        } else if (matrix[rStart + 1][cMid] == target) {
            return new int[]{rStart + 1, cMid};
        }

        // Now we have to check the 4 parts.
        // To check first part:
        if(matrix[rStart][cMid - 1] >= target){
            return binarySearch(matrix, rStart, 0, cMid - 1, target);
        } else if (matrix[rStart + 1][cMid - 1] >= target) {
            return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
        } else if (matrix[rStart][cMid + 1] <= target && matrix[rStart][cols - 1] >= target) {
            return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
        } else if (matrix[rStart + 1][cMid + 1] <= target && matrix[rStart + 1][cMid + 1] >= target) {
            return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);
        }
        return new int[]{-1 , -1};
    }
}
