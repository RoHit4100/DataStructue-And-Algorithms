package com.Arrays.Questions.SearchQuestions.binarySearch;

public class RotatedArraySearch {
    public static void main(String[] args) {
        int[] arr = {5,1,3};
        int target = 5;
        System.out.println(search(arr, target));
    }

    /*
        Rotated arr means when arr is like [3, 4, 5, 6, 7, 0, 2] means elements are in sorted format, but they are
        rotated.
        In these question we have to find the location of the target.
        Solution: To find the solution we have to find first the pivot element, which is the largest element in sorted arr
        To find pivot we will get 4 cases,
            1. arr[mid] > arr[mid + 1]
                means when 7 is arr[mid], 7 > 0, which is true.
                their will be just one condition like this in whole arr because it is rotational array.
                all the element before and after are in ascending order.
                NOTE: In this case we always have to first check if,
                mid < end
                To avoid the Index out of bound error.
            2. arr[mid] < arr[mid - 1]
                let's consider arr[mid] is 0, 0 < 7, which is true.
                their will be just one condition like this in whole arr.
                NOTE: In this case we always have to first check if,
                start > mid;
                To avoid the Index out of bound error.
            3. arr[start] > arr[mid]
                when arr[start] is greater than the arr[mid] then all the elements after the mid will also be
                smaller than the start, means we can consider that,
                end = mid - 1;
            4. arr[start] < arr[mid]
                when arr[start] is less than the arr[mid], then all the elements after mid will be greater element than
                start means all the before elements will be smaller than the mid. means we can consider that,
                start = mid + 1;


            NOTE: For searching in the rotated array we will get 3 cases,
                  1. like if the pivot is target, In this case we will return the target
                  2. Another case would be if the target > start element.
                       Then that element must be present before the pivot, because all the elements before the pivot
                       are greater and all the numbers after the pivot are small than the start element.
                       so we can say that, search(start, pivot - 1);
                  3. And the final case would be the target < start element.
                       Means we have the target must be present after the pivot because they are smaller than the start.
                       so we can say that, search(pivot + 1, arr.length - 1);
     */
    static int search(int[] arr, int target) {
        int pivot = findPivot(arr);
        if (pivot == -1) {
            return binarySearch(arr, target, 0, arr.length - 1);
        }
        if (arr[pivot] == target) {
            return pivot;
        }
        int firstHalf = binarySearch(arr, target, 0, pivot - 1);
        if (firstHalf == -1) {
            return binarySearch(arr, target, pivot + 1, arr.length - 1);
        }
        return firstHalf;
    }

    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[mid] <= arr[start]) {
                end = mid - 1;
            }else if (arr[mid] >= arr[start]){
                start = mid + 1;
            }
        }
        return -1;
    }
    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target){
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}

