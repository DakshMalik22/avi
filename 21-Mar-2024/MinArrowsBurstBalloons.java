import java.util.Arrays;
import java.util.Scanner;

public class MinArrowsBurstBalloons {
    public static int minArrowsBurstBalloons(int[] balloons) {
        Arrays.sort(balloons);
        int arrows = 1;
        int prevBalloon = balloons[0];
        for (int i = 1; i < balloons.length; i++) {
            if (balloons[i] > prevBalloon) {
                arrows++;
                prevBalloon = balloons[i];
            }
        }
        return arrows;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] balloons = new int[N];
        for (int i = 0; i < N; i++) {
            balloons[i] = scanner.nextInt();
        }
        System.out.println(minArrowsBurstBalloons(balloons));
        scanner.close();
    }
}
