package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/">Minimize Maximum Pair Sum in Array</a>
 * <p>
 * The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.
 * <p>
 * For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
 * Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:
 * <ul>
 *  <li>Each element of nums is in exactly one pair, and</li>
 *  <li>The maximum pair sum is minimized.</li>
 * </ul>
 * Return the minimized maximum pair sum after optimally pairing up the elements.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == nums.length</li>
 *  <li>2 <= n <= 10^5</li>
 *  <li>n is even</li>
 *  <li>1 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface MinimizeMaximumPairSumInArray {

    int minPairSum(int[] nums);

    class MinimizeMaximumPairSumInArrayRev1 implements MinimizeMaximumPairSumInArray {

        @Override
        public int minPairSum(int[] nums) {
            Arrays.sort(nums);

            int best = Integer.MIN_VALUE;
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                best = Math.max(best, nums[left] + nums[right]);
                left++;
                right--;
            }
            return best;
        }
    }

    class MinimizeMaximumPairSumInArrayRev2 implements MinimizeMaximumPairSumInArray {

        @Override
        public int minPairSum(int[] nums) {
            final var n = nums.length;

            // sorted array allows us to minimize the result
            Arrays.sort(nums);

            var best = -1;
            for (var i = 0; i < n / 2; i++) {
                // pair the i-th smallest element with the i-th largest
                best = Math.max(best, nums[i] + nums[n - i - 1]);
            }
            return best;
        }
    }
}
