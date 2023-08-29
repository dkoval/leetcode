package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-penalty-for-a-shop/">Minimum Penalty for a Shop</a>
 * <p>
 * You are given the customer visit log of a shop represented by a 0-indexed string customers consisting only of characters 'N' and 'Y':
 * <ul>
 *  <li>if the ith character is 'Y', it means that customers come at the ith hour</li>
 *  <li>whereas 'N' indicates that no customers come at the ith hour.</li>
 * </ul>
 * If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:
 * <ul>
 *  <li>For every hour when the shop is open and no customers come, the penalty increases by 1.</li>
 *  <li>For every hour when the shop is closed and customers come, the penalty increases by 1.</li>
 * </ul>
 * Return the earliest hour at which the shop must be closed to incur a minimum penalty.
 * <p>
 * Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= customers.length <= 10^5</li>
 *  <li>customers consists only of characters 'Y' and 'N'.</li>
 * </ul>
 */
public interface MinimumPenaltyForShop {

    int bestClosingTime(String customers);

    // O(N) time | O(N) space
    class MinimumPenaltyForShopRev1 implements MinimumPenaltyForShop {

        @Override
        public int bestClosingTime(String customers) {
            int n = customers.length();

            // idea: prefix sum
            int[] yes = new int[n];
            int[] no = new int[n];
            for (int i = 0; i < n; i++) {
                char c = customers.charAt(i);
                yes[i] = (i > 0 ? yes[i - 1] : 0) + (c == 'Y' ? 1 : 0);
                no[i] = (i > 0 ? no[i - 1] : 0) + (c == 'N' ? 1 : 0);
            }

            int bestPenalty = Integer.MAX_VALUE;
            int bestClosingHour = -1;
            for (int i = 0; i < n; i++) {
                int penalty = 0;
                penalty += yes[n - 1] - (i > 0 ? yes[i - 1] : 0);
                penalty += (i > 0) ? no[i - 1] : 0;
                if (penalty < bestPenalty) {
                    bestPenalty = penalty;
                    bestClosingHour = i;
                }
            }

            // handle n-th hour
            if (no[n - 1] < bestPenalty) {
                return n;
            }
            return bestClosingHour;
        }
    }
}
