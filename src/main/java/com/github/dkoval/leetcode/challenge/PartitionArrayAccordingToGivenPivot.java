package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/partition-array-according-to-given-pivot/">Partition Array According to Given Pivot</a>
 * <p>
 * You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:
 * <ul>
 *  <li>Every element less than pivot appears before every element greater than pivot.</li>
 *  <li>Every element equal to pivot appears in between the elements less than and greater than pivot.</li>
 *  <li>The relative order of the elements less than pivot and the elements greater than pivot is maintained.</li>
 * </ul>
 * More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth element.
 * If i < j and both elements are smaller (or larger) than pivot, then pi < pj.
 * <p>
 * Return nums after the rearrangement.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>-106 <= nums[i] <= 10^6</li>
 *  <li>pivot equals to an element of nums</li>
 * </ul>
 */
public interface PartitionArrayAccordingToGivenPivot {

    int[] pivotArray(int[] nums, int pivot);

    // O(N) time | O(N) space
    class PartitionArrayAccordingToGivenPivotRev1 implements PartitionArrayAccordingToGivenPivot {

        @Override
        public int[] pivotArray(int[] nums, int pivot) {
            final var n = nums.length;

            final var ans = new int[n];
            var i = 0;

            final var greater = new ArrayList<Integer>();
            var same = 0;
            for (var x : nums) {
                if (x < pivot) {
                    ans[i++] = x;
                } else if (x > pivot) {
                    greater.add(x);
                } else {
                    same++;
                }
            }

            while (same-- > 0) {
                ans[i++] = pivot;
            }

            for (var x : greater) {
                ans[i++] = x;
            }

            return ans;
        }
    }
}
