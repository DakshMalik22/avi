import java.util.Arrays;
//counting smaller elements
public class CountSmallerElements {

    public static int[] countSmallerElements(int[] arr) {
        int n = arr.length;
        int[] sortedArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArr);

        int[] count = new int[n];
        int[] bit = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int index = Arrays.binarySearch(sortedArr, arr[i]) + 1;
            count[i] = query(bit, index - 1);
            update(bit, index, 1);
        }

        return count;
    }

    private static int query(int[] bit, int index) {
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & (-index);
        }
        return sum;
    }

    private static void update(int[] bit, int index, int value) {
        while (index < bit.length) {
            bit[index] += value;
            index += index & (-index);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 5};
        int[] result = countSmallerElements(arr);
        System.out.println(Arrays.toString(result)); // Output: [2, 1, 0, 0]
    }
}

