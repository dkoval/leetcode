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
            final var n = nums.length;
            Arrays.sort(nums);

            var count = 0;
            for (var k = n - 1; k >= 2; k--) {
                // a = nums[i], b = nums[j], c = nums[k]
                var i = 0;
                var j = k - 1;
                while (i < j) {
                    if (nums[i] + nums[j] > nums[k]) {
                        // since nums[] is sorted in asc order,
                        // inequality a + nums[j] > nums[k] holds true for all a's in nums[i : j - 1].
                        //                  ^ = b     ^ = c
                        // The total number of (i, j) pairs that satisfy the inequality = (j - 1) - i + 1 = j - i
                        count += j - i;
                        j--;
                    } else {
                        i++;
                    }
                }
            }
            return count;
        }
    }
}
