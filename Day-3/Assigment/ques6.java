package Assigment;

public class ques6 {
    public static void main(String[] args) {

        int[] arr1 = {4,5,1,2};
        int[] arr2 = {3,4,5};

        int sum1 = 0;
        int sum2 = 0;
        for(int i=0;i<arr1.length;i++)
        {
            sum1 =  sum1*10+arr1[i];

        }
        for(int i=0;i<arr2.length;i++)
        {

            sum2 =  sum2*10+arr2[i];
        }
        int ans=0;
        ans = sum1+sum2;

      int size=  Math.max(arr1.length, arr2.length) + 1;
        int[] arr3 = new int[size];

        for(int i=arr3.length-1 ; i >= 0 ;i--)
        {
             arr3[i] = ans%10;
             ans = ans/10;
        }
        if(ans!=0)
        {
            arr3[0] = ans;
        }

        for(int i=0;i<arr3.length;i++)
        {
            if (i == 0 && arr3[i] == 0) {
                continue; // skip leading zeros
            }
            System.out.print(arr3[i]+" ");
        }

    }
}
