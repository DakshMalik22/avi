package Assigment;

public class ques12 {
    public static void main(String[] args) {
        int[] arr = {13,46,24,52,20,9};


         for(int i=0;i<arr.length;i++)
         {
             int j = i;
             while(j>0 && arr[j]<arr[j-1] )
             {
                 int temp = arr[j - 1];
                 arr[j - 1] = arr[j];
                 arr[j] = temp;
                 j--;
             }
         }
         for (int i=0;i<arr.length;i++)
         {
             System.out.print(arr[i]+" ");
         }
    }
}
