package Day3;

public class ques4 {
    public static void main(String[] args) {
        int[] arr  = {0 ,1 ,2 ,2 ,1 ,0};
        int one=0;
        int zero=0;
        int last = arr.length-1;

        while(one<=last)
        {
            if(arr[one]==0)
            {
                int temp=arr[one];
                arr[one] = arr[zero];
                arr[zero] = temp;
                one++;
                zero++;
            }
            else if(arr[one]==2)
            {

                    int temp=arr[one];
                    arr[one] = arr[last];
                    arr[last] = temp;

                    last--;
            }
            else
            {
                one++;
            }
        }
        for (int i=0;i< arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
