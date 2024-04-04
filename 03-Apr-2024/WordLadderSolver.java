package myPackage.myProject;

import java.util.*;

class WordLadderSolver {
    String endWord;
    HashMap<String, Integer> wordMap = new HashMap<>();
    List<List<String>> ladderResults = new ArrayList<>();

    public void explorePaths(String currentWord, List<String> sequence) {
        if (currentWord.equals(endWord)) {
            List<String> reversedList = new ArrayList<>(sequence);
            Collections.reverse(reversedList);
            ladderResults.add(reversedList);
            return;
        }
        String word = currentWord;
        int steps = wordMap.get(word);
        for (int i = 0; i < endWord.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                char[] helper = word.toCharArray();
                helper[i] = j;
                String str = new String(helper);
                if (wordMap.containsKey(str) && wordMap.get(str) + 1 == steps) {
                    sequence.add(str);
                    explorePaths(str, sequence);
                    sequence.remove(sequence.size() - 1);
                }
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String targetWord, List<String> wordList) {
        endWord = targetWord;
        HashSet<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        wordMap.put(beginWord, 1);
        queue.add(beginWord);
        wordSet.remove(beginWord);
        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            int step = wordMap.get(currentWord);
            if (currentWord.equals(endWord)) {
                break;
            }
            for (int i = 0; i < endWord.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    char[] helper = currentWord.toCharArray();
                    helper[i] = j;
                    String str = new String(helper);
                    if (wordSet.contains(str)) {
                        queue.add(str);
                        wordMap.put(str, step + 1);
                        wordSet.remove(str);
                    }
                }
            }
        }
        if (wordMap.containsKey(endWord)) {
            List<String> solution = new ArrayList<>();
            solution.add(endWord);
            explorePaths(endWord, solution);
        }
        return ladderResults;
    }

    public static void main(String[] args) {
        WordLadderSolver solver = new WordLadderSolver();

        String startWord = "hit";
        String targetWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        List<List<String>> ladders = solver.findLadders(startWord, targetWord, wordList);
        System.out.println("Ladders found:");
        for (List<String> ladder : ladders) {
            System.out.println(ladder);
        }
    }
}
