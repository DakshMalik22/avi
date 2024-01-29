package set1;

public class ques4 {
    public static void main(String[] args) {
        String s = "ae#zyu*";
        int v = 0;
        int con = 0;
        int cha = 0;
        for(int i =0;i<s.length();i++)
        {
            char c =  s.charAt(i);

            if(c=='a' || c == 'e' || c=='i' || c=='o' || c=='u')
            {
                v++;
            }
            else if(Character.isLowerCase(c) || Character.isUpperCase(c))
            {
                con++;
            }
            else
            {
                cha++;
            }
        }
        System.out.println(v );
        System.out.println(cha );
        System.out.println(con );
    }
}
