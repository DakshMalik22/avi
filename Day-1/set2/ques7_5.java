package set2;

public class ques7_5 {
    public static void main(String[] args) {


        for(int i=0;i<3;i++)
        {
            char ch ='*';

            for (int k=0;k<i;k++)
            {
                System.out.print(" ");
            }
            for(int j=0;j<3;j++)
            {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
