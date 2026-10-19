package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * <a href="https://leetcode.com/problems/find-target-indices-after-sorting-array/">Find Target Indices After Sorting Array</a>
 * <p>
 * You are given a 0-indexed integer array nums and a target element target.
 * <p>
 * A target index is an index i such that nums[i] == target.
 * <p>
 * Return a list of the target indices of nums after sorting nums in non-decreasing order.
 * If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>1 <= nums[i], target <= 100</li>
 * </ul>
 */
public interface FindTargetIndicesAfterSortingArray {

    List<Integer> targetIndices(int[] nums, int target);

    class FindTargetIndicesAfterSortingArrayRev1 implements FindTargetIndicesAfterSortingArray {

        @Override
        public List<Integer> targetIndices(int[] nums, int target) {
            Arrays.sort(nums);
            return find(nums, target);
        }

        private List<Integer> find(int[] nums, int target) {
            final var n = nums.length;

            var left = 0;
            var right = n - 1;
            while (left <= right) {
                final var mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    final var start = findLeftmostIndex(nums, target, mid - 1);
                    final var end = findRightmostIndex(nums, target, mid + 1);
                    return range(start, end);
                }
            }
            return emptyList();
        }

        private int findLeftmostIndex(int[] nums, int target, int startIndex) {
            var i = startIndex;
            while (i >= 0 && nums[i] == target) {
                i--;
            }
            return i + 1;
        }

        private int findRightmostIndex(int[] nums, int target, int startIndex) {
            var i = startIndex;
            while (i < nums.length && nums[i] == target) {
                i++;
            }
            return i - 1;
        }

        private List<Integer> range(int start, int end) {
            final var res = new ArrayList<Integer>();
            for (var i = start; i <= end; i++) {
                res.add(i);
            }
            return res;
        }
    }
}
