package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/3sum/">3Sum</a>
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            // skip over duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // fix nums[i] and find solution to 2 sum problem: nums[j] + nums[k] = -nums[i]
            int targetSum = -nums[i];
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (sum > targetSum) {
                    hi--;
                } else if (sum < targetSum) {
                    lo++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    // skip over duplicates
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    lo++;
                    hi--;
                }
            }
        }
        return result;
    }
}
