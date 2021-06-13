package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3777/">Palindrome Pairs</a>
 * <p>
 * Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list,
 * so that the concatenation of the two words words[i] + words[j] is a palindrome.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 5000</li>
 *  <li>0 <= words[i].length <= 300</li>
 *  <li>words[i] consists of lower-case English letters</li>
 * </ul>
 */
public interface PalindromePairs {

    List<List<Integer>> palindromePairs(String[] words);

    // O(N * M^2) time | O(N) space - ?
    class PalindromePairsNaive implements PalindromePairs {

        @Override
        public List<List<Integer>> palindromePairs(String[] words) {
            Map<String, Integer> reverseIndex = reverseIndex(words);
            Set<List<Integer>> result = new HashSet<>();
            for (int i = 0; i < words.length; i++) {
                int m = words[i].length();
                for (int k = 0; k <= m; k++) {
                    // take k first characters of words[i] in reverse order
                    String s = new StringBuilder(words[i].substring(0, k)).reverse().toString();
                    Integer j = reverseIndex.get(s);
                    if (j != null && j != i && isPalindrome(words[i] + s)) {
                        result.add(Arrays.asList(i, j));
                    }

                    // take last k characters of words[i] in reverse order
                    s = new StringBuilder(words[i].substring(m - k)).reverse().toString();
                    j = reverseIndex.get(s);
                    if (j != null && j != i && isPalindrome(s + words[i])) {
                        result.add(Arrays.asList(j, i));
                    }
                }
            }
            return new ArrayList<>(result);
        }

        private Map<String, Integer> reverseIndex(String[] words) {
            Map<String, Integer> result = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                result.put(words[i], i);
            }
            return result;
        }

        private boolean isPalindrome(String s) {
            int n = s.length();
            for (int i = 0; i < n / 2; i++) {
                if (s.charAt(i) != s.charAt(n - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }
}
