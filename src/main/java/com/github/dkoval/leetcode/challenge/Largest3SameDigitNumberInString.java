package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/largest-3-same-digit-number-in-string/">Largest 3-Same-Digit Number in String</a>
 * <p>
 * You are given a string num representing a large integer. An integer is good if it meets the following conditions:
 * <ul>
 *  <li>It is a substring of num with length 3.</li>
 *  <li>It consists of only one unique digit.</li>
 * </ul>
 * Return the maximum good integer as a string or an empty string "" if no such integer exists.
 * <p>
 * Note:
 * <ul>
 *  <li>A substring is a contiguous sequence of characters within a string.</li>
 *  <li>There may be leading zeroes in num or a good integer.</li>
 * </ul>
 */
public interface Largest3SameDigitNumberInString {

    String largestGoodInteger(String num);

    // O(N) time | O(1) space
    class Largest3SameDigitNumberInStringRev1 implements Largest3SameDigitNumberInString {

        @Override
        public String largestGoodInteger(String num) {
            int n = num.length();

            int left = 0;
            int right = 0;
            int best = -1;
            while (right < n) {
                while (right < n && num.charAt(right) == num.charAt(left)) {
                    right++;
                }

                if (right - left >= 3) {
                    best = Math.max(best, num.charAt(left) - '0');
                }
                left = right;
            }

            if (best != -1) {
                return String.valueOf(best).repeat(3);
            }
            return "";
        }
    }

    // O(N) time | O(1) space
    class Largest3SameDigitNumberInStringRev2 implements Largest3SameDigitNumberInString {

        @Override
        public String largestGoodInteger(String num) {
            final var n = num.length();
            var best = -1;
            for (var left = 0; left <= n - 3; left++) {
                var found = true;
                for (var right = left + 1; right < left + 3; right++) {
                    if (num.charAt(right) != num.charAt(left)) {
                        found = false;
                        break;
                    }
                }

                if (!found) {
                    continue;
                }

                best = Math.max(best, num.charAt(left) - '0');
            }
            return (best == -1) ? "" : String.valueOf(best).repeat(3);
        }
    }
}
