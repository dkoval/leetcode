package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/">Longest Palindrome by Concatenating Two Letter Words</a>
 * <p>
 * You are given an array of strings words. Each element of words consists of two lowercase English letters.
 * <p>
 * Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.
 * <p>
 * Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
 * <p>
 * A palindrome is a string that reads the same forward and backward.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 10^5</li>
 *  <li>words[i].length == 2</li>
 *  <li>words[i] consists of lowercase English letter</li>
 * </ul>
 */
public interface LongestPalindromeByConcatenatingTwoLetterWords {

    int longestPalindrome(String[] words);

    class LongestPalindromeByConcatenatingTwoLetterWordsRev1 implements LongestPalindromeByConcatenatingTwoLetterWords {

        @Override
        public int longestPalindrome(String[] words) {
            Map<String, Integer> counts = new HashMap<>();
            for (String word : words) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }

            // idea: build the longest possible palindrome expanding from the center
            int pairs = 0;
            int extra = 0;
            Set<String> used = new HashSet<>();
            for (String word : counts.keySet()) {
                if (used.contains(word)) {
                    continue;
                }

                if (word.charAt(0) == word.charAt(1)) {
                    // if word is a 2 letters palindrome:
                    // xx + [palindrome] + xx
                    int count = counts.get(word);
                    pairs += count / 2;

                    if (count % 2 != 0) {
                        // We can also use exactly one in the middle to form an even longer palindrome
                        extra = 2;
                    }
                } else {
                    // otherwise, check if there exists a reverse(word):
                    // ab + [palindrome] + ba
                    String reversedWord = new StringBuilder(word).reverse().toString();
                    if (counts.containsKey(reversedWord)) {
                        pairs += Math.min(counts.get(word), counts.get(reversedWord));
                        used.add(reversedWord);
                    }
                }

                used.add(word);
            }
            return pairs * 2 * 2 + extra;
        }
    }
}
