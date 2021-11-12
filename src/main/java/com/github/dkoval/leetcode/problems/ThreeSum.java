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

    // O(N^2) time | O(1) space
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
            int target = -nums[i];
            // nums[] is sorted, hence binary search on nums[i + 1 : n - 1]
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum > target) {
                    // decrementing r will reduce the triplet sum
                    r--;
                } else if (sum < target) {
                    // incrementing l will increase the triplet sum
                    l++;
                } else {
                    // don't break the loop here since we may find yet another triplet in [l : r] range
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    // skip over duplicates from both sides
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (r > l && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}
