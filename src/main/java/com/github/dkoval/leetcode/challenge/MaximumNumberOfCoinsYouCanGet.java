package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-coins-you-can-get/">Maximum Number of Coins You Can Get</a>
 * <p>
 * There are 3n piles of coins of varying size, you and your friends will take piles of coins as follows:
 * <ul>
 *  <li>In each step, you will choose any 3 piles of coins (not necessarily consecutive).</li>
 *  <li>Of your choice, Alice will pick the pile with the maximum number of coins.</li>
 *  <li>You will pick the next pile with the maximum number of coins.</li>
 *  <li>Your friend Bob will pick the last pile.</li>
 *  <li>Repeat until there are no more piles of coins.
 * </ul>
 * Given an array of integers piles where piles[i] is the number of coins in the ith pile.
 * <p>
 * Return the maximum number of coins that you can have.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= piles.length <= 10^5</li>
 *  <li>piles.length % 3 == 0</li>
 *  <li>1 <= piles[i] <= 10^4</li>
 * </ul>
 */
public interface MaximumNumberOfCoinsYouCanGet {

    int maxCoins(int[] piles);

    // O(N * logN) time| O(N) space
    class MaximumNumberOfCoinsYouCanGetRev1 implements MaximumNumberOfCoinsYouCanGet {

        @Override
        public int maxCoins(int[] piles) {
            int n = piles.length;
            Arrays.sort(piles);

            // Greedy:
            // - skip (n / 3) smallest elements - to be picked up by Bob;
            // - every 2nd element is yours.
            int total = 0;
            for (int i = n / 3; i < n; i += 2) {
                total += piles[i];
            }
            return total;
        }
    }
}
