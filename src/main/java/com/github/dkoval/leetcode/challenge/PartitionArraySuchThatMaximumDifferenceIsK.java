package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/">Partition Array Such That Maximum Difference Is K</a>
 * <p>
 * You are given an integer array nums and an integer k. You may partition nums into one or more subsequences such that each element in nums appears in exactly one of the subsequences.
 * <p>
 * Return the minimum number of subsequences needed such that the difference between the maximum and minimum values in each subsequence is at most k.
 * <p>
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>0 <= nums[i] <= 10^5</li>
 *  <li>0 <= k <= 10^5</li>
 * </ul>
 */
public interface PartitionArraySuchThatMaximumDifferenceIsK {

    int partitionArray(int[] nums, int k);

    class PartitionArraySuchThatMaximumDifferenceIsKRev1 implements PartitionArraySuchThatMaximumDifferenceIsK {

        @Override
        public int partitionArray(int[] nums, int k) {
            final var n = nums.length;

            // greedy approach
            Arrays.sort(nums);
            var start = 0;
            var numPartitions = 1;
            for (var end = start; end < n; end++) {
                if (nums[end] - nums[start] > k) {
                    start = end;
                    numPartitions++;
                }
            }
            return numPartitions;
        }
    }
}
