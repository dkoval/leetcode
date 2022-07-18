package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/valid-triangle-number/">Valid Triangle Number</a>
 * <p>
 * Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take
 * them as side lengths of a triangle.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>0 <= nums[i] <= 1000</li>
 * </ul>
 */
public interface ValidTriangleNumber {

    int triangleNumber(int[] nums);

    // O(N^2) time | O(1) space
    class ValidTriangleNumberRev1 implements ValidTriangleNumber {

        @Override
        public int triangleNumber(int[] nums) {
            // triplet (a, b, c) form a triangle IFF
            // 1. a + b > c
            // 2. a + c > b
            // 3. b + c > a
            // Assuming a <= b <= c, we only need to check whether a + b > c
            int n = nums.length;
            Arrays.sort(nums);

            int count = 0;
            for (int i = n - 1; i >= 2; i--) {
                int l = 0;
                int r = i - 1;
                while (l < r) {
                    if (nums[l] + nums[r] > nums[i]) {
                        // since nums[] is sorted in asc order, inequality x + nums[r] > nums[i]
                        // holds true for all x in nums[l : r - 1].
                        // The total number of (l, r) pairs that satisfy inequality nums[l] + nums[r] > nums[i]
                        // equals to (r - 1) - l + 1 = r - l
                        count += r - l;
                        r--;
                    } else {
                        l++;
                    }
                }
            }
            return count;
        }
    }
}
