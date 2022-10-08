package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/3sum-closest/">3Sum Closest</a>
 * <p>
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= nums.length <= 10^3</li>
 *  <li>-10^3 <= nums[i] <= 10^3</li>
 *  <li>-10^4 <= target <= 10^4</li>
 * </ul>
 */
public interface ThreeSumClosest {

    int threeSumClosest(int[] nums, int target);

    // O(N^2) time | O(1) space
    class ThreeSumClosestRev1 implements ThreeSumClosest {

        @Override
        public int threeSumClosest(int[] nums, int target) {
            int n = nums.length;
            Arrays.sort(nums);

            int closestSum3 = nums[0] + nums[1] + nums[n - 1];
            for (int i = 0; i < n - 2; i++) {
                int l = i + 1;
                int r = n - 1;
                while (l < r) {
                    int currSum3 = nums[i] + nums[l] + nums[r];
                    if (currSum3 < target) {
                        // go to the next largest element
                        l++;
                    } else {
                        // go to the next smallest element
                        r--;
                    }
                    if (Math.abs(currSum3 - target) < Math.abs(closestSum3 - target)) {
                        closestSum3 = currSum3;
                    }
                }
            }
            return closestSum3;
        }
    }

    // O(N^2) time | O(1) space
    class ThreeSumClosestRev2 implements ThreeSumClosest {

        @Override
        public int threeSumClosest(int[] nums, int target) {
            int n = nums.length;
            Arrays.sort(nums);

            int bestSum = 42;
            int bestDiff = Integer.MAX_VALUE;
            for (int i = 0; i < n - 2; i++) {
                int left = i + 1;
                int right = n - 1;
                while (left < right) {
                    int currSum = nums[left] + nums[right] + nums[i];
                    int currDiff = Math.abs(target - currSum);
                    if (currDiff < bestDiff) {
                        bestSum = currSum;
                        bestDiff = currDiff;
                    }

                    if (currSum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return bestSum;
        }
    }
}
