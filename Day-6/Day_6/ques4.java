package Day_6;

import java.util.PriorityQueue;

public class ques4 {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[][] array2D = {{10,20,30,40} ,{15,20,35,42},
                           {27,29,37,46}, {32,33,38,49}
                          };

        for (int i=0;i<array2D.length;i++)
        {
            for (int j=0;j<array2D[0].length;j++)
            {
                minHeap.add(array2D[i][j]);
            }
        }

        while(!minHeap.isEmpty())
        {
            System.out.print(minHeap.poll()+" ");
        }
    }
}

