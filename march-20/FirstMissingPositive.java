import java.util.Scanner;

public class FindFirstMissingPositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the size of the array:");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("First missing positive number:");
        System.out.println(findFirstMissingPositive(array));
    }

    public static int findFirstMissingPositive(int[] nums) {
        // Cycle sort
        int i = 0;

        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] < nums.length && nums[i] > 0 && nums[i] != nums[correctIndex]) {
                // Swap the two numbers
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else
                ++i;
        }

        // Now the array is sorted, so find the missing number
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] != j + 1)
                return j + 1;
        }

        // When every number is present in the array, the missing number must be nums.length+1
        return nums.length + 1;
    }
}
