package Day_9;

import java.util.ArrayList;

public class ques2 {
    public static void main(String[] args) {
        ArrayList<String>wordList = new ArrayList<>();
        wordList.add("cats");
        wordList.add("dog");
        wordList.add("sand");
        wordList.add("and");
        wordList.add("cat");

        String inputString = "catsandog";

        System.out.println(ans(wordList,inputString));//alt+enter

    }

    private static boolean ans(ArrayList<String> wordList, String inputString) {
      if(wordList.contains(inputString))
      {
          return true;
      }


        for (int i = 0; i < inputString.length(); i++) {
             String check =  inputString.substring(0,i);

             if(wordList.contains(check))
             {
                 return ans(wordList,inputString.substring(i));
             }

        }
        return false;
    }
}
