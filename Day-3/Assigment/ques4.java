package Assigment;

public class ques4 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int ans =1;

        for(int i=0;i<arr.length;i++)
        {
            ans *=arr[i];
        }
        for(int j=0;j<arr.length;j++)
        {
            arr[j]= ans/arr[j];
        }
        for(int k=0;k< arr.length;k++)
        {
            System.out.print(arr[k]);
        }

    }
}
