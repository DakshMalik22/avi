package Day_5;

public class ques1 {
    public static void main(String[] args) {
        String str1 = "ab";
        String str2 = "ba";

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i=0;i<str1.length();i++)
        {
            arr1[str1.charAt(i)-'a']++ ;
            arr2[str2.charAt(i)-'a']++;
        }

        for(int i=0;i< arr1.length;i++)
        {
            if(arr1[i]!=arr2[i])
            {
                System.out.println("False");
                return;
            }
        }
        int len = str1.length()/2;

        String store1 = "";
        String store2 = "";

        store1 = str1.substring(0,len);
        store2 = str1.substring(len,str1.length());

        String store3 ="";
        String store4= "";

        store3 =  str2.substring(0,len);
        store4 = str2.substring(len,str2.length());
        boolean find = false;
        if(store1.equals(store3) && store2.equals(store4) || store1.equals(store4) && store2.equals(store3))
        {
            find=true;
        }

        if(find == true)
        {
            System.out.println(1);
        }
        else {
            System.out.println("False");
        }

    }
}
