package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/count-hills-and-valleys-in-an-array/">Count Hills and Valleys in an Array</a>
 * <p>
 * You are given a 0-indexed integer array nums. An index i is part of a hill in nums if the closest non-equal neighbors of i are smaller than nums[i].
 * Similarly, an index i is part of a valley in nums if the closest non-equal neighbors of i are larger than nums[i].
 * Adjacent indices i and j are part of the same hill or valley if nums[i] == nums[j].
 * <p>
 * Note that for an index to be part of a hill or valley, it must have a non-equal neighbor on both the left and right of the index.
 * <p>
 * Return the number of hills and valleys in nums.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= nums.length <= 100</li>
 *  <li>1 <= nums[i] <= 100</li>
 * </ul>
 */
public interface CountHillsAndValleysInArray {

    int countHillValley(int[] nums);

    // O(N) time | O(N) space
    class CountHillsAndValleysInArrayRev1 implements CountHillsAndValleysInArray {

        @Override
        public int countHillValley(int[] nums) {
            // preprocess the input array to remove adjacent duplicates
            final var arr = new ArrayList<Integer>();
            for (var x : nums) {
                if (arr.isEmpty() || arr.getLast() != x) {
                    arr.add(x);
                }
            }

            var count = 0;
            for (var i = 1; i < arr.size() - 1; i++) {
                if (arr.get(i) > arr.get(i - 1) && arr.get(i) > arr.get(i + 1)) {
                    // +1 hill
                    count++;
                } else if (arr.get(i) < arr.get(i - 1) && arr.get(i) < arr.get(i + 1)) {
                    // +1 valley
                    count++;
                }
            }
            return count;
        }
    }
}
