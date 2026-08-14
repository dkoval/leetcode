package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/">Maximum Length Substring With Two Occurrences</a>
 * <p>
 * Given a string s, return the maximum length of a substring such that it contains at most two occurrences of each character.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= s.length <= 100</li>
 *  <li>s consists only of lowercase English letters.</li>
 * </ul>
 */
public interface MaximumLengthSubstringWithTwoOccurrences {

    int maximumLengthSubstring(String s);

    // O(N^2) time | O(1) space
    class MaximumLengthSubstringWithTwoOccurrencesRev1 implements MaximumLengthSubstringWithTwoOccurrences {

        @Override
        public int maximumLengthSubstring(String s) {
            final var n = s.length();

            var best = 0;
            for (var left = 0; left < n; left++) {
                final var counts = new int[26];
                for (var right = left; right < n; right++) {
                    if (++counts[s.charAt(right) - 'a'] > 2) {
                        break;
                    }
                    best = Math.max(best, right - left + 1);
                }
            }
            return best;
        }
    }

    // O(N) time | O(1) space
    class MaximumLengthSubstringWithTwoOccurrencesRev2 implements MaximumLengthSubstringWithTwoOccurrences {

        @Override
        public int maximumLengthSubstring(String s) {
            final var n = s.length();

            // idea: sliding window
            var best = 0;
            var counts = new int[26];
            // expand the window to the right
            var left = 0;
            for (var right = 0; right < n; right++) {
                counts[s.charAt(right) - 'a']++;
                // shrink the window to maintain the constraint
                while (!isGood(counts)) {
                    counts[s.charAt(left) - 'a']--;
                    left++;
                }
                best = Math.max(best, right - left + 1);
            }
            return best;
        }

        private boolean isGood(int[] counts) {
            for (var count : counts) {
                if (count > 2) {
                    return false;
                }
            }
            return true;
        }
    }
}
