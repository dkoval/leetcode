package com.github.dkoval.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

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
            int sum = 0;
            for (int x : nums) {
                sum += x;
            }

            if (sum % 2 != 0) {
                return false;
            }

            // seen sums
            int target = sum / 2;
            Set<Integer> sums = new HashSet<>();
            sums.add(0);

            for (int x : nums) {
                Set<Integer> newSums = new HashSet<>();
                for (int s : sums) {
                    if (x + s == target) {
                        return true;
                    }
                    newSums.add(s);
                    newSums.add(x + s);
                }
                sums = newSums;
            }
            return false;
        }
    }
}
