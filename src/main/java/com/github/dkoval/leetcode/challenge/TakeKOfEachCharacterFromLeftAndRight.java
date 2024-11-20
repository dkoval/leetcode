package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/">Take K of Each Character From Left and Right</a>
 * <p>
 * You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k.
 * Each minute, you may take either the leftmost character of s, or the rightmost character of s.
 * <p>
 * Return the minimum number of minutes needed for you to take at least k of each character,
 * or return -1 if it is not possible to take k of each character.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists of only the letters 'a', 'b', and 'c'.</li>
 *  <li>0 <= k <= s.length</li>
 * </ul>
 */
public interface TakeKOfEachCharacterFromLeftAndRight {

    int takeCharacters(String s, int k);

    class TakeKOfEachCharacterFromLeftAndRightRev1 implements TakeKOfEachCharacterFromLeftAndRight {

        private static boolean good(int[] counts, int k) {
            for (int i = 0; i < 3; i++) {
                if (counts[i] < k) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int takeCharacters(String s, int k) {
            // corner case
            if (k == 0) {
                return 0;
            }

            int n = s.length();

            // record the number if 'a', 'b' and 'c' in a prefix and suffix of s
            int[] prefix = new int[3];
            int[] suffix = new int[3];

            // start with an empty prefix and compute the longest valid suffix
            int right = n - 1;
            while (right >= 0) {
                suffix[s.charAt(right) - 'a']++;
                if (good(suffix, k)) {
                    break;
                }
                right--;
            }

            // not enough characters to take at least k of each
            if (right < 0) {
                return -1;
            }

            int best = n - right;

            // now, start expanding the prefix and see if we can shrink the suffix
            for (int left = 0; left < n; left++) {
                prefix[s.charAt(left) - 'a']++;
                while (right < n && prefix[s.charAt(right) - 'a'] + suffix[s.charAt(right) - 'a'] > k) {
                    suffix[s.charAt(right) - 'a']--;
                    right++;
                    // combine len(prefix) + len(suffix)
                    best = Math.min(best, left + 1 + n - right);
                }
            }
            return best;
        }
    }
}
