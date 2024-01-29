package set2;

import java.util.ArrayList;

public class ques7_7 {
    public static void main(String[] args) {
        ArrayList<Integer>myList = new ArrayList<>();

        for (int i=1;i<=7;i+=2)
        {
            myList.add(i);
        }


        for(int i=0;i<7;i++)
        { int mm;
            mm = myList.getFirst();
            myList.remove(myList.getFirst());

            myList.add(mm);

            for (int j=0;j< myList.size();j++)
            {
                System.out.print(myList.get(j));

            }
            System.out.println();
        }

    }
}
