package com.github.dkoval.leetcode.problems;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/partition-equal-subset-sum/">Partition Equal Subset Sum</a>
 * <p>
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements
 * in both subsets is equal or false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 200</li>
 *  <li>1 <= nums[i] <= 100</li>
 * </ul>
 */
public interface PartitionEqualSubsetSum {

    boolean canPartition(int[] nums);

    class PartitionEqualSubsetSumRev2 implements PartitionEqualSubsetSum {

        @Override
        public boolean canPartition(int[] nums) {
            var total = 0;
            for (var x : nums) {
                total += x;
            }

            if (total % 2 != 0) {
                return false;
            }

            final var target = total / 2;

            // seen sums
            final var sums = new HashSet<Integer>();
            sums.add(0);

            // generate sums of all possible subsets
            for (int x : nums) {
                final var newSums = new HashSet<Integer>();
                for (var sum : sums) {
                    if (x + sum == target) {
                        return true;
                    }
                    newSums.add(x + sum);
                }
                sums.addAll(newSums);
            }
            return false;
        }
    }
}
