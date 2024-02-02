package Day_6;

public class ques2 {
    static int add(int[][] array2D,int row,int col)
    {
        int sum1=0;
        if(row>0 )
        {
            sum1 +=array2D[row-1][col];
        }
        if(row< array2D.length-1)
        {
            sum1+=array2D[row+1][col];
        }
        if(col>0)
        {
            sum1+=array2D[row][col-1];
        }
        if(col<array2D[0].length-1)
        {
            sum1+=array2D[row][col+1];
        }
        return sum1;

    }

    public static void main(String[] args) {

        int[][] array2D = {{1,0} ,{0,1}};

        int sum =0;

        for (int i=0;i< array2D.length;i++)
        {
            for (int j=0;j<array2D[0].length;j++)
            {
                if(array2D[i][j]==0)
                {
                    sum+=add(array2D,i,j);
                }
            }
        }
        System.out.println(sum);
    }
}
