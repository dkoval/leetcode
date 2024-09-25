package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/sum-of-prefix-scores-of-strings/">Sum of Prefix Scores of Strings</a>
 * <p>
 * You are given an array words of size n consisting of non-empty strings.
 * <p>
 * We define the score of a string word as the number of strings words[i] such that word is a prefix of words[i].
 * <p>
 * For example, if words = ["a", "ab", "abc", "cab"], then the score of "ab" is 2, since "ab" is a prefix of both
 * "ab" and "abc".
 * <p>
 * Return an array answer of size n where answer[i] is the sum of scores of every non-empty prefix of words[i].
 * <p>
 * Note that a string is considered as a prefix of itself.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 1000</li>
 *  <li>1 <= words[i].length <= 1000</li>
 *  <li>words[i] consists of lowercase English letters</li>
 * </ul>
 */
public interface SumOfPrefixScoresOfStrings {

    int[] sumPrefixScores(String[] words);

    class SumOfPrefixScoresOfStringsRev1 implements SumOfPrefixScoresOfStrings {

        @Override
        public int[] sumPrefixScores(String[] words) {
            int n = words.length;

            Trie t = new Trie(words);
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = t.getSumOfPrefixScores(words[i]);
            }
            return ans;
        }

        private static class Trie {
            private final Node root = new Node();

            Trie(String[] words) {
                for (String word : words) {
                    Node curr = root;
                    for (int i = 0; i < word.length(); i++) {
                        curr = curr.branches.computeIfAbsent(word.charAt(i), __ -> new Node());
                        curr.score++;
                    }
                }
            }

            int getSumOfPrefixScores(String word) {
                int sum = 0;
                Node curr = root;
                for (int i = 0; i < word.length(); i++) {
                    curr = curr.branches.get(word.charAt(i));
                    sum += curr.score;
                }
                return sum;
            }

            static class Node {
                final Map<Character, Node> branches = new HashMap<>();
                int score = 0;
            }
        }
    }
}
