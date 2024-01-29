package Assigment;

public class ques6 {
    public static void main(String[] args) {

        int[] arr1 = {4,5,1};
        int[] arr2 = {3,4,5};

        int sum1 = 0;
        int sum2 = 0;
        for(int i=0;i<arr1.length;i++)
        {
            sum1 =  sum1*10+arr1[i];
            sum2 =  sum2*10+arr2[i];
        }
        int ans=0;
        ans = sum1+sum2;

        int[] arr3 = new int[3];

        for(int i=2 ; i >= 0 ;i--)
        {
             arr3[i] = ans%10;
             ans = ans/10;
        }
        for(int i=0;i<arr3.length;i++)
        {
            System.out.print(arr3[i]+" ");
        }

    }
}
