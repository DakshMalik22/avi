import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OccurrencesOfPattern {
    public static List<Integer> findOccurrences(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i <= n - m; i++) {
            if (text.substring(i, i + m).equals(pattern)) {
                occurrences.add(i + 1);
            }
        }
        return occurrences;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String pattern = scanner.nextLine();
        List<Integer> result = findOccurrences(text, pattern);
        for (int pos : result) {
            System.out.print(pos + " ");
        }
        scanner.close();
    }
}
