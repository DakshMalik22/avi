package myPackage.date_08_04_24;

public class MySeatArrangement {
    private static final int MOD = 10000003;

    public int findMinDistance(String seatArrangement) {
        int length;
        int i;
        int first, last;
        int[] countLeft;
        int total = 0;
        int midVal;

        if (seatArrangement == null || seatArrangement.length() == 0)
            return 0;

        length = seatArrangement.length();
        countLeft = new int[length];
        first = last = -1;

        for (i = 0; i < length; i++) {
            countLeft[i] = i > 0 ? countLeft[i - 1] : 0;

            if (seatArrangement.charAt(i) == 'x') {
                if (first == -1)
                    first = i;
                last = i;
                countLeft[i]++;
                total++;
            }
        }

        midVal = (total + 1) / 2;

        if (first == -1 || first == last)
            return 0;

        int mid;

        for (i = first; i <= last; i++) {
            if (countLeft[i] == midVal)
                break;
        }

        mid = i;

        long res = 0;
        int count = 0;

        for (i = mid; i >= first; i--) {
            if (seatArrangement.charAt(i) == 'x') {
                res += (mid - i - count);
                res %= MOD;
                count++;
            }
        }

        count = 0;

        mid++;
        for (i = mid; i <= last; i++) {
            if (seatArrangement.charAt(i) == 'x') {
                res += (i - mid - count);
                res %= MOD;
                count++;
            }
        }

        return (int) res;
    }

    public static void main(String[] args) {
        MySeatArrangement solution = new MySeatArrangement();
        String seatsArrangement = "....xxx";
        int result = solution.findMinDistance(seatsArrangement);
        System.out.println(result);
    }
}
