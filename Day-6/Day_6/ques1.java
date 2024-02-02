package Day_6;

import java.util.Scanner;

public class ques1 {
    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        int[][] array2D = new int[row][col];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array2D[i][j] = sc.nextInt();
                // You can assign any value here
            }
            System.out.println();
        }
        int ncol=0;
        for(int i=0;i<row;i++)
        {
            for(int j =0;j<col;j++)
            {
                if(array2D[i][j]==0)
                {
                    array2D[i][0]=0;

                    if(j!=0)
                    {
                        array2D[0][j] =0;
                    }
                    else
                    {
                        ncol = -1;
                    }
                }

            }
        }

        for (int i=1;i<row;i++)
        {
            for (int j=1;j<col;j++)
            {
                if(array2D[i][j]!=0)
                {
                    if(array2D[i][0]==0 || array2D[0][j]==0)
                    {
                        array2D[i][j]=0;
                    }
                }
            }
        }

        if(array2D[0][0]==0)
        {
            for (int i=0;i<col;i++)
            {
                array2D[0][i]=0;
            }
        }
        if(ncol==-1)
        {
            for (int i=0;i<row;i++)
            {
                array2D[i][0]=0;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(array2D[i][j] + " ");
            }
            System.out.println();
        }

    }

}
