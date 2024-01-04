package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/">Minimum Number of Operations to Make Array Empty</a>
 * <p>
 * You are given a 0-indexed array nums consisting of positive integers.
 * <p>
 * There are two types of operations that you can apply on the array any number of times:
 * <ul>
 *  <li>Choose two elements with equal values and delete them from the array.</li>
 *  <li>Choose three elements with equal values and delete them from the array.</li>
 * </ul>
 * Return the minimum number of operations required to make the array empty, or -1 if it is not possible.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^6</li>
 * </ul>
 */
public interface MinimumNumberOfOperationsToMakeArrayEmpty {

    int minOperations(int[] nums);

    class MinimumNumberOfOperationsToMakeArrayEmptyRev1 implements MinimumNumberOfOperationsToMakeArrayEmpty {

        @Override
        public int minOperations(int[] nums) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int x : nums) {
                counts.put(x, counts.getOrDefault(x, 0) + 1);
            }

            int ops = 0;
            for (int count : counts.values()) {
                if (count % 3 == 0) {
                    ops += count / 3;
                    continue;
                }

                int res = factor(count);
                if (res == -1) {
                    return -1;
                }
                ops += res;
            }
            return ops;
        }

        private int factor(int x) {
            if (x == 1) {
                return -1;
            }

            // x = d3 * 3 + d2 * 2
            int d3 = (x - 2) / 3;
            int d2 = (x - d3 * 3) / 2;
            return d3 + d2;
        }
    }
}
