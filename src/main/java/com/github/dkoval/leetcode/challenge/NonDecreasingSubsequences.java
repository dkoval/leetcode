package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/non-decreasing-subsequences/">Non-decreasing Subsequences</a>
 * <p>
 * Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements.
 * You may return the answer in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 15</li>
 *  <li>-100 <= nums[i] <= 100</li>
 * </ul>
 */
public interface NonDecreasingSubsequences {

    List<List<Integer>> findSubsequences(int[] nums);

    class NonDecreasingSubsequencesRev1 implements NonDecreasingSubsequences {

        // O(2^N * N)
        @Override
        public List<List<Integer>> findSubsequences(int[] nums) {
            Set<List<Integer>> ans = new HashSet<>();
            // -100 <= nums[i] <= 100
            generateSubsequences(nums, 0, -101, new ArrayList<>(), ans);
            return new ArrayList<>(ans);
        }

        private void generateSubsequences(int[] nums, int idx, int lastNum, List<Integer> subseq, Set<List<Integer>> ans) {
            if (idx == nums.length) {
                if (subseq.size() >= 2) {
                    ans.add(new ArrayList<>(subseq));
                }
                return;
            }

            // option #1: take nums[idx]
            if (nums[idx] >= lastNum) {
                subseq.add(nums[idx]);
                generateSubsequences(nums, idx + 1, nums[idx], subseq, ans);
                subseq.remove(subseq.size() - 1); // backtrack
            }

            // option #2: skip nums[idx]
            generateSubsequences(nums, idx + 1, lastNum, subseq, ans);
        }
    }
}
