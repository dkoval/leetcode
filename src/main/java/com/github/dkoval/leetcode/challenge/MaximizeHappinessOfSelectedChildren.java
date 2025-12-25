package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximize-happiness-of-selected-children/">Maximize Happiness of Selected Children</a>
 * <p>
 * You are given an array happiness of length n, and a positive integer k.
 * <p>
 * There are n children standing in a queue, where the ith child has happiness value happiness[i].
 * You want to select k children from these n children in k turns.
 * <p>
 * In each turn, when you select a child, the happiness value of all the children that have not been selected till now
 * decreases by 1. Note that the happiness value cannot become negative and gets decremented only if it is positive.
 * <p>
 * Return the maximum sum of the happiness values of the selected children you can achieve by selecting k children.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n == happiness.length <= 2 * 10^5</li>
 *  <li>1 <= happiness[i] <= 10^8</li>
 *  <li>1 <= k <= n</li>
 * </ul>
 */
public interface MaximizeHappinessOfSelectedChildren {

    long maximumHappinessSum(int[] happiness, int k);

    // O(N*logN) time | O(1) space
    class MaximizeHappinessOfSelectedChildrenRev1 implements MaximizeHappinessOfSelectedChildren {

        @Override
        public long maximumHappinessSum(int[] happiness, int k) {
            final var n = happiness.length;

            // greedy
            Arrays.sort(happiness);

            var total = 0L;
            var penalty = 0;
            for (var i = n - 1; i >= n - k; i--) {
                final var curr = Math.max(happiness[i] - penalty, 0);
                total += curr;
                if (curr == 0) {
                    break;
                }
                penalty++;
            }
            return total;
        }
    }
}
