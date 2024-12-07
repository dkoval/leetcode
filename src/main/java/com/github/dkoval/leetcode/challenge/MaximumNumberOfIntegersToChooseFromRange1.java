package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/">Maximum Number of Integers to Choose From a Range I</a>
 * <p>
 * You are given an integer array banned and two integers n and maxSum. You are choosing some number of integers following the below rules:
 * <ul>
 *  <li>The chosen integers have to be in the range [1, n].</li>
 *  <li>Each integer can be chosen at most once.</li>
 *  <li>The chosen integers should not be in the array banned.</li>
 *  <li>The sum of the chosen integers should not exceed maxSum.</li>
 * </ul>
 * Return the maximum number of integers you can choose following the mentioned rules.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= banned.length <= 10^4</li>
 *  <li>1 <= banned[i], n <= 10^4</li>
 *  <li>1 <= maxSum <= 10^9</li>
 * </ul>
 */
public interface MaximumNumberOfIntegersToChooseFromRange1 {

    int maxCount(int[] banned, int n, int maxSum);

    class MaximumNumberOfIntegersToChooseFromRange1Rev1 implements MaximumNumberOfIntegersToChooseFromRange1 {

        @Override
        public int maxCount(int[] banned, int n, int maxSum) {
            final var bad = new HashSet<>();
            for (var x : banned) {
                if (x <= n) {
                    bad.add(x);
                }
            }

            var sum = 0;
            var count = 0;
            for (var x = 1; x <= n; x++) {
                if (!bad.contains(x)) {
                    sum += x;
                    if (sum > maxSum) {
                        break;
                    }
                    count++;
                }
            }
            return count;
        }
    }
}
