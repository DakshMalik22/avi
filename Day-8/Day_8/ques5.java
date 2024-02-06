package Day_8;

public class ques5 {
    public static boolean checkString(String s) {
        // Base case: If the string is empty, return true
        if (s.isEmpty()) {
            return true;
        }

        // Check if the string starts with 'a'
        if (s.charAt(0) == 'a') {
            // If the first character is 'a', recursively check the remaining substring
            return checkString(s.substring(1));
        } else if (s.startsWith("bb")) {
            // If the string starts with "bb", recursively check the substring after "bb"
            if (s.length() > 2 && (s.charAt(2) == 'a')) {
                return checkString(s.substring(2));
            }
            if(s.substring(2).isEmpty())
            {
                return checkString(s.substring(2));
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String input1 = "aaa";
        String input2 = "abababa";

        // Check if the strings follow the rules and print the result
        System.out.println("Sample Output 1: " + checkString(input1)); // true
        System.out.println("Sample Output 2: " + checkString(input2)); // false
    }

}
//a. The string begins with an 'a'
//b. Each 'a' is followed by nothing or an 'a' or "bb"
//c. Each "bb" is followed by nothing or an 'a'
//If all the rules are followed by the given string, return true otherwise return false.