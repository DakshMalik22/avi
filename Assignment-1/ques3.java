package Assigment;

public class ques3 {
    public static int missingNumber(int []a, int N) {

        int xor1 = 0, xor2 = 0;

        for (int i = 0; i < N; i++) {
            xor2 = xor2 ^ a[i]; // XOR of array elements
            xor1 = xor1 ^ (i+1); //XOR up to [1...N-1]
        }


        return (xor1 ^ xor2); // the missing number
    }

    public static void main(String[] args) {
        int N = 6;
        int[] a = {6,4,3,5,5,1};

        int ans = missingNumber(a, N);
        System.out.println("The missing number is: " + ans);
    }
}
