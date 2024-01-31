package Day_4;

public class ques1 {
    public static void main(String[] args) {
        String ques = "This is Avisoft";
        int i=0;
        int ans=1;

        while(i<ques.length())
        {
          if(ques.charAt(i)==' ')
          {
              ans++;
              i++;
          }
          else
          {
              i++;
          }

        }
        System.out.println(ans);

    }

}
