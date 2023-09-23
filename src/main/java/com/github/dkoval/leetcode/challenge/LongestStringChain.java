package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-string-chain/">Longest String Chain</a>
 * <p>
 * Given a list of words, each word consists of English lowercase letters.
 * <p>
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it
 * equal to word2. For example, "abc" is a predecessor of "abac".
 * <p>
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2,
 * word_2 is a predecessor of word_3, and so on.
 * <p>
 * Return the longest possible length of a word chain with words chosen from the given list of words.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 1000</li>
 *  <li>1 <= words[i].length <= 16</li>
 *  <li>words[i] only consists of lowercase English letters</li>
 * </ul>
 */
public class LongestStringChain {

    public int longestStrChain(String[] words) {
        // sort words[] by their length
        Arrays.sort(words, Comparator.comparingInt(String::length));
        // dp[word] is the length of the longest chain ending at `word`
        Map<String, Integer> dp = new HashMap<>();

        int maxLength = 1;
        for (String word : words) {
            int currLength = 1;
            // 1 <= words[i].length <= 16, therefore we can brute-forcefully
            // generate all possible predecessors of word by removing the word's i-th character
            for (int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(predecessor)) {
                    // can extend the chain [... -> predecessor -> word]
                    currLength = Math.max(currLength, 1 + dp.get(predecessor));
                }
            }
            dp.put(word, currLength);
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }
}
