package Day_8;

public class ques12 {
    static String ans(String s)
    {
        boolean find = false;

        StringBuilder sc = new StringBuilder(s);

        for (int i=0;i< sc.length()-1;i++)
        {
            if(sc.charAt(i) == sc.charAt(i+1))
            {
                sc.delete(i,i+2);
                find=true;
                break;
            }
        }
        if(find==true)
        {
            return ans(sc.toString());
        }
        else
        {
            return sc.toString();
        }

    }


    public static void main(String[] args) {
        String s ="azxxzy";

        System.out.println(ans(s));
    }
}
