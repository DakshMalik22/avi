package java_Learning;

public class fourth {

    public static void main(String[] args) {
        int x = 9;
        int k=0;
        int v=1;
        for(int i=1;i<=x;i++)
        {
            k++;
            for (int j = 1;j<=k;j++)
            {
                if(v==10) {
                    System.out.print(0);
                    return;
                }
                System.out.print(v++);


            }
            System.out.println();
        }

    }
}
