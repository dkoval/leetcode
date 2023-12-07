package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/largest-odd-number-in-string/">Largest Odd Number in String</a>
 * <p>
 * You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is
 * a non-empty substring of num, or an empty string "" if no odd integer exists.
 * <p>
 * A substring is a contiguous sequence of characters within a string.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= num.length <= 10^5</li>
 *  <li>num only consists of digits and does not contain any leading zeros.</li>
 * </ul>
 */
public interface LargestOddNumberInString {

    String largestOddNumber(String num);

    // O(N) time | O(1) extra spase
    class LargestOddNumberInStringRev1 implements LargestOddNumberInString {

        @Override
        public String largestOddNumber(String num) {
            int end = -1;
            for (int i = 0; i < num.length(); i++) {
                int digit = num.charAt(i) - '0';
                if (digit % 2 != 0) {
                    end = i;
                }
            }

            if (end == num.length() - 1) {
                return num;
            }

            return (end >= 0) ? num.substring(0, end + 1) : "";
        }
    }
}
