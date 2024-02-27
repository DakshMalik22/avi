package Questions;

import java.util.Scanner;
import java.util.Vector;

public class ques1 {
    public static void main(String[] args) {
        Vector<Integer>vec = new Vector<>();
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int windSize = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            vec.add(scanner.nextInt() );

        }

        int i = 0;
        int j = 0;
        int sum = 0;
        Vector<Integer>ans = new Vector<>();

        while (j<size)
        {
            if (j-i+1<windSize)
            {
                sum+=vec.get(j);
                j++;
            }

            if(j-i+1==windSize)
            {
                sum+=vec.get(j);
                int avg = sum/windSize;
                ans.add(avg);
                j++;
                i++;

            }


        }
        System.out.println(ans.toString());

    }

}
