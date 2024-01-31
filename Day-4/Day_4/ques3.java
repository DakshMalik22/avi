package Day_4;
//3.All Substrings

public class ques3 {
    /*  public static void find(String substring,int i, int size,String ans) {
          if(i>=size)
          {
              if(!ans.isEmpty())System.out.println(ans);
              return;
          }
          ans.append(substring.charAt(i));
          find(substring,i+1,size,ans);


          ans.deleteCharAt(ans.length() - 1);
          find(substring,i+1,size,ans);

      }*/
    public static void main(String[] args) {
        String substring = "abc";


        String ans = "";
        int size = substring.length();
        for(int i=0;i<substring.length();i++)
        {
            for (int j=i+1;j<=substring.length();j++)
            {
                System.out.println(substring.substring(i,j));
            }
        }

    }
}

