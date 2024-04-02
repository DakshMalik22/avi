import java.util.Scanner;

public class PreprocessingMoves {
    public static int minPreprocessingMoves(String A, String B) {
        int[] count = new int[26];
        for (char c : A.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : B.toCharArray()) {
            count[c - 'a']--;
        }
        int total = 0;
        for (int val : count) {
            total += Math.abs(val);
        }
        return total / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        while (T-- > 0) {
            String A = scanner.nextLine();
            String B = scanner.nextLine();
            System.out.println(minPreprocessingMoves(A, B));
        }
        scanner.close();
    }
}
