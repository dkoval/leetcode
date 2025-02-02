package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/">Check if Array Is Sorted and Rotated</a>
 * <p>
 * Given an array nums, return true if the array was originally sorted in non-decreasing order,
 * then rotated some number of positions (including zero). Otherwise, return false.
 * <p>
 * There may be duplicates in the original array.
 * <p>
 * Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length],
 * where % is the modulo operation.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>1 <= nums[i] <= 100</li>
 * </ul>
 */
public interface CheckIfArrayIsSortedAndRotated {

    boolean check(int[] nums);

    // O(N^2) time | O(1) space
    class CheckIfArrayIsSortedAndRotatedRev1 implements CheckIfArrayIsSortedAndRotated {

        @Override
        public boolean check(int[] nums) {
            final var n = nums.length;

            // brute force: check if it is possible for a sorted array to start from each position
            var sorted = false;
            for (var start = 0; start < n && !sorted; start++) {
                sorted = true;
                for (var i = 1; i < n; i++) {
                    if (nums[(start + i) % n] < nums[(start + i - 1) % n]) {
                        sorted = false;
                        break;
                    }
                }
            }
            return sorted;
        }
    }

    // O(N) time | O(1) space
    class CheckIfArrayIsSortedAndRotatedRev2 implements CheckIfArrayIsSortedAndRotated {

        @Override
        public boolean check(int[] nums) {
            final var n = nums.length;

            // 3, 4, 5, 1, 2
            //       |--|
            // nums[i] > nums[i + 1]
            // this is allowed at most 1 time
            int count = 0;
            for (var i = 0; i < n; i++) {
                if (nums[i] > nums[(i + 1) % n]) {
                    count++;
                }

                if (count > 1) {
                    return false;
                }
            }

            return true;
        }
    }
}
