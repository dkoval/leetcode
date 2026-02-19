package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-binary-substrings/">Count Binary Substrings</a>
 * <p>
 * Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's,
 * and all the 0's and all the 1's in these substrings are grouped consecutively.
 * <p>
 * Substrings that occur multiple times are counted the number of times they occur.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 105</li>
 *  <li>s[i] is either '0' or '1'.</li>
 * </ul>
 */
public interface CountBinarySubstrings {

    int countBinarySubstrings(String s);

    // O(N) time | O(1) space
    class CountBinarySubstringsRev1 implements CountBinarySubstrings {

        @Override
        public int countBinarySubstrings(String s) {
            // Let group be a contiguous sequence of 0's (00...0) or 1's (11...1).
            // Given two groups G1 = 000... and G2 = 11..., the number of substrings formed from concatenated G1 + G2 string
            // that have the same number of 0's and 1's is N = min(G1.length, G2.length).
            // Applying the above formula to all (G[i], G[i + 1]) pairs gives us the final count.
            int prevGroupLength = -1;
            int currGroupLength = 1;
            int count = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    if (prevGroupLength != -1) {
                        count += Math.min(prevGroupLength, currGroupLength);
                    }
                    prevGroupLength = currGroupLength;
                    currGroupLength = 1;
                } else {
                    currGroupLength++;
                }
            }
            count += (prevGroupLength > 0) ? Math.min(prevGroupLength, currGroupLength) : 0;
            return count;
        }
    }

    // O(N) time | O(1) space
    class CountBinarySubstringsRev2 implements CountBinarySubstrings {

        @Override
        public int countBinarySubstrings(String s) {
            final var n = s.length();

            var total = 0;
            var counts = new int[2];
            var current = '#';
            for (var i = 0; i < n; i++) {
                if (s.charAt(i) == current) {
                    counts[s.charAt(i) - '0']++;
                    continue;
                }

                total += Math.min(counts[0], counts[1]);
                current = s.charAt(i);
                counts[s.charAt(i) - '0'] = 1;
            }

            // handle the last 2 groups of 0's and 1's
            total += Math.min(counts[0], counts[1]);
            return total;
        }
    }
}
