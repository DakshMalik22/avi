package Day_7;

public class ques4 {
    public static void main(String[] args) {
        String a = "111";
        String b = "10";
        int carry=0;
        int i=0;
StringBuilder sb = new StringBuilder();
        while(i<a.length()|| i<b.length() || carry==1)
        {
            int x=0;
            if(i<a.length() && a.charAt(a.length()-i-1)=='1')
            {
                x=1;
            }
            int y=0;
            if(i<b.length() && b.charAt(b.length()-i-1) =='1')
            {
                y=1;
            }

            int ans = (y+x+carry)%2;
            carry = (y+x+carry)/2;
            i++;
            sb.append(ans);

        }
        sb.reverse();
        System.out.println(sb.toString());


    }
}
