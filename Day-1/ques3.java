package set1;

public class ques3 {
    public static void main(String[] args) {
        int input= 0;
        int count = 0;
        int x = input;
        if(input==0)
        {
            System.out.println(1);
        }
        while(x!=0)
        {
            x = x/10;
            count++;
        }
        System.out.println(count);
    }
}
