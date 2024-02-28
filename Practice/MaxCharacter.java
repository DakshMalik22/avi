import java.util.Scanner;

public class MaxCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompting the user to input the string
        System.out.print("Enter the input string: ");
        String str = sc.nextLine();

        // Array to store the count of each letter's occurrences
        int[] letterCount = new int[256]; // Assuming ASCII characters

        // Loop to iterate through each character in the input string
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            // Checking if the character is a letter
            if(Character.isLetter(c)){
                letterCount[c]++; // Incrementing the count for the respective character
            }
        }

        char result = ' '; // Variable to store the letter with the highest occurrence
        int max = 0; // Variable to store the maximum occurrence count

        // Loop to find the letter with the highest occurrence
        for(int index=0; index<letterCount.length; index++){
            if (letterCount[i] > max) {
                max = letterCount[index]; // Updating the maximum occurrence count
                result = (char) index; // Updating the letter with the highest occurrence
            }
        }

        // If no letter is present in the entered string
        if(max==0){
            System.out.println("No letter is present in the entered string.");
            return;
        }

        // Printing the letter with the highest occurrence
        System.out.println("The letter with the highest occurrence is: "+result );
    }
}


