package set2;

public class ques7_4 {
    public static void main(String[] args) {
        int n=5;

        for(int i=0;i<n;i++)
        {
            char ch = (char)('E'-i);
            for(int j=0;j<=i;j++)
            {
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }
}
