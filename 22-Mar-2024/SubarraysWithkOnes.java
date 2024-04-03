import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
//counting subaarays
public class SubarraysWithkOnes {

    public static int countSubarraysWithKOnes(int[] arr, int k) {
        int count = 0;
        int onesCount = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr) {
            if (num == 1) {
                onesCount++;
            }

            // If onesCount exceeds k, remove excess ones from the beginning
            if (onesCount > k) {
                onesCount--;
                count -= frequencyMap.getOrDefault(onesCount - k, 0);
            }

            // Increment count for valid subarrays
            count += frequencyMap.getOrDefault(onesCount - k, 0);

            // Update frequency map
            frequencyMap.put(onesCount, frequencyMap.getOrDefault(onesCount, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int N = scanner.nextInt();
        System.out.println("Enter value of k:");
        int k = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(countSubarraysWithKOnes(arr, k));
        scanner.close();
    }
}
