package set2;

public class ques7_3 {

    public static void main(String[] args) {

        for(int i=0;i<3;i++)
        {
            char ch = (char)('A'+i);

            for(int j=0;j<=i;j++)
            {
                System.out.print(ch);
            }
            System.out.println();

        }

    }
}
