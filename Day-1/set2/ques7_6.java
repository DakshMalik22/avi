package set2;

public class ques7_6 {
    public static void main(String[] args) {
         int n=3;

         for(int i=1;i<=3;i++)
         {
             for (int j=3-i;j>0;j--)
             {
                 System.out.print(" ");
             }

             for(int k=1;k<=i;k++)
             {
                 System.out.print(k);

             }

             System.out.println();
         }
    }
}
