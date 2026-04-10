package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/">Minimum Distance Between Three Equal Elements I</a>
 * <p>
 * You are given an integer array nums.
 * <p>
 * A tuple (i, j, k) of 3 distinct indices is good if nums[i] == nums[j] == nums[k].
 * <p>
 * The distance of a good tuple is abs(i - j) + abs(j - k) + abs(k - i), where abs(x) denotes the absolute value of x.
 * <p>
 * Return an integer denoting the minimum possible distance of a good tuple. If no good tuples exist, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n == nums.length <= 100</li>
 *  <li>1 <= nums[i] <= n</li>
 * </ul>
 */
public interface MinimumDistanceBetweenThreeEqualElements1 {

    int minimumDistance(int[] nums);

    class MinimumDistanceBetweenThreeEqualElements1Rev1 implements MinimumDistanceBetweenThreeEqualElements1 {

        @Override
        public int minimumDistance(int[] nums) {
            final var n = nums.length;

            final var groups = new HashMap<Integer, List<Integer>>();
            for (var i = 0; i < n; i++) {
                groups.computeIfAbsent(nums[i], __ -> new ArrayList<>()).add(i);
            }

            var best = Integer.MAX_VALUE;
            for (var group : groups.values()) {
                best = Math.min(best, process(group));
            }
            return (best == Integer.MAX_VALUE) ? -1 : best;
        }

        private int process(List<Integer> group) {
            if (group.size() < 3) {
                return Integer.MAX_VALUE;
            }

            Collections.sort(group);
            var best = Integer.MAX_VALUE;
            for (var i = 0; i <= group.size() - 3; i++) {
                best = Math.min(best, distance(group.get(i), group.get(i + 1), group.get(i + 2)));
            }
            return best;
        }

        private int distance(int i, int j, int k) {
            return Math.abs(i - j) + Math.abs(j - k) + Math.abs(i - k);
        }
    }
}
