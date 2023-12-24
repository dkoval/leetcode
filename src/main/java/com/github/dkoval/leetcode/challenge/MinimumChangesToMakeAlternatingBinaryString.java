package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/">Minimum Changes To Make Alternating Binary String</a>
 * <p>
 * You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.
 * <p>
 * The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.
 * <p>
 * Return the minimum number of operations needed to make s alternating.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^4</li>
 *  <li>s[i] is either '0' or '1'.</li>
 * </ul>
 */
public interface MinimumChangesToMakeAlternatingBinaryString {

    int minOperations(String s);

    class MinimumChangesToMakeAlternatingBinaryStringRev1 implements MinimumChangesToMakeAlternatingBinaryString {

        @Override
        public int minOperations(String s) {
            int first = s.charAt(0) - '0';
            // option #1: leave s[0] as is
            // option #2: flip s[0]
            return Math.min(countFlips(s, first), countFlips(s, (first + 1) % 2) + 1);
        }

        private int countFlips(String s, int first) {
            int count = 0;
            int prev = first;
            for (int i = 1; i < s.length(); i++) {
                int curr = s.charAt(i) - '0';
                if (curr == prev) {
                    curr = (prev + 1) % 2;
                    count++;
                }
                prev = curr;
            }
            return count;
        }
    }
}
