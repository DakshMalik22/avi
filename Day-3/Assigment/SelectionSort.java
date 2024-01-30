package Assigment;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,2,8,1,9,7};
        int n = arr.length;

        for(int i=0;i<n-1;i++)
        {
            int check = i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[j]<arr[check])
                {
                    check  =  j;
                }

            }

            int temp = arr[i];
            arr[i] = arr[check];
            arr[check] = temp;


        }
        for (int i=0;i< arr.length;i++) {
            System.out.print(arr[i]+" ");
        }


    }
}