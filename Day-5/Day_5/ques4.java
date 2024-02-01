package Day_5;

public class ques4 {
    public static void main(String[] args) {
        String a = "17281";
        String b = "91276";

        int pus1 = 0;
        int pus2 =0;
        for(int i=0;i<a.length();i++)
        {
            int d = a.charAt(i)-'0';
            pus1 = pus1*10+d;
        }

        for(int i=0;i<b.length();i++)
        {
            int d = b.charAt(i)-'0';
            pus2 = pus2*10+d;
        }

        int multi = pus1*pus2;
        System.out.println(multi);
        String ans = String.valueOf(multi);
        System.out.println(ans);

    }
}
