package Day_7.recursion;

public class ques4 {
    public static void ans(String s,StringBuilder store,int i)
    {
      if(i>=s.length())
      {
          System.out.println(store.toString());
          return;
      }
       if(s.charAt(i)!='x')
       {
           store.append(s.charAt(i));
       }

       ans(s,store,i+1);
    }
    public static void main(String[] args) {
        String s = "xx";


        StringBuilder store = new StringBuilder();
        int i=0;
        ans(s,store,i);
    }
}
