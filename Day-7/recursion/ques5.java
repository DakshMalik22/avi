package Day_7.recursion;

public class ques5 {
    public static void ans(String s,int i,StringBuilder sb) {
        if(i>=s.length())
        {
            System.out.println(sb);
            return;
        }
        if(s.charAt(i)!=s.charAt(i-1))
        {
            sb.append(s.charAt(i));
        }
        ans(s,i+1,sb);
    }
    public static void main(String[] args) {
        String s="xxxyyyzwwzzz";
        int i=1;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        ans(s,i,sb);
    }
}
