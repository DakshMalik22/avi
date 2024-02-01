package Day_5;

import java.util.Stack;

public class ques3 {
    public static void main(String[] args) {
        Stack<Character>s = new Stack<>();
        String store = "((()()()";

        for(int i=0;i<store.length();i++)
        {
            if(s.empty())
            {
                s.push(store.charAt(i));
            }
            else
            {
                if(store.charAt(i)==')' && s.peek()=='(' || store.charAt(i)=='(' && s.peek()==')')
                {
                    s.pop();
                }
                else {
                    s.push(store.charAt(i));
                }
            }

        }
        System.out.println(s.size());
    }
}
