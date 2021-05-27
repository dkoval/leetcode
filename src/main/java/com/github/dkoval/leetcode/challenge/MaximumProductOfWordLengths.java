package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/601/week-4-may-22nd-may-28th/3757/">Maximum Product of Word Lengths</a>
 * <p>
 * Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words
 * do not share common letters. If no such two words exist, return 0.
 */
public interface MaximumProductOfWordLengths {

    int maxProduct(String[] words);

    class MaximumProductOfWordLengthsBruteForce implements MaximumProductOfWordLengths {

        @Override
        public int maxProduct(String[] words) {
            int n = words.length;
            int answer = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (!shareCommonLetters(words[i], words[j])) {
                        answer = Math.max(answer, words[i].length() * words[j].length());
                    }
                }
            }
            return answer;
        }

        private boolean shareCommonLetters(String word1, String word2) {
            Set<Character> uniqueChars = new HashSet<>();
            String shorter = (word1.length() < word2.length()) ? word1 : word2;
            for (int i = 0; i < shorter.length(); i++) {
                uniqueChars.add(shorter.charAt(i));
            }

            String longer = (shorter == word1) ? word2 : word1;
            for (int i = 0; i < longer.length(); i++) {
                if (uniqueChars.contains(longer.charAt(i))) {
                    return true;
                }
            }
            return false;
        }
    }
}
