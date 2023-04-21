package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/profitable-schemes/">Profitable Schemes (Hard)</a>
 * <p>
 * There is a group of n members, and a list of various crimes they could commit.
 * The ith crime generates a profit[i] and requires group[i] members to participate in it.
 * If a member participates in one crime, that member can't participate in another crime.
 * <p>
 * Let's call a profitable scheme any subset of these crimes that generates at least minProfit profit,
 * and the total number of members participating in that subset of crimes is at most n.
 * <p>
 * Return the number of schemes that can be chosen. Since the answer may be very large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 100</li>
 *  <li>0 <= minProfit <= 100</li>
 *  <li>1 <= group.length <= 100</li>
 *  <li>1 <= group[i] <= 100</li>
 *  <li>profit.length == group.length</li>
 *  <li>0 <= profit[i] <= 100</li>
 * </ul>
 */
public interface ProfitableSchemes {

    int profitableSchemes(int n, int minProfit, int[] group, int[] profit);

    // O(N * G * min_profit) time | O(N * G * min_profit) space
    class ProfitableSchemesRev1 implements ProfitableSchemes {

        private static final int MOD = 1_000_000_007;

        @Override
        public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
            // DP top-down
            int g = group.length;
            Integer[][][] dp = new Integer[n + 1][g][minProfit + 1];
            return count(n, 0, minProfit, group, profit, dp);
        }

        private int count(int people, int idx, int profitToMake, int[] group, int[] profit, Integer[][][] dp) {
            int g = group.length;

            if (idx == g) {
                return (profitToMake == 0) ? 1 : 0;
            }

            // already solved?
            if (dp[people][idx][profitToMake] != null) {
                return dp[people][idx][profitToMake];
            }

            int count = 0;

            // option #1: take the i-th scheme
            if (people >= group[idx]) {
                count += count(people - group[idx], idx + 1, Math.max(profitToMake - profit[idx], 0), group, profit, dp);
            }

            // option #2: skip the i-th scheme
            count += count(people, idx + 1, profitToMake, group, profit, dp);
            count %= MOD;

            // cache and return the answer
            return dp[people][idx][profitToMake] = count;
        }
    }
}
