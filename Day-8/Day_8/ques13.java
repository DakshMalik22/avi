package Day_8;

public class ques13 {
    static final int MOD = 1000000007;
    static int myPow(int x, int n) {
        if (n == 0)
            return 1;

        long xnp = myPow(x, n / 2) % MOD;
        long xn = (xnp * xnp) % MOD;
        if (n % 2 == 1) {
            xn = (xn * x) % MOD;
        }

        return (int) xn;
    }
    public static void main(String[] args) {
        int n =11;
        int store= n;int reverse=0;

        while (store != 0) {
            int digit = store % 10;
            reverse = (reverse * 10 + digit) % MOD; // Update reverse with modulo operation
            store = store / 10;
        }

        System.out.println(myPow(n,reverse));


    }
}
