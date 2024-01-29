package set2;

import java.util.ArrayList;
import java.util.Scanner;

public class ques4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int inp = input.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=2;i<=inp/2;i++)
        {
            if(inp%i==0)
            {
                list.add(i);
            }
        }
        if(list.isEmpty())
        {
            System.out.println("-1");
        }
        else
        {
            for (int i=0;i<list.size();i++)
            {
                System.out.println(list.get(i));
            }
        }
    }




}
