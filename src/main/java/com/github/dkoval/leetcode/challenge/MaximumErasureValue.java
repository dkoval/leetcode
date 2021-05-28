package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href=" * <a>https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/601/week-4-may-22nd-may-28th/3758/</a>">Maximum Erasure Value</a>
 * <p>
 * You are given an array of positive integers nums and want to erase a subarray containing unique elements.
 * The score you get by erasing the subarray is equal to the sum of its elements.
 * <p>
 * Return the maximum score you can get by erasing exactly one subarray.
 * <p>
 * An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is,
 * if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
 */
public class MaximumErasureValue {

    // O(N) time | O(N) space
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> frequency = new HashMap<>();
        int maxSum = 0, currSum = 0;
        // sliding window containing only unique elements
        int l = 0, r = 0;
        while (r < n) {
            frequency.put(nums[r], frequency.getOrDefault(nums[r], 0) + 1);
            currSum += nums[r];

            // shift left boundary until there is no duplicates left in a subarray nums[l:r]
            while (frequency.get(nums[r]) > 1) {
                frequency.put(nums[l], frequency.get(nums[l]) - 1);
                currSum -= nums[l];
                l++;
            }

            r++;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
