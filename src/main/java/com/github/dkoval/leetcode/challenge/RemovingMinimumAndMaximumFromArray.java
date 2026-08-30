package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/removing-minimum-and-maximum-from-array/">Removing Minimum and Maximum From Array</a>
 * <p>
 * You are given a 0-indexed array of distinct integers nums.
 * <p>
 * There is an element in nums that has the lowest value and an element that has the highest value. We call them the minimum and maximum respectively. Your goal is to remove both these elements from the array.
 * <p>
 * A deletion is defined as either removing an element from the front of the array or removing an element from the back of the array.
 * <p>
 * Return the minimum number of deletions it would take to remove both the minimum and maximum element from the array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>-10^5 <= nums[i] <= 10^5</li>
 *  <li>The integers in nums are distinct.</li>
 * </ul>
 */
public interface RemovingMinimumAndMaximumFromArray {

    int minimumDeletions(int[] nums);

    class RemovingMinimumAndMaximumFromArrayRev1 implements RemovingMinimumAndMaximumFromArray {

        @Override
        public int minimumDeletions(int[] nums) {
            final var n = nums.length;

            var min = Integer.MAX_VALUE;
            var indexOfMin = -1;
            var max = Integer.MIN_VALUE;
            var indexOfMax = -1;
            for (var i = 0; i < n; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                    indexOfMin = i;
                }

                if (nums[i] > max) {
                    max = nums[i];
                    indexOfMax = i;
                }
            }

            final var minOfBothIndexes = Math.min(indexOfMin, indexOfMax);
            final var maxOfBothIndexes = Math.max(indexOfMin, indexOfMax);

            var best = n;
            // case 1: both elements are removed by only deleting from the front
            best = Math.min(best, maxOfBothIndexes + 1);
            // case 2: both elements are removed by only deleting from the back
            best = Math.min(best, n - minOfBothIndexes);
            // case 3: delete from the front to remove one of the elements, and delete from the back to remove the other element
            best = Math.min(best, minOfBothIndexes + 1 + n - maxOfBothIndexes);

            return best;
        }
    }
}
