package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/number-of-good-pairs/">Number of Good Pairs</a>
 * <p>
 * Given an array of integers nums, return the number of good pairs.
 * <p>
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>1 <= nums[i] <= 100</li>
 * </ul>
 */
public interface NumberOfGoodPairs {

    int numIdenticalPairs(int[] nums);

    // O(N) time | O(N) space
    class NumberOfGoodPairsRev1 implements NumberOfGoodPairs {

        @Override
        public int numIdenticalPairs(int[] nums) {
            int n = nums.length;

            // x -> count
            Map<Integer, Integer> uniq = new HashMap<>();
            for (int x : nums) {
                uniq.put(x, uniq.getOrDefault(x, 0) + 1);
            }

            int total = 0;
            for (int count : uniq.values()) {
                // C(n, 2) = n * (n - 1) / 2;
                total += count * (count - 1) / 2;
            }
            return total;
        }
    }
}
