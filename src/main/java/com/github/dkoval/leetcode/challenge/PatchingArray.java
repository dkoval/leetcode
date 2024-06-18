package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/patching-array/">Patching Array (Hard)</a>
 * <p>
 * Given a sorted integer array nums and an integer n, add/patch elements to the array such that any number
 * in the range [1, n] inclusive can be formed by the sum of some elements in the array.
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
public interface PatchingArray {

    int minPatches(int[] nums, int n);

    // Resource: https://www.youtube.com/watch?v=N-tcCOCNSZY
    class PatchingArrayRev1 implements PatchingArray {

        @Override
        public int minPatches(int[] nums, int n) {
            int i = 0;
            int patches = 0;
            long maxReachableNum = 0; // denotes range of covered numbers [1 : x]

            while (maxReachableNum < n) {
                long nextNum = maxReachableNum + 1;
                if (i < nums.length && nums[i] <= nextNum) {
                    // extend range of covered numbers [1 : x] by nums[i] steps making it [1 : x + nums[i]]
                    maxReachableNum += nums[i++];
                } else {
                    // adding (x + 1) to nums[] extends range of covered numbers up till x + (x + 1) = 2 * x + 1
                    // 1, ..., x, (x + 1), ..., (2 * x + 1), ...
                    //         ^   -----    ->   ---------
                    maxReachableNum += nextNum;
                    // patch nums[] by adding x = (maxReachable + 1) to it
                    patches++;
                }
            }
            return patches;
        }
    }

    class PatchingArrayRev2 implements PatchingArray {

        @Override
        public int minPatches(int[] nums, int n) {
            // idea: greedily extend interval [0, end] to cover numbers [1, n]
            long end = 0;
            int patches = 0;
            for (int x : nums) {
                // want to include the next number y = end + 1
                while (end < n && end + 1 < x) {
                    // patch the array with y = (end + 1) and extend interval to [0, end + y]
                    patches++;
                    end += end + 1;
                }
                // now, we can take x and extend interval to cover [0, end + x]
                end += x;
            }

            // out of numbers but still have numbers to cover
            while (end < n) {
                patches++;
                end += end + 1;
            }
            return patches;
        }
    }
}
