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
            // idea: prefix sum
            final var n = customers.length();

            final var yes = new int[n];
            final var no = new int[n];

            yes[0] = match(customers, 0, 'Y');
            no[0] = match(customers, 0, 'N');
            for (var i = 1; i < n; i++) {
                yes[i] = yes[i - 1] + match(customers, i, 'Y');
                no[i] = no[i - 1] + match(customers, i, 'N');
            }

            // shop closes at the i-th hour
            var bestPenalty = n;
            var bestHourToClose = n;
            for (var i = 0; i < n; i++) {
                var penalty = 0;
                // shop is open until i-th hour but no customers come
                penalty += (i > 0) ? no[i - 1] : 0;
                // shop is closed from i-th hour but customers come
                penalty += yes[n - 1] - (i > 0 ? yes[i - 1] : 0);

                // minimize the penalty
                if (penalty < bestPenalty) {
                    bestPenalty = penalty;
                    bestHourToClose = i;
                }
            }
            return (no[n - 1] < bestPenalty) ? n : bestHourToClose;
        }

        private int match(String customers, int index, char c) {
            return customers.charAt(index) == c ? 1 : 0;
        }
    }

    // O(N) time | O(N) space
    class MinimumPenaltyForShopRev2 implements MinimumPenaltyForShop {

        @Override
        public int bestClosingTime(String customers) {
            int n = customers.length();

            // idea: prefix sum
            // 0 -> 'N'
            // 1 -> 'Y'
            int[][] yesno = new int[2][n];
            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    yesno[0][i] = yesno[0][i - 1];
                    yesno[1][i] = yesno[1][i - 1];
                }
                int b = (customers.charAt(i) == 'Y') ? 1 : 0;
                yesno[b][i]++;
            }

            int minPenalty = Integer.MAX_VALUE;
            int minHour = -1;
            for (int i = 0; i < n; i++) {
                int penalty = yesno[1][n - 1];
                if (i > 0) {
                    penalty -= yesno[1][i - 1];
                    penalty += yesno[0][i - 1];
                }

                if (penalty < minPenalty) {
                    minPenalty = penalty;
                    minHour = i;
                }
            }

            // handle n-th hour
            if (yesno[0][n - 1] < minPenalty) {
                return n;
            }
            return minHour;
        }
    }

    // O(N) time | O(1) space
    class MinimumPenaltyForShopRev3 implements MinimumPenaltyForShop {

        @Override
        public int bestClosingTime(String customers) {
            final var n = customers.length();

            // shop is closed hour 0
            var bestHourToClose = 0;
            var currPenalty = 0;
            for (var i = 0; i < n; i++) {
                if (customers.charAt(i) == 'Y') {
                    currPenalty++;
                }
            }

            // the shop is open at the i-th hour
            var bestPenalty = currPenalty;
            for (var i = 0; i < n; i++) {
                if (customers.charAt(i) == 'Y') {
                    currPenalty--;
                } else {
                    currPenalty++;
                }

                if (currPenalty < bestPenalty) {
                    currPenalty = bestPenalty;
                    bestHourToClose = i + 1;
                }
            }
            return bestHourToClose;
        }
    }

    // O(N) time | O(1) space
    class MinimumPenaltyForShopRev4 implements MinimumPenaltyForShop {

        @Override
        public int bestClosingTime(String customers) {
            final var n = customers.length();

            // for each hour the shop is open, consider
            var leftPenalty = 0; // count of N's
            var rightPenalty = 0; // count of Y's
            for (var i = 0; i < n; i++) {
                if (customers.charAt(i) == 'Y') {
                    rightPenalty++;
                }
            }

            var minPenalty = leftPenalty + rightPenalty;
            var bestHourToClose = 0;

            // the shop is open at the i-th hour
            for (var i = 0; i < n; i++) {
                if (customers.charAt(i) == 'Y') {
                    rightPenalty--;
                } else {
                    leftPenalty++;
                }

                final var currPenalty = leftPenalty + rightPenalty;
                if (currPenalty < minPenalty) {
                    minPenalty = currPenalty;
                    // close the shop at the next hour
                    bestHourToClose = i + 1;
                }
            }
            return bestHourToClose;
        }
    }
}
