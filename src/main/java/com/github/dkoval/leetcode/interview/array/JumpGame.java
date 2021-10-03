package com.github.dkoval.leetcode.interview.array;

/**
 * <a href="https://leetcode.com/problems/jump-game/">Jump Game</a>
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^4</li>
 *  <li>0 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface JumpGame {

    boolean canJump(int[] nums);

    // Time complexity: O(2^N). There are 2^N (upper bound) ways of jumping from the first position to the last,
    // where N is the length of array nums.
    // Space complexity : O(N). Recursion requires additional memory for the stack frames.
    class JumpGameRecursiveTLE implements JumpGame {

        @Override
        public boolean canJump(int[] nums) {
            return canJump(0, nums);
        }

        private boolean canJump(int idx, int[] nums) {
            // We start from the first position and jump to every index that is reachable.
            // We repeat the process until last index is reached. When stuck, backtrack.
            if (idx == nums.length - 1) {
                return true;
            }
            int furthestIdx = Math.min(idx + nums[idx], nums.length - 1);
            for (int i = furthestIdx; i > idx; i--) {
                if (canJump(i, nums)) {
                    return true;
                }
            }
            return false;
        }
    }

    // Time complexity : O(N^2). For every element in the array, say i, we are looking at the next nums[i] number of elements to
    // its right aiming to find a GOOD index. nums[i] can be at most N, where N is the length of array nums.
    // Space complexity : O(2N) = O(N). First N originates from recursion. Second N comes from the usage of the memo table.
    class JumpGameDPTopDown implements JumpGame {

        @Override
        public boolean canJump(int[] nums) {
            // Top-down Dynamic Programming can be thought of as optimized backtracking.
            // For each position in the array, we remember whether the index is good or bad.
            Boolean[] memo = new Boolean[nums.length];
            return canJump(0, nums, memo);
        }

        private boolean canJump(int idx, int[] nums, Boolean[] memo) {
            if (idx == nums.length - 1) {
                return true;
            }
            if (memo[idx] != null) {
                return memo[idx];
            }
            int furthestIdx = Math.min(idx + nums[idx], nums.length - 1);
            for (int i = furthestIdx; i > idx; i--) {
                if (canJump(i, nums, memo)) {
                    memo[idx] = true;
                    return true;
                }
            }
            memo[idx] = false;
            return false;
        }
    }

    // O(N^2) time | O(N) space
    class JumpGameDPBottomUp implements JumpGame {

        @Override
        public boolean canJump(int[] nums) {
            // Top-down to bottom-up conversion is done by eliminating recursion.
            // In practice, this achieves better performance as we no longer have the method stack overhead.
            // The recursion is usually eliminated by trying to reverse the order of the steps from the top-down approach.
            int n = nums.length;

            // dp[i] - denotes whether the last index is reachable from i-th index
            boolean[] dp = new boolean[n];
            dp[n - 1] = true;

            for (int i = n - 2; i >= 0; i--) {
                int furthestIdx = Math.min(i + nums[i], n - 1);
                for (int j = furthestIdx; j > i; j--) {
                    if (dp[j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[0];
        }
    }
}
