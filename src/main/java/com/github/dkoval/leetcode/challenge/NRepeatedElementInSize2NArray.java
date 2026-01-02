package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/n-repeated-element-in-size-2n-array/">N-Repeated Element in Size 2N Array</a>
 * <p>
 * You are given an integer array nums with the following properties:
 * <ul>
 *  <li>nums.length == 2 * n.</li>
 *  <li>nums contains n + 1 unique elements.</li>
 *  <li>Exactly one element of nums is repeated n times.</li>
 * </ul>
 * Return the element that is repeated n times.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n <= 5000</li>
 *  <li>nums.length == 2 * n</li>
 *  <li>0 <= nums[i] <= 10^4</li>
 *  <li>nums contains n + 1 unique elements and one of them is repeated exactly n times.</li>
 * </ul>
 */
public interface NRepeatedElementInSize2NArray {

    int repeatedNTimes(int[] nums);

    class NRepeatedElementInSize2NArrayRev1 implements NRepeatedElementInSize2NArray {

        @Override
        public int repeatedNTimes(int[] nums) {
            final var seen = new HashSet<Integer>();
            for (var x : nums) {
                if (seen.contains(x)) {
                    return x;
                }
                seen.add(x);
            }
            return -1;
        }
    }
}
