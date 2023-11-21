package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/count-nice-pairs-in-an-array/">Count Nice Pairs in an Array</a>
 * <p>
 * You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x.
 * For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:
 * <ul>
 *  <li>0 <= i < j < nums.length</li>
 *  <li>nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])</li>
 * </ul>
 * Return the number of nice pairs of indices. Since that number can be too large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>0 <= nums[i] <= 10^9</li>
 * </ul>
 */
public interface CountNicePairsInArray {

    int MOD = 1_000_000_007;

    int countNicePairs(int[] nums);

    class CountNicePairsInArrayRev1 implements CountNicePairsInArray {

        @Override
        public int countNicePairs(int[] nums) {
            // 0 <= i < j < N
            // nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
            // nums[j] - rev(nums[j]) == nums[i] - rev(nums[i])
            //                           ---------------------- seen before?
            Map<Integer, Integer> seen = new HashMap<>();
            int total = 0;
            for (int x : nums) {
                int diff = x - rev(x);
                int count = seen.getOrDefault(diff, 0);
                total += count;
                total %= MOD;
                seen.put(diff, count + 1);
            }
            return total;
        }

        private int rev(int x) {
            int rev = 0;
            while (x > 0) {
                rev *= 10;
                rev += x % 10;
                x /= 10;
            }
            return rev;
        }
    }
}
