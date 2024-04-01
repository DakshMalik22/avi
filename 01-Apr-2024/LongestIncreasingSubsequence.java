
package javaBasics.date_01_04_24;

import java.io.IOException;

public class LongestIncreasingSubsequence
{
    private static int lowerBound(int[] a, int low, int high, int element)
    {
        while (low < high)
        {
            int middle = low + (high - low) / 2;
            if (element > a[middle])
            {
                low = middle + 1;
            } else
            {
                high = middle;
            }
        }

        return low;
    }
    public static int longestIncreasingSubsequence(int arr[])
    {
        int n = arr.length;
        int dp[] = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++)
        {
            int position = lowerBound(dp, 0, ans, arr[i]);
            dp[position] = arr[i];

            if (position == ans)
            {
                ans++;
            }
        }

        return ans;
    }


    public static void main(String args[])
            throws IOException
    {
        int arr[] = {5,4,11,1,16,8};
        int n = arr.length;
        System.out.println(longestIncreasingSubsequence(arr));
    }
}

