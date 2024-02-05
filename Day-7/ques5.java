package Day_7;

public class ques5 {
    public static void main(String[] args) {

        String str = "aazbbby";

        StringBuilder s = new StringBuilder();
        s.append(str.charAt(0));
     for(int i=1;i<str.length();i++)
     {
         if(str.charAt(i)!=str.charAt(i-1))
         {
             s.append(str.charAt(i));
         }

     }
        System.out.println(s.toString());
    }
}
