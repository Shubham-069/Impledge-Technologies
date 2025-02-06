import java.io.*;
import java.util.*;

public class WordComposition {

    // Memoization map to store whether a word is a compound word
    private static final Map<String, Boolean> memo = new HashMap<>();

    // Recursive function to check if a word can be formed using other words
    public static boolean canBeFormed(String word, Set<String> wordSet) {
        if (memo.containsKey(word))
            return memo.get(word);

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (wordSet.contains(prefix) &&
                    (wordSet.contains(suffix) || canBeFormed(suffix, wordSet))) {
                memo.put(word, true);
                return true;
            }
        }

        memo.put(word, false);
        return false;
    }

    public static void findLongestCompoundWords(String fileName) {
        long startTime = System.currentTimeMillis();

        List<String> words = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();

        // Read words from file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim());
                wordSet.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort words based on length
        words.sort(Comparator.comparingInt(String::length));

        String longestWord = "";
        String secondLongestWord = "";

        // Check for compounded words
        for (String word : words) {
            wordSet.remove(word); // Temporarily remove to avoid self-matching
            if (canBeFormed(word, wordSet)) {
                if (word.length() > longestWord.length()) {
                    secondLongestWord = longestWord;
                    longestWord = word;
                } else if (word.length() > secondLongestWord.length()) {
                    secondLongestWord = word;
                }
            }
            wordSet.add(word); // Restore the word
        }

        long endTime = System.currentTimeMillis();

        // Output results
        System.out.println("Longest Compound Word: " + longestWord);
        System.out.println("Second Longest Compound Word: " + secondLongestWord);
        System.out.println("Time taken to process file " + fileName + ": " + (endTime - startTime) + " milliseconds");
    }

    public static void main(String[] args) {
        findLongestCompoundWords("Input_01.txt"); // Small word list
        findLongestCompoundWords("Input_02.txt"); // Large word list
    }
}
