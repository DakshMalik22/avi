package Questions;

public class ques2 {
    public static void main(String[] args) {
        int []petrol = {4,6,7,4};
        int[] distance = {6,5,3,5};
        int balance= 0;
        int deficit=0;
        int start=0;

        for(int i=0;i<petrol.length;i++)
        {
          balance+=petrol[i]-distance[i];
          if(balance<0)
          {
              deficit+=balance;
              start=i+1;
              balance =0;
          }
        }

        if(balance+deficit>=0)
        {
            System.out.println(start);
        }
        else
        {
            System.out.println("-1");
        }
    }
}
