package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/the-number-of-beautiful-subsets/">The Number of Beautiful Subsets</a>
 * <p>
 * You are given an array nums of positive integers and a positive integer k.
 * <p>
 * A subset of nums is beautiful if it does not contain two integers with an absolute difference equal to k.
 * <p>
 * Return the number of non-empty beautiful subsets of the array nums.
 * <p>
 * A subset of nums is an array that can be obtained by deleting some (possibly none) elements from nums.
 * Two subsets are different if and only if the chosen indices to delete are different.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 20</li>
 *  <li>1 <= nums[i], k <= 1000</li>
 * </ul>
 */
public interface NumberOfBeautifulSubsets {

    int beautifulSubsets(int[] nums, int k);

    // O(2^N * N) time | O(N) space
    class NumberOfBeautifulSubsetsRev1 implements NumberOfBeautifulSubsets {

        @Override
        public int beautifulSubsets(int[] nums, int k) {
            // idea: use backtracking for generating all possible subsets
            return calc(nums, k, 0, new ArrayList<>());
        }

        private int calc(int[] nums, int k, int index, List<Integer> subset) {
            if (index == nums.length) {
                return subset.isEmpty() ? 0 : 1;
            }

            // option #1: skip nums[i]
            int total = calc(nums, k, index + 1, subset);

            // option #2: take nums[i]
            if (canInclude(subset, k, nums[index])) {
                // add nums[i] to the subset
                subset.add(nums[index]);
                total += calc(nums, k, index + 1, subset);
                // backtrack
                subset.removeLast();
            }
            return total;
        }

        private boolean canInclude(List<Integer> subset, int k, int x) {
            for (int num : subset) {
                if (Math.abs(num - x) == k) {
                    return false;
                }
            }
            return true;
        }
    }
}
