package set2;

public class ques5 {
    public static int ser(int n,int v) {
        if(v==0){
            return 1;
        }
        else if (v%2==0) {
            return ser(n*n, v/2);
        } else if (v%2==1) {
            return n*ser(n, v-1);
        }
        return 1/ser(n, -v);
    }
    public static void main(String[] args) {
        int n=3;
         int v = 2;

         int ans = ser(n,v);

        System.out.println(ans);

    }
}
