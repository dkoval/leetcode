package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-subarrays-with-fixed-bounds/">Count Subarrays With Fixed Bounds (Hard)</a>
 * <p>
 * You are given an integer array nums and two integers minK and maxK.
 * <p>
 * A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
 * <ul>
 *  <li>The minimum value in the subarray is equal to minK.</li>
 *  <li>The maximum value in the subarray is equal to maxK.</li>
 * </ul>
 * Return the number of fixed-bound subarrays.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i], minK, maxK <= 10^6</li>
 * </ul>
 */
public interface CountSubarraysWithFixedBounds {

    long countSubarrays(int[] nums, int minK, int maxK);

    class CountSubarraysWithFixedBoundsRev1 implements CountSubarraysWithFixedBounds {

        @Override
        public long countSubarrays(int[] nums, int minK, int maxK) {
            final var n = nums.length;

            var count = 0L;
            var currMinKIndex = -1;
            var currMaxKIndex = -1;
            // nums[left:] is a subarray to be checked
            var left = 0;
            for (var i = 0; i < n; i++) {
                if (nums[i] < minK || nums[i] > maxK) {
                    left = i + 1;
                    continue;
                }

                if (nums[i] == minK) {
                    currMinKIndex = i;
                }

                if (nums[i] == maxK) {
                    currMaxKIndex = i;
                }

                if (currMinKIndex >= left && currMaxKIndex >= left) {
                    // ... a ...[b ... c], where nums[b:c] is a fixed-bound subarray
                    //     ^     ^     ^
                    //     L     R     T = max(currMinKIndex, currMaxKIndex)
                    //     <->
                    //     <-->
                    //     <--->
                    //     <----->
                    // subarrays nums[L : T], nums[L + 1 : T], ..., nums[R : T] are all valid
                    final var right = Math.min(currMinKIndex, currMaxKIndex);
                    count += right - left + 1;
                }
            }
            return count;
        }
    }
}
