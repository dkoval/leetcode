package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/617/week-5-august-29th-august-31st/3956/">Patching Array (Hard)</a>
 * <p>
 * Given a sorted integer array nums and an integer n, add/patch elements to the array such that any number in the range [1, n]
 * inclusive can be formed by the sum of some elements in the array.
 * <p>
 * Return the minimum number of patches required.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>1 <= nums[i] <= 10^4</li>
 *  <li>nums is sorted in ascending order</li>
 *  <li>1 <= n <= 2^31 - 1</li>
 * </ul>
 */
public class PatchingArray {

    // Resource: https://www.youtube.com/watch?v=N-tcCOCNSZY&t=889s
    public int minPatches(int[] nums, int n) {
        int i = 0;
        int count = 0;
        long maxReachableNum = 0; // denotes range of covered numbers [1:x]

        while (maxReachableNum < n) {
            if (i < nums.length && nums[i] <= maxReachableNum + 1) {
                // extend range of covered numbers [1:x] by nums[i] steps making it [1 : x + nums[i]]
                maxReachableNum += nums[i];
                // proceed to the next number
                i++;
            } else {
                // adding (x + 1) to nums[] extends range of covered numbers up till x + (x + 1) = 2 * x + 1
                // 1, ..., x, (x + 1), ..., (2 * x + 1), ...
                //         ^   -----    ->   ---------
                maxReachableNum += maxReachableNum + 1;
                // patch nums[] by adding x = (maxReachable + 1) to it
                count++;
            }
        }
        return count;
    }
}
