package Day_7;

public class ques1 {
    public static void main(String[] args) {
        int[]arr = {5,5,5};

        int ecount  = 0;
        int ocount=0;

        for(int i=0;i< arr.length;i++)
        {
            if(arr[i]%2==0)
            {
                ecount+=1;
            } else if (arr[i]%2!=0 &&arr[i]!=5) {
                ocount+=3;
            }
            else if (arr[i]%2!=0 && arr[i]==5)
            {
               ocount+=5;
            }
        }
        int ans=  ocount+ecount;
        System.out.println(ans);

    }
}
