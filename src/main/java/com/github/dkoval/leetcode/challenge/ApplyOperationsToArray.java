package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/apply-operations-to-the-array/">Apply Operations to the Array</a>
 * <p>
 * You are given a 0-indexed array nums of size n consisting of non-negative integers.
 * <p>
 * You need to apply n - 1 operations to this array where, in the ith operation (0-indexed), you will apply the following on the ith element of nums:
 * <p>
 * If nums[i] == nums[i + 1], then multiply nums[i] by 2 and set nums[i + 1] to 0. Otherwise, you skip this operation.
 * After performing all the operations, shift all the 0's to the end of the array.
 * <p>
 * For example, the array [1,0,2,0,0,1] after shifting all its 0's to the end, is [1,2,1,0,0,0].
 * <p>
 * Return the resulting array.
 * <p>
 * Note that the operations are applied sequentially, not all at once.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 2000</li>
 *  <li>0 <= nums[i] <= 1000</li>
 * </ul>
 */
public interface ApplyOperationsToArray {

    int[] applyOperations(int[] nums);

    class ApplyOperationsToArrayRev1 implements ApplyOperationsToArray {

        @Override
        public int[] applyOperations(int[] nums) {
            final var n = nums.length;

            for (var i = 0; i < n - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    nums[i] *= 2;
                    nums[i + 1] = 0;
                }
            }

            var zeroIndex = 0;
            while (zeroIndex < n && nums[zeroIndex] != 0) {
                zeroIndex++;
            }

            var i = zeroIndex + 1;
            while (i < n) {
                if (nums[i] != 0) {
                    nums[zeroIndex] = nums[i];
                    nums[i] = 0;
                    zeroIndex++;
                }
                i++;
            }

            return nums;
        }
    }

    class ApplyOperationsToArrayRev2 implements ApplyOperationsToArray {

        @Override
        public int[] applyOperations(int[] nums) {
            final var n = nums.length;

            for (var i = 0; i < n - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    nums[i] *= 2;
                    nums[i + 1] = 0;
                }
            }

            var left = 0; // index of the leftmost zero
            for (var right = 0; right < n; right++) {
                while (left < right && nums[left] != 0) {
                    left++;
                }

                if (nums[right] != 0) {
                    var tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                }
            }

            return nums;
        }
    }
}
