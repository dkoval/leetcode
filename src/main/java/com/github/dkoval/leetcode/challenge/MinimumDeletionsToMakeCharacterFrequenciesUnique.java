package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/">Minimum Deletions to Make Character Frequencies Unique</a>
 * <p>
 * A string s is called good if there are no two different characters in s that have the same frequency.
 * <p>
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 * <p>
 * The frequency of a character in a string is the number of times it appears in the string.
 * For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 105</li>
 *  <li>s contains only lowercase English letters</li>
 * </ul>
 */
public interface MinimumDeletionsToMakeCharacterFrequenciesUnique {

    int minDeletions(String s);

    class MinimumDeletionsToMakeCharacterFrequenciesUniqueRev1 implements MinimumDeletionsToMakeCharacterFrequenciesUnique {

        // O(N) time | O(ALPHA) space
        // N = len(s), ALPHA = 26
        @Override
        public int minDeletions(String s) {
            int n = s.length();

            int[] counts = new int[26];
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                counts[c - 'a']++;
            }

            int ans = 0;
            Set<Integer> seen = new HashSet<>();
            for (int x : counts) {
                if (x == 0) {
                    continue;
                }

                // keep on reducing frequency until it is not unique
                int y = x;
                while (y > 0 && seen.contains(y)) {
                    y--;
                    ans++;
                }
                seen.add(y);
            }
            return ans;
        }
    }
}
