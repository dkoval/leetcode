package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/"> </a>
 * <p>
 * Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and return the number of different
 * non-empty subsets with the maximum bitwise OR.
 * <p>
 * An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
 * Two subsets are considered different if the indices of the elements chosen are different.
 * <p>
 * The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 16</li>
 *  <li>1 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface CountNumberOfMaximumBitwiseORSubsets {

    int countMaxOrSubsets(int[] nums);

    class CountNumberOfMaximumBitwiseORSubsetsRev1 implements CountNumberOfMaximumBitwiseORSubsets {

        @Override
        public int countMaxOrSubsets(int[] nums) {
            // max bitwise-or
            int target = 0;
            for (int x : nums) {
                target |= x;
            }
            // DP top-down; caching is not needed due to light constraints
            return calc(nums, 0, 0, target);
        }

        private int calc(int[] nums, int index, int current, int target) {
            if (index == nums.length) {
                return (current == target) ? 1 : 0;
            }

            int count = 0;
            // option #1: take nums[index]
            count += calc(nums, index + 1, current | nums[index], target);
            // option #2: skip nums[index]
            count += calc(nums, index + 1, current, target);
            return count;
        }
    }

    class CountNumberOfMaximumBitwiseORSubsetsRev2 implements CountNumberOfMaximumBitwiseORSubsets {

        @Override
        public int countMaxOrSubsets(int[] nums) {
            // max bitwise-or
            int target = 0;
            for (int x : nums) {
                target |= x;
            }

            int count = 0;

            // Generate all possible subsets.
            // Instead of recording subsets themselves, keep track of their bitwise-or.
            List<Integer> subsets = new ArrayList<>();
            subsets.add(0); // start with an empty subset
            for (int x : nums) {
                List<Integer> newSubsets = new ArrayList<>();
                for (int subset : subsets) {
                    int current = subset | x;
                    newSubsets.add(current);
                    if (current == target) {
                        count++;
                    }
                }
                subsets.addAll(newSubsets);
            }
            return count;
        }
    }
}
