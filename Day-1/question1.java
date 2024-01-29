package set1;

public class question1 {
    public static void main(String[] args) {
        String input  = "Ab#$Cd";
        StringBuilder result = new StringBuilder();

        for(int i=0;i<input.length();i++)
        {
            char check = input.charAt(i);
            if(Character.isUpperCase(check)){
                result.append(Character.toLowerCase(check));
            }
            else if(Character.isLowerCase(check)){
                result.append(Character.toUpperCase(check));
            }
            else{
                result.append(check);
            }
        }
        System.out.println(result);
    }
}
