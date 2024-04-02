import java.util.InputMismatchException;
import java.util.Scanner;

// Node of Trie
class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    TrieNode() {
        children = new TrieNode[26]; // Assuming lowercase English letters only
        isEnd = false;
    }
}

// Trie class
class Trie {
    TrieNode root;

    // Constructor
    Trie() {
        this.root = new TrieNode();
    }

    // Method to insert string into trie
    public void insert(String str) {
        TrieNode current = root;
        for (char ch : str.toCharArray()) {
            int index = ch - 'a'; // Convert character to index
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true; // Mark end of word
    }

    // Wrapper method around countNodes
    public int countNodes() {
        return countNodes(root);
    }

    // Method to count nodes in trie
    public int countNodes(TrieNode root) {
        int count = 0;
        if (root == null) {
            return count;
        }
        ++count; // Count the current TrieNode
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count;
    }
}

public class DistinctSubstringsCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the string:");
        try {
            String input = scanner.next();
            Trie trie = new Trie();
            // Insert every substring of input into trie
            for (int i = 0; i < input.length(); ++i) {
                for (int j = i + 1; j <= input.length(); ++j) {
                    trie.insert(input.substring(i, j));
                }
            }
            System.out.println("Number of distinct substrings: " + trie.countNodes());
            // Rest of the code
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid string.");
        } finally {
            scanner.close(); // Close scanner
        }
    }
}
