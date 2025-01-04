package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/unique-length-3-palindromic-subsequences/">Unique Length-3 Palindromic Subsequences</a>
 * <p>
 * Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
 * <p>
 * Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
 * <p>
 * A palindrome is a string that reads the same forwards and backwards.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted
 * without changing the relative order of the remaining characters.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= s.length <= 10^5</li>
 *  <li>s consists of only lowercase English letters.</li>
 * </ul>
 */
public interface UniqueLength3PalindromicSubsequences {

    int countPalindromicSubsequence(String s);

    class UniqueLength3PalindromicSubsequencesRev1 implements UniqueLength3PalindromicSubsequences {

        @Override
        public int countPalindromicSubsequence(String s) {
            final var n = s.length();

            final var chars = new HashMap<Character, CharInfo>();
            for (var i = 0; i < n; i++) {
                final var firstIndex = i;
                chars.computeIfAbsent(s.charAt(i), __ -> new CharInfo(firstIndex)).lastIndex = i;
            }

            var count = 0;
            // up to 26 unique chars
            for (final var info : chars.values()) {
                // collect unique chars between the first and the last indices
                final var uniq = new HashSet<>();
                // O(N) time
                for (var i = info.firstIndex + 1; i < info.lastIndex; i++) {
                    uniq.add(s.charAt(i));
                }
                count += uniq.size();
            }
            return count;
        }

        private static class CharInfo {
            final int firstIndex;
            int lastIndex;

            CharInfo(int firstIndex) {
                this.firstIndex = firstIndex;
                this.lastIndex = firstIndex;
            }
        }
    }
}
