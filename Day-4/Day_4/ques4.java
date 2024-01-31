package Day_4;

import java.util.Arrays;

public class ques4 {
    public static void main(String[] args) {
        String str1 = "sinrtg";
        String str2 = "string";

        char[]arr1 = new char[str1.length()];
        char[]arr2 = new char[str2.length()];
        for(int i=0;i<str1.length();i++)
        {
            arr1[i] = str1.charAt(i);
        }
        for(int i=0;i<str2.length();i++)
        {
            arr2[i] = str2.charAt(i);
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i=0;i< arr1.length;i++) {
            if(arr1[i]!=arr2[i])
            {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
