package Day_8;

public class ques10 {
    static int fact(int n)
    {
        if(n<=1)
        {
            return 1;
        }

        return n*fact(n-1);
    }

    public static void main(String[] args) {

        int n=5;
        int r=2;

        int ans = fact(n)/(fact(n-r)*fact(r));
        System.out.println(ans);
    }
}
