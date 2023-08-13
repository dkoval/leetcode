package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/">Check if There is a Valid Partition For The Array</a>
 * <p>
 * You are given a 0-indexed integer array nums. You have to partition the array into one or more contiguous subarrays.
 * <p>
 * We call a partition of the array valid if each of the obtained subarrays satisfies one of the following conditions:
 * <ol>
 *  <li>The subarray consists of exactly 2 equal elements. For example, the subarray [2,2] is good.</li>
 *  <li>The subarray consists of exactly 3 equal elements. For example, the subarray [4,4,4] is good.</li>
 *  <li>The subarray consists of exactly 3 consecutive increasing elements, that is, the difference between adjacent elements is 1.
 *  For example, the subarray [3,4,5] is good, but the subarray [1,3,5] is not.
 *  </li>
 * </ol>
 * Return true if the array has at least one valid partition. Otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^6</li>
 * </ul>
 */
public interface CheckIfThereIsValidPartitionForArray {

    boolean validPartition(int[] nums);

    class CheckIfThereIsValidPartitionForArrayDPTopDown implements CheckIfThereIsValidPartitionForArray {

        @Override
        public boolean validPartition(int[] nums) {
            int n = nums.length;
            Boolean[] dp = new Boolean[n];
            return canPartition(nums, 0, dp);
        }

        private boolean canPartition(int[] nums, int start, Boolean[] dp) {
            int n = nums.length;

            if (start >= n) {
                return true;
            }

            int length = n - start;
            if (length < 2) {
                return false;
            }

            // already solved?
            if (dp[start] != null) {
                return dp[start];
            }

            boolean possible = false;

            // option #1: take 2 elements
            boolean allEqual = true;
            boolean increasing = true;
            int diff = nums[start + 1] - nums[start];
            allEqual &= (diff == 0);
            increasing &= (diff == 1);

            possible |= allEqual && canPartition(nums, start + 2, dp);

            // option #2: take 3 elements
            if (!possible && length >= 3) {
                diff = nums[start + 2] - nums[start + 1];
                allEqual &= (diff == 0);
                increasing &= (diff == 1);
                possible = (allEqual || increasing) && canPartition(nums, start + 3, dp);
            }

            return dp[start] = possible;
        }
    }
}
