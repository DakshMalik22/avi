package Day_5;

public class ques2 {
    public static void main(String[] args) {
       int[] arr = new int[26];
       String s = "xxxxyz";
       int len = s.length();
       int count=0;
       for (int i=0;i<s.length();i++)
       {
           if(arr[s.charAt(i)-'a']==0)
           {
               count++;
           }
           arr[s.charAt(i)-'a']++;
       }

       int ans = len-count;
        System.out.println(ans);
    }
}
