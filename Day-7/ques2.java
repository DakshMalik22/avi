package Day_7;

public class ques2 {
    public static void main(String[] args) {
        String[] arr = {"break3ing news5:", "1A 1circle is round!"};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< arr.length;i++)
        {
            String store = arr[i];
            boolean check =true;
            for (char c:store.toCharArray())
            {
                if(!Character.isDigit(c) )
                {
                    if(check==true)
                    {

                        sb.append( Character.toUpperCase(c));
                        check=false;
                    }
                    else
                    {
                        sb.append(c);
                        check=false;
                    }


                }
                if(Character.isWhitespace(c))
                {
                    check=true;
                }

            }
            sb.append(" ");
        }

        String as = sb.toString().trim();
        System.out.println(as);

        }

    }

