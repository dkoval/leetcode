package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/calculate-digit-sum-of-a-string/">Calculate Digit Sum of a String</a>
 * <p>
 * You are given a string s consisting of digits and an integer k.
 * <p>
 * A round can be completed if the length of s is greater than k. In one round, do the following:
 * <p>
 * Divide s into consecutive groups of size k such that the first k characters are in the first group,
 * the next k characters are in the second group, and so on. Note that the size of the last group can be smaller than k.
 * <p>
 * Replace each group of s with a string representing the sum of all its digits.
 * For example, "346" is replaced with "13" because 3 + 4 + 6 = 13.
 * <p>
 * Merge consecutive groups together to form a new string. If the length of the string is greater than k, repeat from step 1.
 * <p>
 * Return s after all rounds have been completed.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 100</li>
 *  <li>2 <= k <= 100</li>
 *  <li>s consists of digits only.</li>
 * </ul>
 */
public interface CalculateDigitSumOfString {

    String digitSum(String s, int k);

    class CalculateDigitSumOfStringRev1 implements CalculateDigitSumOfString {

        @Override
        public String digitSum(String s, int k) {
            var current = s;
            while (current.length() > k) {
                current = process(current, k);
            }
            return current;
        }

        private String process(String s, int k) {
            final var n = s.length();

            final var sb = new StringBuilder();
            for (var start = 0; start < n; start += k) {
                var sum = 0;
                for (var i = start; i < Math.min(start + k, n); i++) {
                    sum += s.charAt(i) - '0';
                }
                sb.append(sum);
            }
            return sb.toString();
        }
    }
}
