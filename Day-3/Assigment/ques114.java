package Assigment;

public class ques114
{
    public static void main(String[] args) {
        int[] arr = {6 , 2 , 8, 4 ,10};

        for(int i= arr.length-1;i>=0;i--)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i=0;i< arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
