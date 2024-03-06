package March5;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.InputMismatchException;

class TrieNode {
    Map<Character, TrieNode> children;
    int frequency;

    TrieNode() {
        children = new HashMap<>();
        frequency = 0;
    }
}

public class ShortestPrefix {

    static TrieNode root;

    // Custom exception class for handling invalid input
    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }

    // Inserting the word into Trie Data Structure
    public static void insert(String word) {
        TrieNode current = root;
        for (char character : word.toCharArray()) {
            current.children.putIfAbsent(character, new TrieNode());
            current = current.children.get(character);
            current.frequency++;
        }
    }

    // Finding shortest prefix using Trie
    public static String findShortestUniquePrefix(String word) {
        StringBuilder prefix = new StringBuilder();
        TrieNode current = root;
        for (char character : word.toCharArray()) {
            prefix.append(character);
            current = current.children.get(character);
            if (current.frequency == 1) {
                break;
            }
        }
        return prefix.toString();
    }

    // Calling insert and findShortestUniquePrefix for each word
    public static String[] shortestUniquePrefix(List<String> words) {
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }

        String[] prefixes = new String[words.size()];
        for (int index = 0; index < words.size(); index++) {
            prefixes[index] = findShortestUniquePrefix(words.get(index));
        }
        return prefixes;
    }

    public static void main(String[] args) {
        try {
            // Taking a list of words as input
            Scanner scanner = new Scanner(System.in);
            List<String> wordList = new ArrayList<>();
            System.out.println("Enter the number of strings:");
            int stringCount = scanner.nextInt();

            // Check for negative or zero input
            if (stringCount <= 0) {
                throw new InvalidInputException("Number of strings must be a positive integer.");
            }

            System.out.println("Enter the strings:");
            for (int string = 0; string < stringCount; string++) {
                System.out.println("Enter word " + (string + 1) + ":");
                wordList.add(scanner.next());
            }

            // Storing the result in a String Array of Prefixes
            String[] prefixes = shortestUniquePrefix(wordList);
            for (int word = 0; word < wordList.size(); word++) {
                System.out.println(wordList.get(word) + "=" + prefixes[word]);
            }
            scanner.close();
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input format.");
        } catch (Exception e) {
            System.out.println("Error: An unexpected error occurred.");
        }
    }
}
