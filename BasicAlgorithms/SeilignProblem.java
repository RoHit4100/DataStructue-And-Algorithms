public class SeilignProblem {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 45, 56, 67, 89, 90, 110, 112 };

        int leilingNo = 88;
        System.out.println(leilingNo); 
        System.out.println(findClosestGreater(arr, leilingNo));
    }

    static int findClosestGreater(int[] arr, int leilingNo) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < leilingNo) {
                start = mid + 1;
            } else if (arr[mid] > leilingNo) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        // for (int i = start; i < end; i++) {
        // if(mid )
        // }
        return arr[start];
    }
}
