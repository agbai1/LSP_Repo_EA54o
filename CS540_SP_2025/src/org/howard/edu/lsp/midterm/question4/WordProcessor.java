package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * The WordProcessor class processes a sentence and returns all longest words
 */
public class WordProcessor {
    private String sentence; // Stores the sentence to be processed

    /**
     * Constructor to initialize the sentence
     *
     * @param sentence The input sentence to process
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Find and return all words with the max length in the sentence
     *
     * @return A list of longest words found in the sentence.
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords; // Return an empty list if sentence is empty or null
        }

        // Split the sentence into words
        String[] words = sentence.split("\\s+");
        
        int maxLength = 0;
        
        for (String word : words) {
            int length = word.length();
            
            if (length > maxLength) {
                maxLength = length;
                longestWords.clear(); 
                longestWords.add(word);
            } else if (length == maxLength) {
                longestWords.add(word); // Add word even if it's already present
            }
        }

        return longestWords;
    }
}
