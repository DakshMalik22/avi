package Day_7;

public class ques3 {
    public static void main(String[] args) {
        String s = "AbbaaA";

        int count1=0;
        int count2=0;

        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u')
            {
                count1++;
            }
        }

        for (int i = s.length()/2; i < s.length(); i++) {
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u')
            {
                count2++;
            }
        }

        if(count1==count2)
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }

    }
}
