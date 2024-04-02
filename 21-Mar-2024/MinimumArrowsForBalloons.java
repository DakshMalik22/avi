import java.util.Arrays;

public class MinimumArrowsForBalloons {
    public static void main(String[] args) {
        int[] balloons1 = {2, 1, 5, 4, 3};
        int[] balloons2 = {3, 2, 1};
        System.out.println("Minimum arrows for balloons1: " + minArrows(balloons1)); // Output: 2
        System.out.println("Minimum arrows for balloons2: " + minArrows(balloons2)); // Output: 1
    }

    public static int minArrows(int[] balloons) {
        if (balloons.length == 0) return 0;

        int arrows = 1;
        int maxHeight = balloons[0];

        // Loop through the array to find the minimum number of arrows required
        for (int i = 1; i < balloons.length; i++) {
            // If the current balloon is above the maximum height shot so far,
            // then a new arrow is required and update the maximum height shot
            if (balloons[i] > maxHeight) {
                arrows++;
                maxHeight = balloons[i];
            }
        }

        return arrows;
    }
}
