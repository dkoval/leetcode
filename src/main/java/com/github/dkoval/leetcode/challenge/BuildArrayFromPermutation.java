package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/build-array-from-permutation/">Build Array from Permutation</a>
 * <p>
 * Given a zero-based permutation nums (0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]]
 * for each 0 <= i < nums.length and return it.
 * <p>
 * A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>0 <= nums[i] < nums.length</li>
 *  <li>The elements in nums are distinct</li>
 * <ul>
 * Follow-up: Can you solve it without using an extra space (i.e., O(1) memory)?
 */
public interface BuildArrayFromPermutation {

    int[] buildArray(int[] nums);

    class BuildArrayFromPermutationRev1 implements BuildArrayFromPermutation {

        @Override
        public int[] buildArray(int[] nums) {
            final var n = nums.length;

            final var ans = new int[n];
            for (var i = 0; i < n; i++) {
                ans[i] = nums[nums[i]];
            }
            return ans;
        }
    }

    // O(1) space complexity solution
    class BuildArrayFromPermutationRev2 implements BuildArrayFromPermutation {

        @Override
        public int[] buildArray(int[] nums) {
            final int n = nums.length;

            // First pass: encode both original and new values in the same array
            // Store nums[i] + n * nums[nums[i]] at each position
            for (int i = 0; i < n; i++) {
                // nums[i] is stored as a remainder when divided by n
                // nums[nums[i]] is stored as quotient when divided by n
                nums[i] += n * (nums[nums[i]] % n);
            }

            // Second pass: extract the new values
            for (int i = 0; i < n; i++) {
                nums[i] /= n;
            }

            return nums;
        }
    }
}
