package com.github.dkoval.leetcode.challenge;

import java.util.BitSet;
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

    // O(C(n, 2)) time
    class MaximumProductOfWordLengthUsingBitSet implements MaximumProductOfWordLengths {

        @Override
        public int maxProduct(String[] words) {
            int n = words.length;
            int answer = 0;
            BitSet[] masks = computeBitmasks(words);
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (!masks[i].intersects(masks[j])) {
                        // no common letters
                        answer = Math.max(answer, words[i].length() * words[j].length());
                    }
                }
            }
            return answer;
        }

        private BitSet[] computeBitmasks(String[] words) {
            int n = words.length;
            BitSet[] masks = new BitSet[n];
            for (int i = 0; i < n; i++) {
                masks[i] = bitmask(words[i]);
            }
            return masks;
        }

        private BitSet bitmask(String word) {
            // 26 lowercase English letters
            BitSet mask = new BitSet(26);
            for (int i = 0; i < word.length(); i++) {
                mask.set(word.charAt(i) - 'a', true);
            }
            return mask;
        }
    }

    // O(C(n, 2)) time
    class MaximumProductOfWordLengthUsingBitmask implements MaximumProductOfWordLengths {

        @Override
        public int maxProduct(String[] words) {
            int n = words.length;
            int answer = 0;
            int[] masks = computeBitmasks(words);
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((masks[i] & masks[j]) == 0) {
                        // no common letters
                        answer = Math.max(answer, words[i].length() * words[j].length());
                    }
                }
            }
            return answer;
        }

        private int[] computeBitmasks(String[] words) {
            int n = words.length;
            int[] masks = new int[n];
            for (int i = 0; i < n; i++) {
                masks[i] = bitmask(words[i]);
            }
            return masks;
        }

        private int bitmask(String word) {
            int mask = 0;
            for (int i = 0; i < word.length(); i++) {
                int offset = word.charAt(i) - 'a';
                // set `offset`-th bit to 1
                mask |= (1 << offset);
            }
            return mask;
        }
    }
}
