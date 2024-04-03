import java.util.Arrays;
import java.util.Scanner;

public class MinArrowsBurstBalloons {
    // Function to find the minimum number of arrows required to burst all balloons
    public static int minArrowsBurstBalloons(int[] balloons) {
        // Sort the array of balloons
        Arrays.sort(balloons);
        // Initialize the number of arrows to 1
        int arrows = 1;
        // Store the position of the previous balloon
        int prevBalloon = balloons[0];
        // Iterate through the balloons
        for (int i = 1; i < balloons.length; i++) {
            // If the current balloon's position is greater than the previous balloon's position,
            // increment the number of arrows and update the position of the previous balloon
            if (balloons[i] > prevBalloon) {
                arrows++;
                prevBalloon = balloons[i];
            }
        }
        // Return the minimum number of arrows required
        return arrows;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the number of balloons
        int N = scanner.nextInt();
        // Create an array to store the positions of balloons
        int[] balloons = new int[N];
        // Read the positions of balloons
        for (int i = 0; i < N; i++) {
            balloons[i] = scanner.nextInt();
        }
        // Find and print the minimum number of arrows required to burst all balloons
        System.out.println(minArrowsBurstBalloons(balloons));
        // Close the scanner
        scanner.close();
    }
}
