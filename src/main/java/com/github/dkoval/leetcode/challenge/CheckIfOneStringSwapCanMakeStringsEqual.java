package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/">Check if One String Swap Can Make Strings Equal</a>
 * <p>
 * You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices
 * in a string (not necessarily different) and swap the characters at these indices.
 * <p>
 * Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings.
 * Otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s1.length, s2.length <= 100</li>
 *  <li>s1.length == s2.length</li>
 *  <li>s1 and s2 consist of only lowercase English letters.</li>
 * </ul>
 */
public interface CheckIfOneStringSwapCanMakeStringsEqual {

    boolean areAlmostEqual(String s1, String s2);

    class CheckIfOneStringSwapCanMakeStringsEqualRev1 implements CheckIfOneStringSwapCanMakeStringsEqual {

        @Override
        public boolean areAlmostEqual(String s1, String s2) {
            final var n = s1.length();

            var count = 0;
            final var mismatches = new int[]{-1, -1};
            for (var i = 0; i < n; i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    continue;
                }
                if (++count > 2) {
                    return false;
                }
                mismatches[count - 1] = i;
            }

            if (count < 2) {
                return count == 0;
            }

            return (s1.charAt(mismatches[0]) == s2.charAt(mismatches[1]))
                    && (s1.charAt(mismatches[1]) == s2.charAt(mismatches[0]));
        }
    }
}
