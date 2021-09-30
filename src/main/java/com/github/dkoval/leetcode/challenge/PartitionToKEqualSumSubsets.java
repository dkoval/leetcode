package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/640/week-5-september-29th-september-30th/3993/">Partition to K Equal Sum Subsets</a>
 * <p>
 * Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= k <= nums.length <= 16</li>
 *  <li>1 <= nums[i] <= 10^4</li>
 *  <li>The frequency of each element is in the range [1, 4]</li>
 * </ul>
 */
public interface PartitionToKEqualSumSubsets {

    boolean canPartitionKSubsets(int[] nums, int k);

    class PartitionToKEqualSumSubsetsRecursiveWithBacktracking implements PartitionToKEqualSumSubsets {

        @Override
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = sum(nums);
            if (sum % k != 0) {
                return false;
            }

            int n = nums.length;
            int bucketSum = sum / k;
            return canPartition(nums, 0, k, new boolean[n], 0, bucketSum);
        }

        private int sum(int[] nums) {
            int sum = 0;
            for (int x : nums) {
                sum += x;
            }
            return sum;
        }

        private boolean canPartition(int[] nums, int idx, int k, boolean[] used, int currBucketSum, int targetBucketSum) {
            if (k == 1) {
                return true;
            }

            if (currBucketSum == targetBucketSum) {
                // done with 1 bucket, (k - 1) remain
                return canPartition(nums, 0, k - 1, used, 0, targetBucketSum);
            }

            // explore & backtrack
            for (int i = idx; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }

                // choose nums[i]
                used[i] = true;
                if (canPartition(nums, i + 1, k, used, currBucketSum + nums[i], targetBucketSum)) {
                    return true;
                }
                // un-choose nums[i]
                used[i] = false;
            }
            return false;
        }
    }
}
