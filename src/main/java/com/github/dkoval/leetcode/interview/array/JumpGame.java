package com.github.dkoval.leetcode.interview.array;

/**
 * <a href="https://leetcode.com/problems/jump-game/">Jump Game</a>
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 */
public abstract class JumpGame {

    public abstract boolean canJump(int[] nums);

    // Time complexity: O(2^N). There are 2^N (upper bound) ways of jumping from the first position to the last,
    // where N is the length of array nums.
    // Space complexity : O(N). Recursion requires additional memory for the stack frames.
    public static class JumpGameRecursiveTLE extends JumpGame {

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
            for (int nextIdx = idx + 1; nextIdx <= furthestIdx; nextIdx++) {
                if (canJump(nextIdx, nums)) {
                    return true;
                }
            }
            return false;
        }
    }

    // Time complexity : O(N^2). For every element in the array, say i, we are looking at the next nums[i] number of elements to
    // its right aiming to find a GOOD index. nums[i] can be at most N, where nn is the length of array nums.
    // Space complexity : O(2N) = O(N). First N originates from recursion. Second N comes from the usage of the memo table.
    public static class JumpGameDPTopDown extends JumpGame {

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
            for (int nextIdx = furthestIdx; nextIdx > idx; nextIdx--) {
                if (canJump(nextIdx, nums, memo)) {
                    memo[idx] = true;
                    return true;
                }
            }
            memo[idx] = false;
            return false;
        }
    }

    public static class JumpGameDPBottomUp extends JumpGame {

        @Override
        public boolean canJump(int[] nums) {
            // Top-down to bottom-up conversion is done by eliminating recursion.
            // In practice, this achieves better performance as we no longer have the method stack overhead.
            // The recursion is usually eliminated by trying to reverse the order of the steps from the top-down approach.
            boolean[] memo = new boolean[nums.length];
            memo[nums.length - 1] = true;
            for (int i = nums.length - 2; i >= 0; i--) {
                int furthestIdx = Math.min(i + nums[i], nums.length - 1);
                for (int j = i + 1; j <= furthestIdx; j++) {
                    if (memo[j]) {
                        memo[i] = true;
                        break;
                    }
                }
            }
            return memo[0];
        }
    }
}
