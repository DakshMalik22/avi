package Day3;

import java.util.Scanner;

public class ques5 {
    public static void totalSum(int[][] mat) {
        int n = mat.length;
        int sum =0;
//top & bottom row
        for(int i=0; i<n; i++) {
            sum = sum + mat[0][i];
            sum = sum + mat[n-1][i];
        }
//left & right column
        for(int i=1; i<n-1; i++) {
            sum = sum + mat[i][0];
            sum = sum + mat[i][n-1];
        }

//left diagonal & right diagonal
        for(int i=1; i<n-1; i++) {
            sum = sum + mat[i][i];
            sum = sum + mat[i][n-1-i];
        }
        if(n%2 !=0) {
            sum = sum - mat[n/2][n/2];
        }
        System.out.println(sum);
    }
    public static int[][] take2DInput() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if (n == 0) {
            return new int[0][0];
        }
        int[][] mat = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                mat[row][col] = s.nextInt();
            }
        }
        return mat;
    }
    public static void main(String[] args) {
        int[][] mat = take2DInput();
        totalSum(mat);
    }
}
