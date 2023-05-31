package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/new-21-game/">New 21 Game</a>
 * <p>
 * Alice plays the following game, loosely based on the card game "21".
 * <p>
 * Alice starts with 0 points and draws numbers while she has less than k points.
 * During each draw, she gains an integer number of points randomly from the range [1, maxPts], where maxPts is an integer.
 * Each draw is independent and the outcomes have equal probabilities.
 * <p>
 * Alice stops drawing numbers when she gets k or more points.
 * <p>
 * Return the probability that Alice has n or fewer points.
 * <p>
 * Answers within 10^-5 of the actual answer are considered accepted.
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= k <= n <= 10^4</li>
 *  <li>1 <= maxPts <= 10^4</li>
 * </ul>
 */
public interface New21Game {

    double new21Game(int n, int k, int maxPts);

    class New21GameDPBottomUp implements New21Game {

        @Override
        public double new21Game(int n, int k, int maxPts) {
            // P(i) - probability that Alice has i points
            // P(1) = P(2) = ... = P(maxPts) = 1 / maxPts - probability of drawing x points from the range [1, maxPts]
            //
            // Game stops if score >= k, therefore
            // ans = P(n) + P(n - 1) + ... + P(k)
            //
            // P(i) = P(k - 1) * P(i - k + 1) + ... + P(i - maxPts - 1) * P(maxPts - 1) + P(i - maxPts) * P(maxPts)
            //          ^ max score Alice can get before the game ends
            // = (P(k - 1) + P(k - 2) + ... + P(i - maxPts)) / maxPts, where (i - k + 1) is in [1, maxPts] range
            //
            // idea: DP + sliding window
            if (k == 0 || k + maxPts <= n) {
                return 1.0;
            }

            double[] dp = new double[n + 1];
            dp[0] = 1.0;
            double total = 0.0;
            for (int i = 1; i <= n; i++) {
                if (i - 1 < k) {
                    total += dp[i - 1];
                }
                if (i > maxPts) {
                    total -= dp[i - maxPts - 1];
                }
                dp[i] = total / maxPts;
            }

            double ans = 0.0;
            for (int i = k; i <= n; i++) {
                ans += dp[i];
            }
            return ans;
        }
    }
}
