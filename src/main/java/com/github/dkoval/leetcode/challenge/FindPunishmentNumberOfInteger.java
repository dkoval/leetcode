package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-the-punishment-number-of-an-integer/">Find the Punishment Number of an Integer</a>
 * <p>
 * Given a positive integer n, return the punishment number of n.
 * <p>
 * The punishment number of n is defined as the sum of the squares of all integers i such that:
 * <ul>
 *  <li>1 <= i <= n</li>
 *  <li>The decimal representation of i * i can be partitioned into contiguous substrings such that the sum of the integer values of these substrings equals i.</li>
 * </ul>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 */
public interface FindPunishmentNumberOfInteger {

    int punishmentNumber(int n);

    class FindPunishmentNumberOfIntegerRev1 implements FindPunishmentNumberOfInteger {

        @Override
        public int punishmentNumber(int n) {
            var ans = 0;
            for (var i = 1; i <= n; i++) {
                final var square = i * i;
                if (canPartition(Integer.toString(square), 0, 0, i)) {
                    ans += square;
                }
            }
            return ans;
        }

        private boolean canPartition(String s, int start, int sum, int target) {
            if (start == s.length() && sum == target) {
                return true;
            }

            for (var i = start; i < s.length(); i++) {
                final var num = s.substring(start, i + 1);
                if (canPartition(s, i + 1, sum + Integer.parseInt(num), target)) {
                    return true;
                }
            }
            return false;
        }
    }
}
