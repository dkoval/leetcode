package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3746/">Longest String Chain</a>
 *
 * Given a list of words, each word consists of English lowercase letters.
 * <p>
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it
 * equal to word2. For example, "abc" is a predecessor of "abac".
 * <p>
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2,
 * word_2 is a predecessor of word_3, and so on.
 * <p>
 * Return the longest possible length of a word chain with words chosen from the given list of words.
 */
public class LongestStringChain {

    public int longestStrChain(String[] words) {
        // sort array of words by their length
        Arrays.sort(words, Comparator.comparingInt(String::length));
        // dp[word] holds the length of the longest for `word`
        Map<String, Integer> dp = new HashMap<>();

        int longestChain = 0;
        for (String word : words) {
            int longestChainSoFar = 0;
            // generate all possible words that lead to the current `word` by removing i-th character
            for (int i = 0; i < word.length(); i++) {
                String prevWord = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(prevWord)) {
                    longestChainSoFar = Math.max(longestChainSoFar, dp.get(prevWord));
                }
            }
            longestChainSoFar++;
            dp.put(word, longestChainSoFar);
            longestChain = Math.max(longestChain, longestChainSoFar);
        }
        return longestChain;
    }
}
