package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/">Maximum Number of Operations to Move Ones to the End</a>
 * <p>
 * You are given a binary string s.
 * <p>
 * You can perform the following operation on the string any number of times:
 * <p>
 * Choose any index i from the string where i + 1 < s.length such that s[i] == '1' and s[i + 1] == '0'.
 * <p>
 * Move the character s[i] to the right until it reaches the end of the string or another '1'. For example,
 * for s = "010010", if we choose i = 1, the resulting string will be s = "000110".
 * <p>
 * Return the maximum number of operations that you can perform.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s[i] is either '0' or '1'.</li>
 * </ul>
 */
public interface MaximumNumberOfOperationsToMoveOnesToEnd {

    int maxOperations(String s);

    class MaximumNumberOfOperationsToMoveOnesToEndRev1 implements MaximumNumberOfOperationsToMoveOnesToEnd {

        @Override
        public int maxOperations(String s) {
            final var n = s.length();

            // contiguous segment of 1's
            var countOnes = 0;
            var ans = 0;
            var i = 0;
            while (i < n) {
                if (s.charAt(i) == '1') {
                    countOnes++;
                } else {
                    // s[i] == '0'
                    // move the segment of 1's as far to the right as possible
                    while (i + 1 < n && s.charAt(i + 1) == '0') {
                        i++;
                    }
                    ans += countOnes;
                }
                i++;
            }
            return ans;
        }
    }
}
