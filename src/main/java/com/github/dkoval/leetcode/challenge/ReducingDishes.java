package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/reducing-dishes/">Reducing Dishes (Hard)</a>
 * <p>
 * A chef has collected data on the satisfaction level of his n dishes. Chef can cook any dish in 1 unit of time.
 * <p>
 * Like-time coefficient of a dish is defined as the time taken to cook that dish including previous dishes multiplied by
 * its satisfaction level i.e. time[i] * satisfaction[i].
 * <p>
 * Return the maximum sum of like-time coefficient that the chef can obtain after dishes preparation.
 * <p>
 * Dishes can be prepared in any order and the chef can discard some dishes to get this maximum value.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == satisfaction.length</li>
 *  <li>1 <= n <= 500</li>
 *  <li>-1000 <= satisfaction[i] <= 1000</li>
 * </ul>
 */
public interface ReducingDishes {

    int maxSatisfaction(int[] satisfaction);

    // O(N) time | O(1) space
    class ReducingDishesRev1 implements ReducingDishes {

        @Override
        public int maxSatisfaction(int[] satisfaction) {
            // idea: greedy
            int n = satisfaction.length;
            Arrays.sort(satisfaction);

            // input:  [-1,-8,0,5,-9]
            // sorted: [-9,-8,-1,0,5]
            //                     1 = 5 * 1 = 5
            //                   1 2 = 0 * 1 + 5 * 2 = 11
            //                 1 2 3 = -1 * 1 + 0 * 2 + 5 * 3 = -1 + (0 * 1 + 5 * 2) + (0 + 5 + 2) = 14 <- answer
            //               1 2 3 4 = -8 * 1 + -1 * 2 + 0 * 3 + 5 * 4 = -8 + (-1 * 1 + 0 * 2 + 5 * 3) + (-1 + 0 + 5 + 2) = 10 (drop)
            //             1 2 3 4 5 = even lower value
            int ans = 0;
            int sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                int curr = satisfaction[i];
                curr += ans;
                curr += sum;

                if (curr < ans) {
                    break;
                }

                sum += satisfaction[i];
                ans = curr;
            }
            return ans;
        }
    }
}
