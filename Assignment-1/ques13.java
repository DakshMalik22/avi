package Assigment;

public class ques13 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7};
        int m = 6;

        int result = searchInsert(arr, m);
        System.out.println("Output: " + result);
    }

    private static int searchInsert(int[] arr, int m) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == m) {
                return mid; // Target value found
            } else if (arr[mid] < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

      
        return left;
    }
}

