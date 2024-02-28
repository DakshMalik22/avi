import java.util.LinkedList;
import java.util.Scanner;

public class Wordprocessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompting the user to input the string
        System.out.print("Enter the input string: ");
        String str = sc.nextLine();
        int start;
        int last;

        // Loop to ensure valid start index input
        do {
            System.out.print("Enter the start index: ");
            start = sc.nextInt();
        }
        while (start<0 || start>str.length()-1);

        // Loop to ensure valid last index input
        do {
            System.out.print("Enter the last index: ");
            last = sc.nextInt();
        }
        while (last<start || last>str.length());

        // Creating a linked list to store characters of the string
        LinkedList<Character> ll = new LinkedList<>();
        for(int i=0; i<str.length(); i++){
            ll.add(str.charAt(i));
        }

        // Printing characters from start to last index
        for(int index=start; index<=last; index++){
            System.out.print(ll.get(index));
        }
    }
}

