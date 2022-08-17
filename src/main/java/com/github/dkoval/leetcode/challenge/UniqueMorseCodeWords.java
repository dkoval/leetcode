package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/unique-morse-code-words/">Unique Morse Code Words</a>
 * <p>
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
 * <ul>
 *  <li>'a' maps to ".-",</li>
 * <li>'b' maps to "-...",</li>
 * <li>'c' maps to "-.-.", and so on.</li>
 * </ul>
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 * <pre>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * </pre>
 * Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.
 * <p>
 * For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
 * <p>
 * Return the number of different transformations among all words we have.
 */
public interface UniqueMorseCodeWords {

    int uniqueMorseRepresentations(String[] words);

    class UniqueMorseCodeWordsRev1 implements UniqueMorseCodeWords {

        private final String[] MAPPING = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        @Override
        public int uniqueMorseRepresentations(String[] words) {
            Set<String> uniq = new HashSet<>();
            for (String word : words) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    sb.append(MAPPING[c - 'a']);
                }
                uniq.add(sb.toString());
            }
            return uniq.size();
        }
    }
}
