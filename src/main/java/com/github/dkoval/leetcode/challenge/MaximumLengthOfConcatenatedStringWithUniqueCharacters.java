package com.github.dkoval.leetcode.challenge;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/">Maximum Length of a Concatenated String with Unique Characters</a>
 * <p>
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 * <p>
 * Return the maximum possible length of s.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length <= 16</li>
 *  <li>1 <= arr[i].length <= 26</li>
 *  <li>arr[i] contains only lower case English letters</li>
 * </ul>
 */
public interface MaximumLengthOfConcatenatedStringWithUniqueCharacters {

    int maxLength(List<String> arr);

    class MaximumLengthOfConcatenatedStringWithUniqueCharactersRev1 implements MaximumLengthOfConcatenatedStringWithUniqueCharacters {

        @Override
        public int maxLength(List<String> arr) {
            int n = arr.size();

            // masks[i] represents unique characters in arr[i] string;
            // masks[i] = -1 denotes that arr[i] string has repeatable characters
            int[] masks = new int[n];
            for (int i = 0; i < n; i++) {
                String s = arr.get(i);;
                int mask = 0;
                boolean allUnique = true;
                for (int k = 0; k < s.length(); k++) {
                    char c = s.charAt(k);
                    int bit = c - 'a';
                    int offset = (1 << bit);
                    if ((mask & offset) != 0) {
                        // c is a non-unique character in arr[i]
                        allUnique = false;
                        break;
                    } else {
                        mask |= offset;
                    }
                }
                masks[i] = allUnique ? mask : -1;
            }

            return dfs(arr, 0, 0, masks);
        }

        private int dfs(List<String> arr, int idx, int mask, int[] masks) {
            if (idx >= arr.size()) {
                return Integer.bitCount(mask);
            }

            int best = 0;

            // option #1: skip arr[idx] string
            int maxLengthIfSkip = dfs(arr, idx + 1, mask, masks);
            best = Math.max(best, maxLengthIfSkip);

            // option #2: take arr[idx] string, if it doesn't lead to duplicate characters
            if (masks[idx] != -1 && (mask & masks[idx]) == 0) {
                int maxLengthIfTake = dfs(arr, idx + 1, mask | masks[idx], masks);
                best = Math.max(best, maxLengthIfTake);
            }

            return best;
        }
    }
}
