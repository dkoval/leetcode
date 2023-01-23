package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/3sum/">3Sum</a>
 * <p>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= nums.length <= 3000</li>
 *  <li>-10^5 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface ThreeSum {

    List<List<Integer>> threeSum(int[] nums);

    // O(N^2) time | O(1) space
    class ThreeSumRev1 implements ThreeSum {

        @Override
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);

            List<List<Integer>> ans = new ArrayList<>();
            // need at least 3 numbers for the problem to have a solution
            for (int i = 0; i <= n - 3; i++) {
                // skip over duplicates
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                // fix nums[i] and find solution to 2sum problem: nums[j] + nums[k] = -nums[i];
                // nums[] is sorted, hence we can binary search in nums[i + 1 : n - 1]
                int target = -nums[i];
                int j = i + 1;
                int k = n - 1;
                while (j < k) {
                    // skip over duplicates from both sides
                    while (j > i + 1 && j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    while (k < n - 1 && k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }

                    if (j >= k) {
                        break;
                    }

                    int sum = nums[j] + nums[k];
                    if (sum < target) {
                        // incrementing j will increase the triplet sum
                        j++;
                    } else if (sum > target) {
                        // decrementing k will reduce the triplet sum
                        k--;
                    } else {
                        // don't break the loop here since we may find yet another triplet in [j : k] range
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                    }
                }
            }
            return ans;
        }
    }
}
