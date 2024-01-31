package Day_4;
//String Palindrome

public class ques2 {
    public static void main(String[] args) {
        String palind = "malayalam";

        int i=0;
        int j = palind.length()-1;

        while(i<=j)
        {
            if(palind.charAt(i)!=palind.charAt(j))
            {
                System.out.println("false");
               return;
            }
            else
            {
                i++;
                j--;
            }
        }
        System.out.println(" true ");
    }
}
