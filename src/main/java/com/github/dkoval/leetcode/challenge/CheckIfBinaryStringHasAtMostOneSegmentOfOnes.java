package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/">Check if Binary String Has at Most One Segment of Ones</a>
 * <p>
 * Given a binary string s without leading zeros, return true if s contains at most one contiguous segment of ones. Otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 100</li>
 *  <li>s[i] is either '0' or '1'.</li>
 *  <li>s[0] is '1'.</li>
 * </ul>
 */
public interface CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

    boolean checkOnesSegment(String s);

    class CheckIfBinaryStringHasAtMostOneSegmentOfOnesRev1 implements CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

        @Override
        public boolean checkOnesSegment(String s) {
            final var n = s.length();

            var segments = 0;
            var prev = '#';
            for (var i = 0; i < n; i++) {
                final var curr = s.charAt(i);

                if (curr == prev) {
                    continue;
                }

                if (curr == '1' || prev == '#') {
                    segments++;
                }

                // early termination: if we have more than 1 segment of ones, then we can return false
                if (segments > 1) {
                    return false;
                }
                prev = curr;
            }
            return true;
        }
    }
}
