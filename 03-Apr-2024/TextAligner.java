import java.util.List;
import java.util.ArrayList;

class TextAligner {
    public List<String> justifyText(String[] words, int maxWidth) {
        ArrayList<String> result = new ArrayList<>();
        int numWords = words.length, totalLength = 0, start = 0, wordLength = 0;
        boolean newLine = true;
        
        for (int i = 0; i < numWords; ++i) {
            totalLength += words[i].length();
            if (newLine) newLine = false;
            else totalLength += 1;

            if (totalLength > maxWidth) {
                result.add(justifyLine(start, i, words, maxWidth, wordLength));
                start = i;
                totalLength = words[i].length();
                wordLength = 0;
            }
            
            if (i == numWords - 1) 
                result.add(leftAlign(start, i + 1, words, maxWidth, wordLength + words[i].length()));
            wordLength += words[i].length();
        }
        return result;
    }
    
    private String justifyLine(int start, int end, String[] words, int maxWidth, int lineLength) {
        if (end - start == 1) return leftAlign(start, end, words, maxWidth, lineLength);
        
        int extraSpace = maxWidth - lineLength, eachSpace;
        char[] line = new char[maxWidth];
        
        for (int i = 0; start < end; i += eachSpace + words[start].length(), extraSpace -= eachSpace, ++start) {
            eachSpace = (int) Math.ceil((double) extraSpace / (end - start - 1));
            if (start == end - 1) eachSpace = 0;
            pasteWord(words[start], i, eachSpace, line);
        }
        return new String(line);
    }
    
    private String leftAlign(int start, int end, String[] words, int maxWidth, int lineLength) {
        char[] line = new char[maxWidth];
        for (int i = 0; start < end; i += words[start].length() + 1, ++start)
            pasteWord(words[start], i, start == (end - 1) ? maxWidth - (i + words[start].length()) : 1, line);
        return new String(line);
    }
    
    private void pasteWord(String word, int index, int spaces, char[] line) {
        for (int j = 0; j < word.length(); line[index++] = word.charAt(j), ++j);
        while (spaces-- > 0) line[index++] = ' ';
    }

    public static void main(String[] args) {
        TextAligner aligner = new TextAligner();

        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;

        List<String> justifiedText = aligner.justifyText(words, maxWidth);

        for (String line : justifiedText) {
            System.out.println(line);
        }
    }
}
